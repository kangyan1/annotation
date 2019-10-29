package com.example.annotation.aspect;

import com.example.annotation.annnotation.Process;
import com.example.annotation.annnotation.ProcessFiled;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

/**
 * description
 *
 * @author yan.kang@hand-china.com
 * @date 2019/10/29 16:32
 */
@Aspect
@Component
public class ProcessAspect {

    @AfterReturning(value = "@annotation(com.example.annotation.annnotation.Process)", returning = "result")
    public Object afterReturning(JoinPoint proceedingJoinPoint, Object result) throws IllegalAccessException {
        if (result != null) {
            //得到拥有该注解，并且正在运行的方法
            MethodSignature signature = (MethodSignature)proceedingJoinPoint.getSignature();
            Method method = signature.getMethod();
            //得到方法上的注解以及注解里面的参数
            Process annotation = method.getAnnotation(Process.class);
            if(annotation.flag()){
                doAge(result);
            }
            if(annotation.name().equals("kang")){
                System.out.println("kang");
            }
        }
        return result;
    }

    private void doAge(Object result) throws IllegalAccessException {
        //得到该方法的所有字段
        Field[] declaredFields = result.getClass().getDeclaredFields();
        HashMap<String, Object> map = new HashMap<>();
        //筛选出我们对象中需要屏蔽的字段，并加入
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            ProcessFiled annotation = declaredField.getAnnotation(ProcessFiled.class);
            if(annotation!=null){
                //s是字段名，o是字段值
                String s = annotation.targetField();
                Object o = declaredField.get(result);
                List<Field> list = Arrays.asList(declaredFields).stream().filter(e -> e.getName().equals(s)).collect(Collectors.toList());
                Field field = list.get(0);
                field.setAccessible(true);
                field.set(result,o+":十八岁");
                map.put(s,o);
            }
        }
    }
}
