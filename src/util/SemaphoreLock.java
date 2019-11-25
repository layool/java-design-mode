package util;

import java.util.concurrent.Semaphore;
/**
 * Semaphore用来控制同时访问某个特定资源的操作数量，或者同时执行某个指定操作的数量。
 * 还可以用来实现某种资源池限制，或者对容器施加边界。
 * 1.1   当成锁使用
 * 　　控制同时访问某个特定资源的操作数量，代码如下：**/
public class SemaphoreLock {
    public static void main(String[] args) {
        //1、信号量为1时 相当于普通的锁  信号量大于1时 共享锁
        Output o = new Output();
        for (int i = 0; i < 5; i++) {
            /*Runnable r=new Runnable(){
                @Override
                public void run() {
                    o.output();
                }
            };
            new Thread(r).start();*/

            new Thread(new Runnable(){
                @Override
                public void run() {
                    o.output();
                }
            }).start();
            //Runnable f=()->{o.output();};
            //new Thread(f).start();

            //new Thread(() -> o.output()).start();
        }
    }
}
class Output {
    Semaphore semaphore = new Semaphore(1);

    public void output() {
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + " start at " + System.currentTimeMillis());
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " stop at " + System.currentTimeMillis());
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
    }
}