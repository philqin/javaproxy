package com.evol.dynamic.jdk;

/**
 * 目标对象。需要实现一个接口
 */
public class DevelopWork implements Work {
    @Override
    public void doThing(String work) {
        System.out.println("开始工作..."+work);
    }
}
