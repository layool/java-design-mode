package util;

import java.util.concurrent.Semaphore;
public class ProducerCustomer {
    public int size;
    public int life; //控制输出次数
    int[] currentsize;
    public Semaphore mutex;// 互斥访问信号量
    public Semaphore empty;//是否为空 ，空则消费者等待
    public Semaphore full; //是否满，满则生产者等待

    public ProducerCustomer(int size) {
        this.size = size;
        life = 0;
        currentsize = new int[size + 1]; //0位表示数目
        for (int i = 0; i < size + 1; i++) {
            currentsize[i] = 0;
        }
        mutex = new Semaphore(1);
        empty = new Semaphore(size); //空闲区初始化为size
        full = new Semaphore(0);//满区初始化为0；
    }

    public static void main(String[] args) {
        ProducerCustomer pc = new ProducerCustomer(6);//缓冲区大小为6
        Producer producer = pc.new Producer();
        Custumer custumer = pc.new Custumer();
        producer.start();
        custumer.start();
    }

    public int produce(){
        currentsize[0]++;
        for (int i = 1; i <= size; i++) {
            if (currentsize[i] == 0) {
                currentsize[i] = 1; //生产一个
                return i;
            }
        }
        return 0;  //返回位置
    }
    public int  custom(){
        currentsize[0]--;
        for (int i = 1; i <= size; i++) {
            if(currentsize[i] == 1){
                currentsize[i] = 0; //消费一个
                return i;
            }
        }
        return 0;
    }
    public void show(){
        System.out.print(" " + "当前位置情况为 ");
        for (int i = 1; i <= size; i++) {
            System.out.print(currentsize[i] + " ");
        }
    }

    class Producer extends Thread{
        int i;
        @Override
        public void run() {
            while(true){
                try {
                    empty.acquire();    // 消耗一个空
                    mutex.acquire();
                    i = produce();
                    System.out.print("在位置" + i + "生产了一个产品， 当前产品数为" + currentsize[0]);
                    show();
                    System.out.println();
                    if(currentsize[0] == size){
                        System.out.println("缓冲区已满");
                    }
                    life++;
                    if(life > 100){
                        System.out.println("生命周期已到");
                        break;
                    }
                    mutex.release();
                    full.release();     // 增加一个产品
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }

        }
    }
    class Custumer extends Thread{
        int i;
        @Override
        public void run() {
            while(true){
                try {
                    full.acquire();     // 消耗一个产品
                    mutex.acquire();
                    i = custom();
                    System.out.print("在位置" + i + "消费了一个产品， 当前产品数为" + currentsize[0]);
                    show();
                    System.out.println();
                    if(currentsize[0] == 0){
                        System.out.println("缓冲区为空");
                    }
                    life++;
                    if(life > 100){
                        System.out.println("生命周期已到");
                        break;
                    }
                    mutex.release();
                    empty.release();    // 增加一个空

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
