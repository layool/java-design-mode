public class test4 {
    public static void main(String[] args){
        //创建一个二维数组
        int arr[][] = new int[4][5];
        //初始化二维数组
        arr[3][4] = 1;
        arr[2][1] = 2;
        arr[0][0] = 3;
        //输出二维数组
        for(int i=0; i<4; i++){
            for(int j=0; j<5; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
