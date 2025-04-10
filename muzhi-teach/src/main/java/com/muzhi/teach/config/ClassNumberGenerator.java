package com.muzhi.teach.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class ClassNumberGenerator {

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 生成班级编号
     *
     * @param prefix 传入的7位编号前缀（如：2350101）
     * @return 完整的9位班级编号（如：235010101）
     */
    public String generateClassNumber(String prefix, String name) {
        // 验证输入格式
        if (!prefix.matches("\\d+")) {
            throw new IllegalArgumentException("前缀必须全为数字");
        }

        // 构造Redis键
        String redisKey = "serial_number:" + name+":" + prefix;

        // 原子递增流水号
        Long serial = redisTemplate.opsForValue().increment(redisKey);

        // 处理首次生成（INCR默认从1开始）
        if (serial == 1L) {
            // 如果需要初始值为0，可以在此处设置为0
            // redisTemplate.opsForValue().set(redisKey, "0");
            // serial = 0L;
        }

//        // 检查流水号范围
//        if (serial > 99L) {
//            throw new RuntimeException("流水号已达最大值99，无法生成新编号");
//        }

        String serialStr;
        if (name.equals("course")){
            // 格式化为三位位流水号
            serialStr = String.format("%03d", serial);
        }else {
            // 格式化为两位流水号
            serialStr = String.format("%02d", serial);
        }

        // 设置键永久有效（默认即为永久）
        redisTemplate.persist(redisKey);

        return prefix + serialStr;
    }

    // 重置流水号
    public void resetSerial(String prefix) {
        String redisKey = "class:serial:" + prefix;
        redisTemplate.delete(redisKey);
    }

    //批量获取
//    @Component
//    public class BatchNumberGenerator {
//        private Map<String, AtomicInteger> localCache = new ConcurrentHashMap<>();
//
//        public synchronized String getNumber(String prefix) {
//            if (localCache.get(prefix) == null || localCache.get(prefix).get() <= 0) {
//                // 从Redis批量获取100个号段
//                Long range = redisTemplate.opsForValue().increment(prefix, 100);
//                localCache.put(prefix, new AtomicInteger(range - 100));
//            }
//            return prefix + String.format("%02d", localCache.get(prefix).incrementAndGet());
//        }
//    }
}