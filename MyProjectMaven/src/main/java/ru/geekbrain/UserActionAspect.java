package ru.geekbrain;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class UserActionAspect {

    private static final Logger logger = LoggerFactory.getLogger(UserActionAspect.class);

    @Pointcut("@annotation(TrackUserAction)")
    public void trackUserAction() {
    }

    @After("trackUserAction()")
    public void logAfter(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] methodArgs = joinPoint.getArgs();
        String username = "DemoUser"; // Здесь вы должны получить реальное имя пользователя, например из SecurityContextHolder.

        logger.info("User: {}, called method: {} with arguments: {}", username, methodName, Arrays.toString(methodArgs));
    }
}