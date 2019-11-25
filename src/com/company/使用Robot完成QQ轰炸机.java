package com.company;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
public class 使用Robot完成QQ轰炸机 {
    public static void main(String[] args) throws AWTException {

        String sentence = "爱我你怕了吗";//定义要发送的话爱我你怕了吗

        //以下三行为将上述字符串放到剪切板内，相当于做了一次复制操作
        Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable tText = new StringSelection(sentence);
        clip.setContents(tText, null);

        Robot robot = new Robot();//创建Robot对象
        robot.delay(3000);//延迟三秒，主要是为了预留出打开窗口的时间，括号内的单位为毫秒
        for (int i = 1; i <= 10; i++) {//循环十次，当然，如果爱得深，你死循环也没问题

            //以下两行按下了ctrl+v，完成粘贴功能
            robot.keyPress( KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);

            robot.keyRelease(KeyEvent.VK_CONTROL);//释放ctrl按键，像ctrl，退格键，删除键这样的功能性按键，在按下后一定要释放，不然会出问题。crtl如果按住没有释放，在按其他字母按键是，敲出来的回事ctrl的快捷键。
            robot.delay(1000);//延迟一秒再发送，不然会一次性全发布出去，因为电脑的处理速度很快，每次粘贴发送的速度几乎是一瞬间，所以给人的感觉就是一次性发送了全部。这个时间可以自己改，想几秒发送一条都可以
            robot.keyPress( KeyEvent.VK_ENTER);//回车
        }
    }
}
