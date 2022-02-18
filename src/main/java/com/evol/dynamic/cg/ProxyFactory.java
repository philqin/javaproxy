package com.evol.dynamic.cg;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyFactory implements MethodInterceptor {
    private Object target;
    public ProxyFactory(Object target){
        this.target = target;
    }
    //给目标对象创建一个代理对象
    public Object getProxyInstance(Object target){
        //1.工具类
        Enhancer enhancer = new Enhancer();
        //2.设置父类（讲目标对象作为代理对象父类）
        enhancer.setSuperclass(target.getClass());
        //3.设置回调函数
        enhancer.setCallback(this);
        //4.创建子类(代理对象的子类)
        return enhancer.create();
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("操作前...");
        //返回值
        Object reValue =method.invoke(target, objects);
        System.out.println("操作前...");
        return reValue;
    }
}
