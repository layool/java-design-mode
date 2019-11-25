package com.company;

import java.util.Scanner;
/**
 * 队列节点
 * @author wsz
 * @date 2018年1月18日
 */
class Data{
    String name;
    int age;
}

class CycleQueue{
    //实际队列可填充数据为3
    static int SIZE = 4;
    //模拟队列结构
    Data[] data = new Data[SIZE];

    int head,tail;

    /**
     * 初始化：头尾均为0
     * @return
     */
    CycleQueue init() {
        CycleQueue cq = new CycleQueue();
        cq.head = 0;
        cq.tail = 0;
        return cq;
    }

    /**
     * 当头尾相等时为空
     * @param cq
     * @return
     */
    boolean isEmpty(CycleQueue cq) {//相等为空
        if(cq.tail == cq.head)
            return true;
        return false;
    }

    /**
     * 判断是否填充满(SIZE-1)
     * @param cq
     * @return
     */
    boolean isFull(CycleQueue cq) {
        if((cq.tail+1) % SIZE == cq.head)
            return true;
        return false;
    }

    /**
     * 插入数据:(tail+1)%SIZE 即实际的存储位置
     * @param cq
     * @param data
     * @return
     */
    int insertCycleQueue(CycleQueue cq,Data data) {
        if(isFull(cq)) {
            System.out.println("队列满");
            return -1;
        }else {
            cq.data[ (cq.tail++) % SIZE] = data;
            System.out.println("队长度:"+cq.lenCycleQueue(cq));
            return cq.tail;
        }
    }
    /**
     * 出队列
     * @param cq
     * @return
     */
    Data outCycleQueue(CycleQueue cq) {
        if(isEmpty(cq)) {
            System.out.println("队空");
            return null;
        }else {
            Data d = cq.data[ (cq.head) % SIZE];
            cq.data[ (cq.head) % SIZE] = null; //出队列该位置要置空
            cq.head++;	//后移一位
            return d;
        }
    }

    /**
     * 队列长度
     * @param cq
     * @return
     */
    int lenCycleQueue(CycleQueue cq) {
        return (cq.tail-cq.head +SIZE) % SIZE;
    }

    /**
     * 展示全部队列数据
     * @param cq
     */
    void showCycleQueue(CycleQueue cq){
        if(isEmpty(cq)) {
            System.out.println("队空");
        }else {
            Data[] d = cq.data;
            for(int i =0; i<d.length;i++) {
                if(d[i] != null)
                    System.out.print(" "+i+":"+d[i].age+"_"+d[i].name);
            }
            System.out.println("");
        }
    }

}
public class CycleQueueDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        CycleQueue cq = new CycleQueue();
        CycleQueue queue = cq.init();

        Scanner input = new Scanner(System.in);
        do {
            System.out.println("1插入队列 2数据出队 3展示队列 0退出");
            int select = input.nextInt();
            if(select == 1) {
                insert(cq,queue,input);
            }else if(select == 2) {
                out(cq,queue,input);
            }else if(select == 3){
                show(cq,queue);
            }else {
                break;
            }
        }while(true);
        input.close();
    }

    static void show(CycleQueue cq, CycleQueue queue) {
        cq.showCycleQueue(queue);
    }

    static void insert(CycleQueue cq, CycleQueue queue, Scanner input) {
        System.out.println("入队");
        Data data = new Data();
        data.name = input.next();
        data.age  = input.nextInt();
        cq.insertCycleQueue(queue, data);
    }

    static void out(CycleQueue cq, CycleQueue queue, Scanner input) {
        System.out.println("即将出队");
        Data out = cq.outCycleQueue(queue);
        if(out != null)
            System.out.println(out.age+"_"+out.name+"---剩余长度:"+cq.lenCycleQueue(queue));
    }
}