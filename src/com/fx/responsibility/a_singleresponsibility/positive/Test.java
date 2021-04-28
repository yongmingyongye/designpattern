package com.fx.responsibility.a_singleresponsibility.positive;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;

/**
 * 正例：
 * 统计一个文本文件中，有多少字符，每个方法只有一个职责
 */
public class Test {

    // 读取txt文件
    private static String str(String path) throws Exception {
        Reader in = new FileReader(path);
        BufferedReader br = new BufferedReader(in);
        String line = null;
        StringBuilder sb = new StringBuilder("");
        while ((line = br.readLine()) != null) {
            sb.append(line)
                    .append("\n");
        }
        br.close();
        in.close();
        return sb.toString();
    }
    // 按特殊字符分割单词
    private static String[] getWords(String s) {
        String[] words = s.toString().split("[^a-zA-Z]+");
        return words;
    }
    public static void main(String[] args) throws Exception {
        String sb = str("d:\\a.txt");
        String[] words = getWords(sb);
        System.out.println(words.length);
    }
}
