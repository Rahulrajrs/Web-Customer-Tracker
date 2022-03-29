package com.java.spring.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	//setup logger
	private Logger myLogger=Logger.getLogger(getClass().getName());
	//setup point cut declaration
	@Pointcut("execution(* com.java.spring.controller.*.*(..))")
	public void forControllerPackage(){}
	//do the same for service and DAO package
	@Pointcut("execution(* com.java.spring.service.*.*(..))")
	public void forServicePackage(){}
	@Pointcut("execution(* com.java.spring.dao.*.*(..))")
	public void forDaoPackage(){}
	@Pointcut("forControllerPackage() ||  forServicePackage() || forDaoPackage() ")
	public void forAppFlow(){}
	
	
	// add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint){
		// display method we are calling
		String theMethod=theJoinPoint.getSignature().toShortString();
		myLogger.info("====> in @Before: calling method:"+theMethod);
		// display arguments to the method
		// get the arguments
		Object[] args=theJoinPoint.getArgs();
		// loop through the display arguments
		for(Object tempArgs:args){
			myLogger.info("======>>argument: "+ tempArgs);
		}
		
	}
	
	//add @Afterreturning advice
	@AfterReturning(
			pointcut="forAppFlow()",
			returning="theResult"
			)
	public void afterReturning(JoinPoint theJoinPoint,Object theResult ){
		// display method we are returning from
		String theMethod=theJoinPoint.getSignature().toShortString();
		myLogger.info("====> in @Afterreturning: calling method:"+theMethod);
		myLogger.info("======>>argument: "+ theResult);
	}
	

}
