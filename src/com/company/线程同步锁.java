package com.company;
class Student1 extends Thread{
    private String name;
    public final synchronized String getName1() {//final方法不被重写，synchronized方法实现同步
        return name;
    }
    public final void setName1(String name) {
        this.name = name;
    }
    @Override
    public void run() {
        try {
            System.out.println(this.getName1() + "正在睡觉，不听课");
            Thread.sleep(1000*60*60*24);
        } catch (InterruptedException e) {
            System.out.println(this.getName1() + "被老师叫醒了");
        }
        finally {
            System.out.println(this.getName1() + "正在听课");
        }
    }
}
class Teacher extends Thread {
    private boolean isFinal = false;//结束时判断结束
    private String name;
    private Thread student;
    private boolean noneStudent = false;
    private Object obj = new Object();//实例化一个共有的Object类用来做成用一个锁
    public final  synchronized String getName1() {
        return name;
    }
    public final  void setName1(String name) {
        this.name = name;
    }

    public void setData(Thread student,boolean noneStudent){
        synchronized (obj){
            this.student = student;
            this.noneStudent = noneStudent;
        }
    }
    public void setfianl(boolean isFinal){
        this.isFinal=isFinal;
    }
    @Override
    public void run() {
        while (true){
            if(isFinal==false) {
                synchronized (obj) {
                    if (noneStudent != false) {
                        for (int i = 0; i < 3; i++) {
                            try {
                                Thread.sleep(100);
                                System.out.println("上课");
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println(this.getName1() + "非常生气！");
                        student.interrupt();//取消student的sleep状态
                        noneStudent = false;
                    }
                }
            }
            else{
                break;
            }
        }
    }
}
public class 线程同步锁 {
    public static void main(String[] args) {
        Student1 student;
        Teacher teacher = new Teacher();
        teacher.setName1("老师");//调用自己实现的set方法
        teacher.start();//start 重写的run方法
        for(int i = 0;i < 10;i ++){
            student = new Student1();
            student.setName1("学生" + i);
            student.start();
            teacher.setData(student,true);
            try {
                Thread.sleep(1000 * 1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        teacher.setfianl(true);
    }
}