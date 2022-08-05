package by.g00dc4t.spring.library.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingDAOAspect {
    private final Logger logger = LogManager.getLogger(LoggingDAOAspect.class.getName());
    private static final String BEGIN = "Begin of ";
    private static final String END = "End of ";

    @Around("execution(* by.g00dc4t.spring.library.dao.*.*(..))")
    public Object aroundAllRepositoryMethodsAdvice(ProceedingJoinPoint proceedingJoinPoint)
            throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String methodName = methodSignature.getName();
        logger.info(BEGIN + methodName);
        Object targetMethodResult = proceedingJoinPoint.proceed();
        logger.info(END + methodName);
        return targetMethodResult;
    }
}
