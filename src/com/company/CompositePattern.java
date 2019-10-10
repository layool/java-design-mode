
import java.util.ArrayList;
public class CompositePattern//组合模式
{
    public static void main(String[] args)
    {
        Component c0=new Composite();
        Component c1=new Composite();
        Component leaf1=new Leaf("1");
        Component leaf2=new Leaf("2");
        Component leaf3=new Leaf("3");
        c0.add(leaf1);
        c0.add(leaf1);
        c0.add(leaf1);
        c0.add(c1);
        c1.add(leaf2);
        c1.add(leaf3);
        c0.operation();
    }
}
//抽象构件
interface Component//抽象类和接口都无法被实例化
{
    public void add(Component c);//①static修饰的方法不可以被重写②非static修饰的方法才可以被重写
    //public void remove(Component c);
    //public Component getChild(int i);
    public void operation();//重写 四要素 1.参数列表(参数)不变 2.返回值不变 3.修饰符不能缩小 4.方法名相同 5.重写方法若要抛出异常不大于父类
}
//树叶构件
class Leaf implements Component
{
    private String name;
    public Leaf(String name)
    {
        this.name=name;
    }
    public void add(Component c){ }
    //public void remove(Component c){ }
    /*public Component getChild(int i)
    {
        return null;
    }*/
    public void operation()
    {
        System.out.println("树叶"+name+"：被访问！");
    }
}
//树枝构件
class Composite implements Component
{
    private ArrayList<Component> children=new ArrayList<Component>();//children数组里存储了leaf或composite对象
    public void add(Component c)
    {
        children.add(c);
    }
    /*public void remove(Component c)
    {
        children.remove(c);
    }*/
    /*public Component getChild(int i)
    {
        return children.get(i);
    }*/
    public void operation()
    {
        for(Object obj:children)
        {
            ((Component)obj).operation();//多态调用参数  调用树叶的operation方法
        }
    }
}