package com.company;
//mvc设计模式
class Student {//创建模型（model）
    private String rollNo;
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getRollNo() {
        return rollNo;
    }
    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }
}

class StudentView {//创建视图（view）
    public void printStudentDetails(String studentName, String studentRollNo){
        System.out.println("Student: ");
        System.out.println("Name: " + studentName);
        System.out.println("Roll No: " + studentRollNo);
    }
}

class StudentController {//创建控制器
    private Student model;//view层
    private StudentView view;//model层

    public StudentController(Student model, StudentView view){
        this.model = model;
        this.view = view;
    }

    public void setStudentName(String name){
        model.setName(name);
    }

    public String getStudentName(){
        return model.getName();
    }

    public void setStudentRollNo(String rollNo){
        model.setRollNo(rollNo);
    }

    public String getStudentRollNo(){
        return model.getRollNo();
    }

    public void updateView(){
        view.printStudentDetails(model.getName(), model.getRollNo());//此方法将model层的参数传输到view层
    }
}


public class MVCPatternDemo {
    public static void main(String[] args) {
        //从数据库获取学生记录
        Student model  = retrieveStudentFromDatabase();//model层

        //创建一个视图：把学生详细信息输出到控制台
        StudentView view = new StudentView();//view层
        StudentController controller = new StudentController(model, view);//control层
        controller.updateView();//通过control的updateview方法显示

        //通过control层更新模型数据-》model层
        controller.setStudentName("John");//control层
        controller.updateView();//通过control的updateview方法显示
    }

    private static Student retrieveStudentFromDatabase(){//model层
        Student student = new Student();
        student.setName("Robert");
        student.setRollNo("10");
        return student;
    }
}
