package com.muzhi.teach.aspect;


import com.muzhi.common.enums.BusinessType;
import com.muzhi.common.utils.SecurityUtils;
import com.muzhi.teach.annotation.AutoFill;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 自定义切面，实现公共字段自动填充处理逻辑
 */
@Aspect
@Component
@Slf4j
public class AutoFillAspect {

    /**
     * 切入点
     */
    @Pointcut("execution(* com.muzhi.teach.mapper.*.*(..)) && @annotation(com.muzhi.teach.annotation.AutoFill)")
    public void autoFillPointCut() {
    }

    /**
     * 前置通知，在通知中进行公共字段的赋值
     */
    @Before("autoFillPointCut()")
    public void autoFill(JoinPoint joinPoint) {
        log.info("开始公共字段自动填充");

        //获取到当前被拦截的方法上的数据库操作类型
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();//方法签名对象
        AutoFill autoFill = signature.getMethod().getAnnotation(AutoFill.class);//获得方法上的注解对象
        BusinessType businessType = autoFill.value();//获得数据库操作类型

        //获取到当前被拦截的方法的参数--实体对象
        Object[] args = joinPoint.getArgs();
        if (args == null || args.length == 0) {
            return;
        }

        Object entity = args[0];

        //准备赋值的数据
        String username = SecurityUtils.getUsername();

        if (businessType == BusinessType.INSERT){
            try {
                Method setCreateBy = entity.getClass().getMethod("setCreateBy", String.class);// getDeclaredMethod只会查找本类
                Method setUpdateBy = entity.getClass().getMethod("setUpdateBy", String.class);

                setCreateBy.invoke(entity,username);
                setUpdateBy.invoke(entity,username);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }else {
            try {
                Method setUpdateBy = entity.getClass().getMethod("setUpdateBy", String.class);

                setUpdateBy.invoke(entity,username);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
