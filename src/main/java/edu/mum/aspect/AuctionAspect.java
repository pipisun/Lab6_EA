package edu.mum.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import edu.mum.domain.User;

@Aspect
@Component
public class AuctionAspect {

//	@Pointcut("execution(* edu.mum.service..*(..)) ")
	@Pointcut("execution(* edu.mum.service..*(Long)) ")
//	@Pointcut("within(edu.mum.service.ItemService+) && args(..)")
//	@Pointcut("execServiceMethod()")
	public void execServiceMethod() {
		System.out.println("FindAll is executed");
	}

//	@Pointcut("execution(* edu.mum.service.UserService.save(..)) && args(user) ")
	@Pointcut("within(edu.mum.service.UserService+) && args(user)")
	public void execLogUserResourceMethod(User user) {
		System.out.println("Execute user resource loading");
	}
//	@Pointcut("@annotation(edu.mum.aspect.annotation.Logging)")
//	public void logging() {
//	}
	
//	@Before("logging() && execServiceMethod()")
	@Before("execServiceMethod()")  
//	@Before("execution(* edu.mum.service..*())")
	public void logResource(JoinPoint joinPoint) {
		Logger log = Logger.getLogger("");
		log.info("   **********     TARGET CLASS : " + joinPoint.getSignature().getName() + "    **********");
		System.out.println();
		System.out.println("   **********     TARGET CLASS : " + joinPoint.getSignature().getDeclaringTypeName() + "."
				+ joinPoint.getSignature().getName() + "    **********");
	}
	
//	@Before("execLogUserResourceMethod(user)")
//	public void logResourceName(JoinPoint joinPoint, User user) {
//		System.out.println("   **********     TARGET CLASS : " + joinPoint.getSignature().getDeclaringTypeName() + " "
//				+ user.getFirstName() + " " + user.getLastName() + "    **********");
//	}
}
