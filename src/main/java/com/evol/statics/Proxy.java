package com.evol.statics;

/**
 * 代理类，实现与目标对象共同的方法，通过调用代理对象的方法达到调用目标方法的实现
 */
public class Proxy implements Person{
    //代理类中要持有被代理对象（目标对象）引用
    private Person target;
    @Override
    public void eat() {
        //实现代理的方法。可不修改原方法的前提扩展其他业务处理
        System.out.println("吃饭前洗手...");
        target.eat();
        System.out.println("吃饭后收拾...");
    }

    public Proxy(Person target) {
        this.target = target;
    }
}
