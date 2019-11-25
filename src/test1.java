import java.util.Scanner;
public class test1{
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.print("Plese input the year:");
        int year=scan.nextInt();
        if(year%4==0 && year%100!=0){
            System.out.print("闰年");
        }
        else if(year%400==0){
            System.out.print("闰年");
        }
        else{
            System.out.print("平年");
        }
        scan.close();
    }
}
