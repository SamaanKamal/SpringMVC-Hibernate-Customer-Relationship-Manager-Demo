package CustomersList.example.CustomersListDemo.Aspect;

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

	// setup logger
	private  Logger logger = Logger.getLogger(getClass().getName());

	// setup pointcut declarations
	@Pointcut("execution(* CustomersList.example.CustomersListDemo.Controllers.*.*(..))")
	private void forControllerPackage(){}

	// do the same for service and dao
	@Pointcut("execution(* CustomersList.example.CustomersListDemo.Services.*.*(..))")
	private void forServicePackage(){}

	@Pointcut("execution(* CustomersList.example.CustomersListDemo.DAO.*.*(..))")
	private void forDAOPackage(){}

	@Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
	private void forAppFlow(){}

	// add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint joinPoint){

		// display method we are calling
		String theMethod = joinPoint.getSignature().toShortString();
		logger.info("=====>> in @Before: calling method: " + theMethod);

		// display the arguments to the method

		// get the arguments
		Object[] args = joinPoint.getArgs();

		// loop thru and display args
		for(Object tempArg: args){
			logger.info("=====>> argument: " + tempArg);
		}
	}
	
	
	// add @AfterReturning advice
	@AfterReturning(pointcut = "forAppFlow()",returning = "theResult")
	public void afterReturning(JoinPoint joinPoint,Object theResult){

		// display method we are calling
		String theMethod = joinPoint.getSignature().toShortString();
		logger.info("=====>> in @AfterReturning: from method: " + theMethod);

		logger.info("=====>> result: " +theResult);
	}
	
	
	
	
	
	
	
	
}
