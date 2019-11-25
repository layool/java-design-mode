package com.company;
import java.awt.AWTException;
import java.awt.Robot;
public class monitorcmdkillpid {
    public static void main(String[] args) throws AWTException {
        shutdownPro("QQ", 5000);//传入两个参数，一个是想要操作的进程的名字，一个是时间间隔
    }
    public static void shutdownPro(String progressName,int time) throws AWTException {
        int isRunning = -1;//定义变量，该变量用来判断某程序是否在运行，初始值为-1
        Robot robot=new Robot();
        while(true) {
            try {
                robot.delay(time);//使用robot的延时功能来完成每隔多少时间运行一次，当然还有其他方法实现该功能

                //下面两句是用Java来调用某个程序的语句，这里定义了一个Windows的命令，然后去执行。该语句的作用是查看当前在运行的程序
                String cmd = " tasklist";
                Process p = Runtime.getRuntime().exec(cmd);

                //上述语句执行完后，可以通过Process对象获得窗口返回的数据，把这个数据拼接成一个字符串
                StringBuffer proList = new StringBuffer();
                byte[] b = new byte[1024];
                for (int n; (n = p.getInputStream().read(b)) != -1;) {
                    proList.append(new String(b, 0, n));
                }


                isRunning = proList.toString().indexOf(progressName+".exe");//调用indexOf方法判断某个进程是否存在于我们得到的结果中

                //如果有，说明在运行
                if (isRunning >= 0) {
                    System.out.println("正在关闭");
                    //同上，执行一条命令，该命令是强制关闭该进程
                    String command = "taskkill /f /im "+progressName+".exe";
                    Runtime.getRuntime().exec(command);
                    System.out.println("已关闭");
                } else {
                    System.out.println("无进程");
                }

            } catch (Exception e1) {
                e1.printStackTrace();

            }
        }
    }
}
