import java.util.*;
import java.text.*;
public class 时钟 {
    public static void main(String args[]) throws InterruptedException {
        while(true) {
            Date dNow = new Date();
            SimpleDateFormat ft = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
            System.out.println("Current Date: " + ft.format(dNow));
            Thread.sleep(1000);
            Clear.clsCmd();
        }
    }
}
