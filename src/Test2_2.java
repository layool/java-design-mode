interface Shape{
    double Area();
}
class Circle implements Shape{
    private double r;
    Circle(double r){
        this.r=r;
    }
    @Override
    public double Area() {
        return 3.14*r*r;
    }
}
class Square implements Shape {
    private double a;

    Square(double a) {
        this.a = a;
    }

    @Override
    public double Area() {
        return a * a;
    }
}
class Triangle implements Shape{
    private double a,b;
    Triangle(double a,double b){
        this.a=a;
        this.b=b;
    }

    @Override
    public double Area() {
        return 0;
    }
}
public class Test2_2 {
    public static void main(String[] args) {
        Shape[] data=new Shape[3];
        data[0]=new Circle(2);
        System.out.println(data[0].Area());
        data[1]=new Square(2);
        System.out.println(data[1].Area());
        data[2]=new Triangle(2,3);
        System.out.println(data[2].Area());
    }
}
