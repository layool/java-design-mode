package com.company;
/*依赖倒置:
高层模块不应该依赖低层模块，他们应该依赖底层模块的抽象类或者接口。
在软件开发过程中，依赖通常有三种体现形式：
1、将一个类的对象作为另一个类中方法的参数
2、在一个类的方法中将另一个类的对象作为其局部变量
3、在一个类的方法中调用另一个类的静态方法。而这并不绝对，比如实现接口的类也依赖接口，这也算的。
 */
/*依赖注入，也称为 DI，完成控制反转大体可以分为如下两步：
1、创建实例化
2、将实例化注入相应类属性中（把鱼竿注实例并注入人类中的鱼竿引用）
依赖注入指的是第二步的工作。
实现依赖注入大体有下三种方式：
一，通过构造函数注入
二，通过set方法注入
三，通过接口方式进行注入
*/
interface DepedencySetter {//接口注入类
    void set(FishRod fishRod);
}
class People implements DepedencySetter{
    private FishRod fishRod;

    public People(FishRod fishRod) {//3.将实例化赋值给FishRod引用，上转型调用也是实现依赖倒置的原因之一
        this.fishRod = fishRod;//一，通过构造函数注入
    }

    public void setFishRod(FishRod fishRod) {
        this.fishRod = fishRod;//二，通过set方法注入
    }

    @Override
    public void set(FishRod fishRod) {
        this.fishRod = fishRod;//三，通过接口方式进行注入
    }

    public void diaoyuActive() {
        //多态：父类引用指向子类对象
        fishRod = new NormalFishRod();//依赖：程序语言来说，人是类，钓竿是类，钓鱼是钓竿的方法，如果人想完成钓鱼活动，只能将钓竿作为自己的成员然后调用钓竿的钓鱼方法
        fishRod.diaoyu();
    }
}
interface FishRod {
    void diaoyu();
}
class NormalFishRod implements FishRod {
    public void diaoyu() {
        System.out.println("普通竿钓鱼");
    }
}
class GoodFishRod implements FishRod {
    public void diaoyu() {
        System.out.println("好竿钓鱼");
    }

}
public class 依赖注入控制翻转 {
    public static void main(String[] args) {
        FishRod fishRod = new NormalFishRod();//1.此处实例化
        People people = new People(fishRod);//2.实例化作为参数传给People内部(通过一，通过构造函数注入)
        people.diaoyuActive();

    }
}
/*总结控制反转与依赖注入的关系就是。
我是人类，我有个锤子类成员，但我可不想自己生产一个锤子，所以我得靠别人生产锤子，并送到我手上，
我只负责使用就好了，而制造锤子并给我的那个地方很洋气，叫我IOC容器，而IOC容器把锤子交给我的过程，叫做依赖注入，
只有实现了接口的类才能进行注入，那么就可以控制那些类可以注入哪些类不可以注入了。
就像人类有很多子类，有些子类是不能钓鱼的，
比如说小朋友，因为河边危险嘛，我们不应该开放发放钓竿的方法给小朋友，所以小朋友不实现该接口即可。*/

