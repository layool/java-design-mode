package com.company;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class 字节流 {
    public static void main(String[] args) throws IOException {
        FileReader in=new FileReader("src/com/input.txt");
        FileWriter out=new FileWriter("src/com/ouput.txt");
        int c;
        while((c=in.read())!=-1) {
            out.write(c);
        }
        out.close();
        in.close();
    }
}
