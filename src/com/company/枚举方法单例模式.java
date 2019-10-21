package com.company;
//通过枚举的方法单例模式
//此方法可以防止反序列化也就是反invoke（反射）
class SingleObject2 {
    //私有化构造函数
    private SingleObject2(){ }
    //定义一个静态枚举类
    static enum SingletonEnum{
        //创建一个枚举对象，该对象天生为单例
        INSTANCE;
        private  SingleObject2 user;
        //私有化枚举的构造函数
        private SingletonEnum(){
            user=new SingleObject2();
        }
        public  SingleObject2 getInstnce(){
            return user;
        }
    }


    public void showMessage(){
        System.out.println("hello world");
    }
    //对外暴露一个获取User对象的静态方法
    public static SingleObject2 getInstance(){
        return SingletonEnum.INSTANCE.getInstnce();
    }
}

public class 枚举方法单例模式 {
    public static void main(String [] args){
        System.out.println(SingleObject2.getInstance());
        System.out.println(SingleObject2.getInstance());
        System.out.println(SingleObject2.getInstance()==SingleObject2.getInstance());
        SingleObject2.getInstance().showMessage();
    }
}
