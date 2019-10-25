package com.company;
/*成员变量和局部变量的区别
    (1)在类中的位置不同
        成员变量：类中方法外
        局部变量：方法定义中或者方法声明上
    (2)在内存中的位置不同
        成员变量：在堆中
        局部变量：在栈中
    (3)生命周期不同
        成员变量：随着对象的创建而存在，随着对象的消失而消失
        局部变量：随着方法的调用而存在，随着方法的调用完毕而消失
    (4)初始化值不同
        成员变量：有默认值
        局部变量：没有默认值，必须定义，赋值，然后才能使用
成员变量和静态变量的区别
1，两个变量的生命周期不同。
     成员变量随着对象的创建而存在，随着对象的回收而释放
     静态变量随着类的加载而存在，随着类的消失而消失（类不消失一直存在（不考虑回收机制），生命周期长）
2，调用方式不同。
     成员变量只能被对象调用
     静态变量可以被对象调用，还可以被类名调用（建议使用类名调用，便于区分）
3，别名不同。
     成员变量也称为实例变量
     静态变量也称为类变量
4，数据存储位置不同。
     成员变量数据存储在堆内存的对象中，所以也叫对象的特有数据。
     静态变量数据存储在方法区（共享数据区）的静态区，所以也叫对象的共享数据
*/
public class 静态方法不就有多态性 {
}
/*
很多人认为局部变量在使用到时才会在内存中分配储存单元，而静态变量在程序的一开始便存在于内存中，
所以使用静态变量的效率应该比局部变量高，其实这是一个误区，使用局部变量的效率比使用静态变量要高。
这是因为局部变量是存在于堆栈中的,而静态变量存放于方法区
对其空间的分配仅仅是修改一次esp寄存器的内容即可（即使定义一组局部变量也是修改一次）。
而局部变量存在于堆栈中最大的好处是，函数能重复使用内存，当一个函数调用完毕时，退出程序堆栈，内存空间被回收，
当新的函数被调用时，局部变量又可以重新使用相同的地址。当一块数据被反复读写，
其数据会留在CPU的一级缓存（Cache）中，访问速度非常快。而静态变量却不存在于堆栈中。

可以说静态变量是低效的。
*/
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
        SuperClass sup = new Subclass();//Class对象是存放在堆区的，不是方法区
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