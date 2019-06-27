package com.cskaoyan.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class PageInterceptor {
    @Around("execution(* com.cskaoyan.controller..*.*Bypage(..))")
    public Object process(ProceedingJoinPoint point) throws Throwable {
        Object[] args = point.getArgs();
        if(args.length < 2){
            throw new Exception("参数不够分页");
        }
        PageHelper.startPage((Integer)args[args.length-2],(Integer)args[args.length-1]);
        List list = (List) point.proceed();
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }
}
