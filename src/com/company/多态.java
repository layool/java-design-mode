package com.company;

public class 多态 {
}
class ClassA {
    int count=2;

    public void display(){
        System.out.println(this.count);
    }
}
class ClassB extends ClassA {
    int count=20;
    public void display(){
        System.out.println(this.count);
    }
    public static void main(String[] args){
        ClassA a=new ClassB();
        System.out.println(a.count);//2      成员变量无多态所以调用的是classA的成员变量
        a.display();//20

    }

}