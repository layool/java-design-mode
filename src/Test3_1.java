import java.io.*;
import java.util.Scanner;
/**控制台输入**/
/*public class Test3_1 {
    public static void main(String[] args) {
        while(true) {
            Scanner in = new Scanner(System.in);
            System.out.println(in.nextLine());
        }
    }
}*/
/**字节流输入输出**/
public class Test3_1 {
    public static void main(String[] args) {
        BufferedInputStream in = new BufferedInputStream(System.in);
        try {
            byte[] b = new byte[1024];
            in.read(b);
            System.out.println(new String(b));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //输出
        BufferedOutputStream out = new BufferedOutputStream(System.out);
        try {
            for (int i = 0; i < 5; i++) {
                out.write("hello".getBytes());
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
/**
 * 字符流
 */
/*
public class Test3_1 {
    public static void main(String[] args) {
        //输入
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println(in.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //输出
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            for (int i = 0; i < 5; i++) {
                out.write("hello" + i);
                out.newLine();
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
*/