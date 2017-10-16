package com.xjp.aop;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * .
 * 
 * @author xujiping
 * @version 2017年9月19日 上午10:53:35 web日志切面类
 */
@Aspect
@Component
public class WebLogAspect {

  private Logger logger = LoggerFactory.getLogger(getClass());
  ThreadLocal<Long> startTime = new ThreadLocal<>();

  @Pointcut("execution(public * com.xjp.web..*.*(..))")
  public void webLog() {
  }

  /**
   * 运行前执行.
   * 
   * @param joinPoint
   *          切入点
   * @throws Throwable
   *           throwable
   */
  @Before("webLog()")
  public void doBefore(JoinPoint joinPoint) throws Throwable {
    logger.info("================================================================");
    startTime.set(System.currentTimeMillis()); // 记录开始时间
    // 接收到请求，记录请求内容
    ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
        .getRequestAttributes();
    HttpServletRequest request = attributes.getRequest();

    // 记录下请求内容
    logger.info("URL : " + request.getRequestURL().toString());
    logger.info("HTTP_METHOD : " + request.getMethod());
    logger.info("IP : " + request.getRemoteAddr());
    logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "."
        + joinPoint.getSignature().getName());
    logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));

  }

  /**
   * 运行后执行.
   * 
   * @param ret
   *          ret
   * @throws Throwable
   *           throwable
   */
  @AfterReturning(returning = "ret", pointcut = "webLog()")
  public void doAfterReturning(Object ret) throws Throwable {
    // 处理完请求，返回内容
    logger.info("RESPONSE : " + ret);
    logger.info("SPEND TIME : " + (System.currentTimeMillis() - startTime.get()) + "ms");
  }

}
