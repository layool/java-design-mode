/*数据类型
　　Java虚拟机中，数据类型可以分为两类：基本类型和引用类型。基本类型的变量保存原始值，即：他代表的
值就是数值本身；而引用类型的变量保存引用值。“引用值”代表了某个对象的引用，而不是对象本身，对象
本身存放在这个引用值所表示的地址的位置。
栈是运行时的单位，而堆是存储的单位。
1.基本类型：Underfined ,Null, Boolean,Number,String
基本类型在内存中分别占有固定大小的空间，他们的值保存在栈空间中，我们通过按值访问
每个栈中的数据(原始类型和对象引用)都是私有的，其他栈不能访问。
每当启动一个新线程的时候，java虚拟机都会为它分配一个java栈。java以栈帧为单位保存线程的运行状态。虚拟机只会对java栈执行两种操作：以栈帧为单位的压栈或者出栈。

(1).基本类型的值是不可变的
(2).基本类型的比较是值的比较
(3).基本类型的变量是存放在栈区的（栈区指内存里的栈内存）

2.引用类型： Object，Array，Date，Function
引用类型：值的大小不固定，栈内存中存放地址指向堆内存中的对象，是按引用访问的。栈内存中存放的只是该对象的访问地址
当查询引用类型的变量时，先从栈中读取内存地址，然后再通过地址找到堆中的值。对于这种，我们把它叫做按引用访问。
jvm只有一个堆区（heap）被所有线程共享，堆区中不存放基本类型和对象引用，只存放对象本身。

基本类型大小固定，引用类型大小不固定，分开存放使得程序运行占有内存最小

当我们看到一个变量类型是已知的，就分配在栈里面，比如INT，Double等，其它未知的类型，比如自定义类型，因为系统不知道需要多大，所以程序自己申请，这样就分配在堆里面。


 方法区 (Method Area)
 在方法区中，存储了每个类的信息（包括类的名称、方法信息、字段信息）、静态变量、常量以及编译器编译后的代码等。

首先了解一个概念：栈内存与堆内存---这是两种不同的内存分配方法

一般代码逻辑，简单变量，结构体都是放在栈中；而对象，以及被装箱的数据放在堆中
栈内存中存放地址指向堆内存中的对象

#####基本类型在当前执行环境结束时销毁，而引用类型不会随执行环境结束而销毁，只有当所有引用它的变量不存在是这个对象才被垃圾回收机制回收。

程序计数器 (Program Counter (PC) Register)
用于保存当前线程执行的内存地址。

由于JVM程序是多线程执行的（线程轮流切换），所以为了保证线程切换回来后，还能恢复到原先状态，就需要一个独立的计数器，记录之前中断的地方，可见程序计数器也是线程私有的。

package com.company;
class A
{
    int waibu=12;
    public void say2()
    {
        System.out.println("这是外部类当中的方法");
    }
    class B//非静态内部类中不能声明任何static成员 ,静态成员包括静态方法和静态成员变量
    {
        int neibu=13;
        public void sayit()
        {
            System.out.println("这是内部类里面的方法");
            System.out.println("使用内部类和外部类当中的数值进行想加的结果是"+(neibu+waibu));
            //之所以内部类可以使用外部类的属性是因为在创建对象的时候，已经给内部类的对象附加了一个外部类的对象，内部类的对象是建立在外部类对象的基础上的。
        }
    }
}
public class 内部类 {
    public static void main(String[] args) {//静态数据成员为类的所有对象共有，占一分内存空间。
        System.out.println("下面是是内部类的程序展示");
        //创建外部类和内部类的方法有点不相同
        A a=new A();
        A.B b=new A().new B();//这里开始创建内部类的对象，这是创建内部类对象的专用格式，相当于在创建了一个外部类对象的基础上再创建一个内部类对象2
        a.say2();
        b.sayit();
    }
}*/
