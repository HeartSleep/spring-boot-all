package com.shuidihuzhu.mybatis.plus;

/**
 * @author gehuadong@shuidihuzhu.com
 * @date 2020-02-14 16:37
 */
public class Test {

    private static final ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();

    static {
        threadLocal.set("set-main-thread");
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + "----->" + threadLocal.get());
        new Thread(() -> System.out.println(Thread.currentThread().getName() + "----->" + threadLocal.get())).start();
    }
}
