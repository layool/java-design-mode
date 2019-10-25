package com.company;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.ref.SoftReference;
import java.lang.ref.PhantomReference;
public class java四种引用 {
    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();//强引用
        ReferenceQueue<Object> refQueue = new ReferenceQueue<>();
        //对应的类是SoftReference，它被回收的时机是系统内存不足的时候，如果内存足够，
        // 它不会被回收，内存不足了，可能会发生OOM了，软引用的对象就会被回收。
        // 这样的特性是不是就像缓存？是的，软引用可以用来存放缓存的数据，内存足够的时候一直可以访问，
        SoftReference<Object> softReference = new SoftReference<>(obj,refQueue);
        //只要垃圾收集器扫描到了它，被弱引用关联的对象就会被回收。
        // 被弱引用关联对象的生命周期其实就是从对象创建到下一次垃圾回收。
        // 对应的类是WeakReference。
        WeakReference<Object> weakRef = new WeakReference<>(obj, refQueue);
        //它引用的对象可以在任何时候被回收，而且也无法根据虚引用来取得一个对象的实例。
        // 仅仅当它指向的对象被回收的时候，它会受到一个通知。
        // 对应的类是PhantomReference。
        PhantomReference<Object> abcRef = new PhantomReference<Object>(obj, refQueue);
        // 内存不足的时候，需要重新创建或者访问原对象。
        System.out.println("软引用：" + softReference.get());
        System.out.println("弱引用：" + weakRef.get());
        System.out.println("队列中的东西：" + refQueue.poll());
        // 清除强引用, 触发GC
        obj = null;//obj被赋值为了null，该引用就断了，垃圾收集器会在合适的时候回收改引用的内存。
        System.gc();
        Thread.sleep(200);
        System.out.println("软引用：" + softReference.get());
        System.out.println("弱引用：" + weakRef.get());
        System.out.println("引用加入队列了吗？ " + weakRef.isEnqueued());
        System.out.println("队列中的东西：" + refQueue.poll());
        /**
         * 输出结果
         * 弱引用：java.lang.Object@7bb11784
         * 队列中的东西：null
         * 弱引用：null
         * 引用加入队列了吗？ true
         * 队列中的东西：java.lang.ref.WeakReference@33a10788
         */
    }
}
