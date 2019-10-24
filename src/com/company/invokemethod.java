package com.company;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;
abstract class Shape {
    public abstract void calArea();
}
class Triangle extends Shape {

    private float height;
    private float width;

    float rr;
    protected float qq;

    public void setHeight(float height) {
        this.height = height;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    @Override
    public void calArea() {
        float Area;
        Area = 0.88f * width * height;
        System.out.println("Area of the cn.edu.nuc.Triangle is " + Area);

    }
}

public class invokemethod {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        System.out.println("Please input the name of the class");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        while(name != null){
            Class newclass = Class.forName("com.company.Triangle");
            Shape obj = (Shape) newclass.newInstance();
            Field fields[] = newclass.getFields();//得到公有变量
            Field fields1[] = newclass.getDeclaredFields();//得到所有域变量
            Method method[] = newclass.getMethods();//得到public方法
            for (Field fs:fields) {
                System.out.println(fs.toString());
            }
            System.out.println("---------------------------------");
            for (Field fs1:fields1) {
                System.out.println(fs1.toString());
            }
            System.out.println("***************************************");
            for (Method ms:method) {
                System.out.println(ms.toString());
            }
            System.out.println("Please input the height and width of the triangle: ");
            Scanner scanner1 = new Scanner(System.in);
            /*((Triangle)obj).setHeight(scanner1.nextFloat());
            ((Triangle)obj).setWidth(scanner1.nextFloat());
            obj.calArea();*/
            for (int i = 0; i < fields1.length; i++) {
                System.out.println("inout the value of"  + fields1[i].getName());
                float value = scanner.nextFloat();
                fields1[i].setAccessible(true);
                fields1[i].setFloat(obj, value);
            }
            if (scanner.hasNext()){
                name = scanner.next();
            }else{
                name = null;
            }


        }
    }
}

