import java.util.Scanner;
public class test2 {
    public static void main(String[] args) {
        int a;
        System.out.println("请输入任意字符：");
        Scanner scan = new Scanner(System.in);
        try
        {
            a=scan.nextInt();
            switch (a){
                case 1:
                    System.out.println("奖品1");break;
                case 2:
                    System.out.println("奖品2");break;
                case 3:
                    System.out.println("奖品3");break;
                default:
                    System.out.println("没有奖品！");}
        }
        catch(Exception e){
            System.out.println("没有奖品");
        }
        scan.close();
    }
}
