package com.evol.dynamic.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理对象工厂类，需要在 代理生成参数中创建匿名对象new InvocationHandler()
 */
public class PoxyInvocationFactory {
    private Object target;
    public Object getProxyInstance(final Object target){
        this.target = target;
        //生成动态代理对象
        //参数1 目标对象的类加载器
        //参数2 目标对象所实现的接口
        //参数3  委托类
        //创建被代理类的委托类,之后想要调用被代理类的方法时，都会委托给这个类的invoke(Object proxy, Method method, Object[] args)方法
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                //具体是操作
                System.out.println("工作前整理资料...");
                Object object = method.invoke(target, objects);
                System.out.println("工作完成，下班...");
                return object;
            }
        });
    }

}
