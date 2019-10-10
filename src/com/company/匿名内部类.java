package com.company;

public class 匿名内部类 {
}
interface A{
    public void printInfo() ;    //无参数的方法头
}
class B implements A{    // 实现接口
    public void printInfo(){//无参数的方法体
        System.out.println("Hello World!!!") ;
    }
};
class X {//无 public 访问限制修饰符 为友好类 类不能用private和protected修饰
    //C++中有一个友元机制，可以给予一个类访问另一个类中私有成员的权限
    public void fun1(){
        this.fun2(new B()) ;
    }
    public void fun2(A a){
        a.printInfo() ;
    }
};
class NoInnerClassDemo01{
    public static void main(String args[]){
        new X().fun1() ;        // 实例化X类的对象，并调用fun1()方法
    }
}

/*
    interface A{
        public void printInfo() ;    //
    }
    class X {
        public void fun1(){
            this.fun2(new A(){　　　　//这里所做的改变就是，把原本的B类去掉，然后在括号中的new B()改成new A()（也就是接口类），
                          给出方法的具体实现，定义内部类。相当于把B类的写的操作代码直接写到匿名内部类中。
                          public void printInfo(){
                              System.out.println("Hello World!!!") ;
                          }
                      }
            ) ;//封号注意
        }
        public void fun2(A a){
            a.printInfo() ;
        }
    };
    public class NoInnerClassDemo02{
        public static void main(String args[]){
            new X().fun1() ;        // 实例化X类的对象，并调用fun1()方法
        }
    }*/