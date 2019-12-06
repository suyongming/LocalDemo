package com.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


/**
 * 切面 - 拦截请求验证身份.
 * @author ChenTiny
 */
@Component
@Aspect
@Slf4j
@Order(1)
public class ValidateTokenAspect {

//    /**
//     * 切面表达式.
//     * @author ChenTiny
//     */
//    @Pointcut(value = "execution(* com.controller..*(..))")
//    public void controllerPointCut() {
//
//    }
//
//    /**
//     * 环绕通知.
//     * @param joinPoint 织入点
//     * @return Object
//     * @throws Throwable 异常
//     */
//    @Around("controllerPointCut()")
//    public Object doBeforeRequest(ProceedingJoinPoint joinPoint) throws Throwable {
//
//        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
//        // 判断方法上是否标有@ValidateToken注解
//        if (methodSignature.getMethod().isAnnotationPresent(ValidateToken.class)) {
//
//            ValidateToken annotation = methodSignature.getMethod().getAnnotation(ValidateToken.class);
//
//            if (StringUtils.isNotBlank(annotation.description())) {
//                log.info("方法请求，需要验证openId --->{}", annotation.description());
//            }
//            ServletRequestAttributes sAttributes = (ServletRequestAttributes) RequestContextHolder
//                    .getRequestAttributes();
//            HttpServletRequest request = sAttributes.getRequest();
//
//            String openIdInHeader = request.getHeader("openId");
//            if (StringUtils.isBlank(openIdInHeader)) {
//                return BaseResponse.failure(ErrorEnum.NO_OPENID_IN_HEADER.getDesc());
//            } else {
//                //从redis中获取openId
//                String openIdInRedis = RedisUtil.get(String.format(WeChatConstants.REDIS_PREFIX, openIdInHeader));
//                if (StringUtils.isBlank(openIdInRedis)) {
//                    return BaseResponse.failure(ErrorEnum.NO_OPENID_IN_REDIS.getDesc());
//                } else {
//                    //刷新用户openId过期时间
//                    RedisUtil.expire(String.format(WeChatConstants.REDIS_PREFIX, openIdInRedis),
//                            WeChatConstants.REDIS_EXPIRE_TIME);
//                }
//            }
//        }
//        return joinPoint.proceed();
//    }
}