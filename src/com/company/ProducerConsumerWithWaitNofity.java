package com.company;
public class ProducerConsumerWithWaitNofity {
    public static void main(String[] args){
        Resource resource = new Resource();
        //生产者线程
        ProducerThread p1 = new ProducerThread(resource);
        //消费者线程
        ConsumerThread c1 = new ConsumerThread(resource);

        p1.start();
        c1.start();
    }
}
/**
 * 公共资源类
 * 定义同步化的消费者的remove和生产者的add方法
*/
class Resource{
    Object h=new Object();
    //当前资源数量
    private int num = 0;
    //资源池中允许存放的资源数目
    private int size = 6;
    private int i=1;
    private int j=1;
    /**
     * 从资源池中取走资源
     */
    public void remove(){
       synchronized (h) {//锁住同一个new出来的resource对象
            //synchronized同步方法与synchronized(this)同步代码块使用的是同一把锁 （对象锁
            if (num > 0) {
                num--;
                System.out.println("消费者" + Thread.currentThread().getName() +
                        "消耗一件资源，" + "当前线程池有" + num + "个"+"    取出"+j);
                j++;
                if(j==size+1){
                    j=1;
                }
                h.notifyAll();//通知生产者生产资源
            } else {
                try {
                    //如果没有资源，则消费者进入等待状态
                    h.wait();
                    System.out.println("消费者" + Thread.currentThread().getName() + "线程进入等待状态");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /**
     * 向资源池中添加资源
     */
    public void add() {
        synchronized (h) {
            if (num < size) {
                num++;
                System.out.println(Thread.currentThread().getName() + "生产一件资源，当前资源池有"
                        + num + "个"+"    添加到"+i);
                i++;
                if(i==size+1){
                    i=1;
                }
                //通知等待的消费者
                h.notifyAll();
            } else {
                //如果当前资源池中有10件资源
                try {
                    h.wait();//生产者进入等待状态，并释放锁
                    System.out.println(Thread.currentThread().getName() + "线程进入等待");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
/**
 * 消费者线程
 */
class ConsumerThread extends Thread{
    private Resource resource;
    public ConsumerThread(Resource resource){
        this.resource = resource;
    }
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            resource.remove();
        }
    }
}
/**
 * 生产者线程
 */
class ProducerThread extends Thread{
    private Resource resource;
    public ProducerThread(Resource resource){
        this.resource = resource;
    }
    @Override
    public void run() {
        //不断地生产资源
        while(true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            resource.add();
        }
    }
}
