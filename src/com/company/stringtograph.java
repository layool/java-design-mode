package com.company;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
/*整体思路为导入想好处理的图片，遍历，得到每个像素点的颜色，然后将其转换成灰度值（也就是把彩色转换成黑白），根据得到的灰度值计算字符串索引，达到效果就是不同颜色可以对应不同的下标，以此来匹配字符串中的字符，最后按照原有的坐标点把这些字符打印出来即可
1定义好想要填充的字符串
2导入想要处理的图片，需要用到BufferedImage（图片缓冲区）这个对象
3遍历整张图片，这里需要注意，外层循环遍历y轴，内层遍历x轴，因为打印的时候需要一行一行打印，打完一行要换行
4根据getRGB(x,y)方法，传入当前的坐标点，得到当前点的颜色
5从得到的颜色中单独拆分出r,g,b的值
6根据得到的rgb计算对应的灰度值
7根据灰度值计算索引
8打印*/
public class stringtograph {
    public static void main(String[] args) throws IOException {
        String path = "src/com/timg.jpg";//导入的图片
        String base = "love";//将会用这个字符串里的字符填充图片
        BufferedImage image = ImageIO.read(new File(path));//读入图片，并用图片缓冲区对象来接收

        //双层for循环，遍历图片
        for (int y = 0; y < image.getHeight(); y++) {//先竖向遍历，再横向遍历，即一行一行的找，后面也会一行一行的打印
            for (int x = 0; x < image.getWidth(); x++) {
                int color = image.getRGB(x, y);//图片缓冲区自带的方法，可以得到当前点的颜色值，返回值是int类型
                int r=(color>>16)&0xff;//0xff 拓展ascii码为255
                int g=(color>>8)&0xff;//&操作符其实是在取交集
                int b=color&0xff;
                float gray = 0.299f * r + 0.578f * g + 0.114f * b;//灰度值计算公式，固定比例，无需理解
                int index = Math.round(gray * (base.length()) / 255);
                if(index>=base.length()) {
                    System.out.print(" ");//白色的地方打空格，相当于白色背景，这样图片轮廓比较明显
                }else {
                    System.out.print(base.charAt(index));//有颜色的地方打字符
                }
            }
            System.out.println();//一行打完，换行
        }
    }
}
