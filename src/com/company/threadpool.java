package com.company;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
/**
 * @Author:hxs
 * @Description:线程池
 * 一、线程池：提供了一个线程队列，队列中保存着所有等待状态的线程。避免了创建与销毁额外开销，提高了响应的速度。
 * 二、线程池的体系结构：
 *  java.util.concurrent.Executor : 负责线程的使用与调度的根接口
 * 		|--**ExecutorService 子接口: 线程池的主要接口
 * 			|--ThreadPoolExecutor 线程池的实现类
 * 			|--ScheduledExecutorService 子接口：负责线程的调度
 * 				|--ScheduledThreadPoolExecutor ：继承 ThreadPoolExecutor， 实现 ScheduledExecutorService
 * 三、工具类 : Executors
 * ExecutorService newFixedThreadPool() : 创建固定大小的线程池
 * ExecutorService newCachedThreadPool() : 缓存线程池，线程池的数量不固定，可以根据需求自动的更改数量。
 * ExecutorService newSingleThreadExecutor() : 创建单个线程池。线程池中只有一个线程
 * ScheduledExecutorService newScheduledThreadPool() : 创建固定大小的线程，可以延迟或定时的执行任务。
 */
/*线程的创建方式中有两种，一种是实现Runnable接口，另一种是继承Thread，
但是这两种方式都有个缺点，那就是在任务执行完成之后无法获取返回结果，
于是就有了Callable接口
 */
public class threadpool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(10);//创建线程池 创建固定大小的线程池
        //1.Runnable实现多线程
        pool.execute(new Runnable() { // 提交多个线程任务，并执行
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " is running ..");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        //2.Callable实现多线程 实现Callable接口。相较于实现Runnable接口的方式，方法可以有返回值，并且可以抛出异常
        List<Future> futures = new ArrayList<Future>();
        for(int i=0;i<10;i++){
            //提交任务并获取执行结果
            Future<Integer> future = pool.submit(new Callable<Integer>() { //执行Callable方式，需要FutureTask实现类的支持，用于接收运算结果
                @Override
                public Integer call() throws Exception {
                    int sum = 0;
                    for(int j=0;j<5;j++){
                        sum = sum + j;
                    }
                    return sum;
                }
            });
            System.out.println("future address"+future);
            System.out.println("future"+future.get());
            futures.add(future);
        }
        //关闭线程池
        pool.shutdown();
        //循环遍历
        for(Future future:futures){
            System.out.println(future.get());
        }
    }
}
/*1、Runnable是自从java1.1就有了，而Callable是1.5之后才加上去的。
2、Callable规定的方法是call(),Runnable规定的方法是run()。
3、Callable的任务执行后可返回值，而Runnable的任务是不能返回值(是void)。
4、call方法可以抛出异常，run方法不可以。
5、运行Callable任务可以拿到一个Future对象，表示异步计算的结果。
它提供了检查计算是否完成的方法，以等待计算的完成，并检索计算的结果。
通过Future对象可以了解任务执行情况，可取消任务的执行，还可获取执行结果。
6、加入线程池运行，Runnable使用ExecutorService的execute方法，Callable使用submit方法。
*/
