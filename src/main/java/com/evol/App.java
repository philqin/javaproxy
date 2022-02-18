package com.evol;

import com.evol.dynamic.cg.Car;
import com.evol.dynamic.cg.ProxyFactory;
import com.evol.dynamic.jdk.DevelopWork;
import com.evol.dynamic.jdk.PoxyInvocationHandler;
import com.evol.dynamic.jdk.Work;
import com.evol.statics.Person;
import com.evol.statics.Proxy;
import com.evol.statics.User;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        //todo 静态代理
        Person person = new User();
        Proxy proxy = new Proxy(person);
        proxy.eat();
        //todo jdk 动态代理
        //创建需要被代理的类
        DevelopWork developWork = new DevelopWork();
        Work work= (Work) new PoxyInvocationHandler().getProxyInstance(developWork);
        work.doThing("开发");
        //todo cglib 动态代理
        Car car = new Car();
        Car target = (Car) new ProxyFactory(car).getProxyInstance(car);
        target.run("运行中...");
    }
}
