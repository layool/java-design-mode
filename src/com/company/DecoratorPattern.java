package com.company;
public class DecoratorPattern//装饰者模式   通常情况下，扩展一个类的功能会使用继承方式来实现。但继承具有静态特征，耦合度高，并且随着扩展功能的增多，子类会很膨胀。如果使用组合关系来创建一个包装对象（即装饰对象）来包裹真实对象，并在保持真实对象的类结构不变的前提下，为其提供额外的功能，这就是装饰模式的目标。下面来分析其基本结构和实现方法。
{
    public static void main(String[] args)
    {
        Component p=new ConcreteComponent();
        p.operation();
        Component p6=new ConcreteComponent1();
        p6.operation();
        Component p1=new ConcreteComponent();
        p1.operation();
        System.out.println("---------------------------------");
        Component d=new ConcreteDecorator(p,p6);
        d.operation();
        System.out.println("---------------------------------");
        Component d1=new ConcreteDecorator(d,d);
        d1.operation();
    }
}
//抽象构建角色
interface  Component
{
    public void operation();
}
//具体构建角色
class ConcreteComponent implements Component
{
    public ConcreteComponent()
    {
        System.out.println("创建具体构件角色");
    }
    public void operation()
    {
        System.out.println("调用具体构件角色的方法operation()");
    }
}
//具体构建角色
class ConcreteComponent1 implements Component
{
    public ConcreteComponent1()
    {
        System.out.println("创建具体构件角色");
    }
    public void operation()
    {
        System.out.println("调用具体构件角色的方法operation()111111111111111111111");
    }
}
//抽象装饰角色
class Decorator implements Component
{
    private Component component,component1;
    public Decorator(Component component,Component component1)//多态实现调用参数
    {
        this.component=component;
        this.component1=component1;
    }
    public void operation()
    {
        component.operation();
        component1.operation();
    }
}
//具体装饰角色
class ConcreteDecorator extends Decorator
{
    public ConcreteDecorator(Component component,Component component1)
    {
        super(component,component1);//调用父类构造方法
    }
    public void operation()
    {
        super.operation();
        addedFunction();
        System.out.println("---------------------------------");
        //component.operation();
    }
    public void addedFunction()
    {
        System.out.println("为具体构件角色增加额外的功能addedFunction()");
    }
}