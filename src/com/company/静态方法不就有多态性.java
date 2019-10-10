package com.company;

public class 静态方法不就有多态性 {
}
class SuperClass {
    //父类的一个静态方法
    public static String staticMethod (){
        return "SuperClass's staticMethod()";
    }

    //父类的一个动态方法
    public String dynamicMethod (){
        return "SuperClass's dynamicMethod()";
    }
}


//继承自SuperClass的Subclass
class Subclass extends SuperClass{
    //子类貌似重写父类的静态方法
    public static String  staticMethod(){
        return "derived class's staticMethod()";
    }

    //子类重写父类的动态方法
    public String dynamicMethod(){
        return "derived class's dynamicMethod()";
    }

}
class StaticMethodPolymorphism{
    public static void main(String[] args) {
        SuperClass sup = new Subclass();
        System.out.println("----------------");
        System.out.println("sup.staticMethod()-> "+ sup.staticMethod());//sup.staticMethod()-> SuperClass's staticMethod()
        System.out.println("sup.dynamicMethod()-> "+ sup.dynamicMethod());//sup.dynamicMethod()-> derived class's dynamicMethod()
        System.out.println("----------------");
    }
}
/*
1.static关键字修饰的静态方法表示当前类的唯一实例,也就是说在整个java项目中这个方法是唯一的,既然是唯一的，只要编译成功并加载，就不存在先存储和后存储一说，不同类中的即使两个静态方法完全一样，也是两个方法，这和继承没有关系，当然继承也会继承静态方法(如果方法名不同的)，但调用静态方法和多态没关系。而同类的中两个静态方法完全一样，编译都通不过。
2.调用静态方法是用”类名点”的方式调用，用”对象点”来调用本身就是邪道。虽然能够使用。当然这么说也不够严谨，因为所有的类型类都是Class类的实例。
*/