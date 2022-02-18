package com.evol.statics;

/**
 * 目标代理类
 */
public class User implements Person{

    @Override
    public void eat() {
        System.out.println("正在吃东西...");
    }
}
