package com.fx.responsibility.a_singleresponsibility.negtive;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;

/**
 * 反例：
 * 统计一个文本文件中，有多少字符，所有功能在一个方法里
 */
public class Test {
    public static void main(String[] args) throws Exception {

        Reader in = new FileReader("d:\\a.txt");
        BufferedReader br = new BufferedReader(in);
        String line = null;
        StringBuilder sb = new StringBuilder("");
        while ((line = br.readLine()) != null) {
            sb.append(line)
                    .append("\n");
        }
        br.close();
        in.close();
        String[] words = sb.toString().split("[^a-zA-Z]+");
        System.out.println(words.length);

    }
}
