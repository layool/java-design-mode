package com.company;
//双检锁（dcl）的懒汉单例模式
class Singleton {
    //创建一个私有静态对象
    private volatile static Singleton instance;//静态为了在刚调用jvm的时候就进行声明
    // volatile关键字修饰的变量看到的随时是自己的最新值。线程1中对变量v的最新修改，对线程2是可见的。volatile防止指令重排
    //私有化构造函数
    private Singleton() {
    }

    //静态公有化get方法：
    public static  Singleton getInstance() {
      if(instance==null) {//此判断为加快时间，因为每次都用同步代码块很耗时间
          synchronized (Singleton.class){////synchronized代码块保证线程安全
              if (instance == null) {
                  instance = new Singleton();//静态为了在刚调用jvm的时候就进行初始化操作
              }
          }
      }
        return instance;
    }

    public void showMessage() {
        System.out.println("hello world");
    }
}
public class 懒汉单例模式 {
    public static void main(String[] args) {
        //不合法的构造函数
        //编译时错误：构造函数 SingleObject() 是不可见的
        //SingleObject object = new SingleObject();

        //获取唯一可用的对象
        Singleton object = Singleton.getInstance();
        System.out.println(object);
        Singleton object1 = Singleton.getInstance();
        System.out.println(object1);
        //显示消息
        object.showMessage();
    }
}
