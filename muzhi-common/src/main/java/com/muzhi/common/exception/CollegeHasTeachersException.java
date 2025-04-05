package com.muzhi.common.exception;

/**
 * 学院存在教师相关异常
 */
public class CollegeHasTeachersException extends RuntimeException {
    public CollegeHasTeachersException(String message) {
        super(message);
    }
}