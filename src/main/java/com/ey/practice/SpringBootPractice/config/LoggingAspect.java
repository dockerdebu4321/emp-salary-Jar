package com.ey.practice.SpringBootPractice.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
@EnableAspectJAutoProxy(exposeProxy = true)
public class LoggingAspect {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Pointcut("within(@org.springframework.stereotype.Service *)"
			+ " || within(@org.springframework.web.bind.annotation.RestController *)")
	public void springBeanPointcut() {
		/* springBeanPointcut creation */
	}
	@Around("springBeanPointcut()")
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		log.info("Enter: {}.{}() with argument[s] = {}", joinPoint.getSignature().getDeclaringTypeName(),
				joinPoint.getSignature().getName(), joinPoint.getArgs());
		Object result = joinPoint.proceed();
		log.info("Exit: {}.{}() with result = {}", joinPoint.getSignature().getDeclaringTypeName(),
				joinPoint.getSignature().getName(), result);

		return result;
	}
	
	@AfterThrowing(pointcut = "springBeanPointcut()", throwing = "e")
	public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
		log.error("Exception in {}.{}() with cause = {}", joinPoint.getSignature().getDeclaringTypeName(),
				joinPoint.getSignature().getName(), e.getMessage());
	}

}



/*	@Before("springBeanPointcut()")
	public void logBeforeEachMethodCall(JoinPoint joinPoint) throws Throwable {
	log.info("Enter: {}.{}() with argument[s] = {}", joinPoint.getSignature().getDeclaringTypeName(),
			joinPoint.getSignature().getName(), joinPoint.getArgs());

}
*/
	


/*
@Pointcut("execution(* com.ctl.opsdb.*.*(..))" + " || execution(* com.ctl.opsdb.controller.*.*(..))"
		+ " || execution(* com.ctl.opsdb.respository.*.*(..))" + " || execution(* com.ctl.opsdb.service.*.*(..))"
		+ " || execution(* com.ctl.opsdb.util.*.*(..))")
public void applicationPackagePointcut() {
	// applicationPackagePointcut creation 

}
*/

/*
@AfterThrowing(pointcut = "applicationPackagePointcut() && springBeanPointcut()", throwing = "e")
public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
	log.error("Exception in {}.{}() with cause = {}", joinPoint.getSignature().getDeclaringTypeName(),
			joinPoint.getSignature().getName(), e.getCause() != null ? e.getCause() : "NULL");
}

@Around("applicationPackagePointcut() && springBeanPointcut()")
public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
	log.info("Enter: {}.{}() with argument[s] = {}", joinPoint.getSignature().getDeclaringTypeName(),
			joinPoint.getSignature().getName(), joinPoint.getArgs());
	Object result = joinPoint.proceed();
	log.info("Exit: {}.{}() with result = {}", joinPoint.getSignature().getDeclaringTypeName(),
			joinPoint.getSignature().getName(), result);
	return result;
}
*/