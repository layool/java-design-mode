package com.company;

public class Demo8 {

    Object object = new Object();

    public void test1() {
        synchronized (Demo8.class) {
            System.out.println("test1方法( 同步 ),线程：" + Thread.currentThread().getName() + " 开始执行, time = " + System.currentTimeMillis());
            try {
                // 休眠5秒
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("test1方法( 同步 ),线程：" + Thread.currentThread().getName() + " 执行结束, time = " + System.currentTimeMillis());
        }
    }

    public void test2() {
        synchronized (Demo8.class) {
            System.out.println("test2方法( 同步 ),线程：" + Thread.currentThread().getName() + " 开始执行, time = " + System.currentTimeMillis());
            try {
                // 休眠5秒
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("test2方法( 同步 ),线程：" + Thread.currentThread().getName() + " 执行结束, time = " + System.currentTimeMillis());
        }
    }

    public void test3() {
        System.out.println("test3方法(非同步),线程：" + Thread.currentThread().getName() + " 开始执行, time = " + System.currentTimeMillis());
        try {
            // 休眠5秒
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test3方法(非同步),线程：" + Thread.currentThread().getName() + " 执行结束, time = " + System.currentTimeMillis());
    }

    public static void main(String[] args) {
        Demo8 demo8 = new Demo8();
        Demo8 demo9 = new Demo8();
        new Thread(demo8::test1, "Thread1").start();

        new Thread(demo8::test1, "Thread2").start();

        new Thread(demo8::test2, "Thread3").start();

        new Thread(demo8::test3, "Thread4").start();
        new Thread(demo9::test1, "Thread1").start();

        new Thread(demo9::test1, "Thread2").start();

        new Thread(demo9::test2, "Thread3").start();

        new Thread(demo9::test3, "Thread4").start();

    }

}