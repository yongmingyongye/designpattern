package com.fx.responsibility.k_prototype.a;

import java.io.*;
import java.util.Date;

/**
 * 使用原型模式：
 * 1、必须让目标类实现Cloneable接口，改接口没有任何抽象方法，仅仅是一个标记接口。表示实现该接口的类可以被克隆
 * 2、必须重写java.long.Object类的clone方法，将返回权限改为public
 */
class WeekReport implements Cloneable, Serializable {
    private int id;
    private String emp;
    private String summary;
    private String plain;
    private String suggestion;
    private Date time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmp() {
        return emp;
    }

    public void setEmp(String emp) {
        this.emp = emp;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPlain() {
        return plain;
    }

    public void setPlain(String plain) {
        this.plain = plain;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "WeekReport{" +
                "id=" + id +
                ", emp='" + emp + '\'' +
                ", summary='" + summary + '\'' +
                ", plain='" + plain + '\'' +
                ", suggestion='" + suggestion + '\'' +
                ", time=" + time +
                '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(out);
            oos.writeObject(this);
            oos.close();
            // 从内存中读取数据
            byte[] bytes = out.toByteArray();
            InputStream in = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(in);
            Object clone = ois.readObject();
            ois.close();
            return clone;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
public class Test {
    public static void main(String[] args) throws Exception {
        WeekReport wr = new WeekReport();
        wr.setEmp("张三");
        wr.setSummary("完成4篇推文");
        wr.setPlain("推送一篇原创文章");
        wr.setSuggestion("无");
        wr.setTime(new Date());
        // 入库，用输出测试


        WeekReport wr2 = (WeekReport) wr.clone();
        wr2.setSummary("完成一篇原创文章");
        wr2.setSummary("3篇推文");
        wr2.getTime().setTime(0);
        System.out.println(wr);
        System.out.println(wr2);
    }
}
