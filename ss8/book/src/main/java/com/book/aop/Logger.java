package com.book.aop;

import com.book.util.IOFile;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Logger {
    private static int count =0;
    @After("execution(* com.book.controller.BookController.showList(..))")
    public void count(JoinPoint joinPoint) {
        IOFile.writeFile("/main/java/com/book/data/numberOfAccess.csv",String.valueOf(count),false);
    }
}
