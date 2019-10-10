package com.company;
class A
{
    int waibu=12;
    public void say2()
    {
        System.out.println("这是外部类当中的方法");
    }
    class B
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
    public static void main(String[] args) {
        System.out.println("下面是是内部类的程序展示");
        //创建外部类和内部类的方法有点不相同
        A a=new A();
        A.B b=new A().new B();//这里开始创建内部类的对象，这是创建内部类对象的专用格式，相当于在创建了一个外部类对象的基础上再创建一个内部类对象2
        a.say2();
        b.sayit();
    }
}
