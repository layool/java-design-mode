package com.company;
//饿汉单例模式
class SingleObject {
    //创建一个私有静态对象
    private static  SingleObject instance=new SingleObject();//静态为了在刚调用jvm的时候就进行初始化操作

    //私有化构造函数
    private SingleObject(){}

    //静态公有化get方法：获得唯一可用的instance对象
    public static  SingleObject getInstance(){
        return instance;
    }

    public void showMessage(){
        System.out.println("hello world");
    }
}

public class 饿汉单例模式 {
    public static void main(String[] args) {

        //不合法的构造函数
        //编译时错误：构造函数 SingleObject() 是不可见的
        //SingleObject object = new SingleObject();

        //获取唯一可用的对象
        SingleObject object = SingleObject.getInstance();
        System.out.println(object);
        SingleObject object1 = SingleObject.getInstance();
        System.out.println(object1);
        //显示消息
        object.showMessage();
    }

}
