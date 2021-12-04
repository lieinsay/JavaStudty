package diy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

// 方式三：使用注解的方式实现Aop
@Aspect
public class AnnotationPointCut {

    @Before("execution(* service.UserServiceImpl.*(..))")
    public void before(){
        System.out.println("================方法执行前================");
    }

    @After("execution(* service.UserServiceImpl.*(..))")
    public void after(){
        System.out.println("================方法执行后================");
    }

    // 在环绕增强中，可以给定一个参数，代表我们要获取处理切入的点
    @Around("execution(* service.UserServiceImpl.*(..))")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕前");

        System.out.println(joinPoint.getSignature());
        joinPoint.proceed();

        System.out.println("环绕后");
    }
}
