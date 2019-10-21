package com.company;
//静态内部类单例模式
/*这种方式同样利用了 classloader 机制来保证初始化 instance 时只有一个线程，
它跟饿汉不同的是：饿汉只要 Singleton 类被装载了，那么 instance 就会被实例化（没有达到 lazy loading 效果），
而这种方式是 Singleton 类被装载了，instance 不一定被初始化。因为 SingletonHolder 类没有被主动使用，
只有通过显式调用 getInstance 方法时，才会显式装载 SingletonHolder 类，从而实例化 instance。
想象一下，如果实例化 instance 很消耗资源，所以想让它延迟加载，另外一方面，又不希望在 Singleton 类加载时就实例化，
因为不能确保 Singleton 类还可能在其他的地方被主动使用从而被加载，那么这个时候实例化 instance 显然是不合适的。
 */
class SingleObject1 {
    private static class SingletonHolder {//创建一个私有静态类

        private static final SingleObject1 instance = new SingleObject1();//static保证只初始化一次 final防止重复赋值
    }

    //私有化构造函数
    private SingleObject1(){}

    //静态final公有化get方法：获得唯一可用的instance对象
    public static final  SingleObject1 getInstance(){
        return SingletonHolder.instance;
    }

    public void showMessage(){
        System.out.println("hello world");
    }

}
public class 静态内部类单例模式 {
    public static void main(String[] args) {

        //不合法的构造函数
        //编译时错误：构造函数 SingleObject() 是不可见的
        //SingleObject object = new SingleObject();

        //获取唯一可用的对象
        SingleObject1 object = SingleObject1.getInstance();
        System.out.println(object);
        SingleObject1 object1 = SingleObject1.getInstance();
        System.out.println(object1);
        //显示消息
        object.showMessage();
    }

}

