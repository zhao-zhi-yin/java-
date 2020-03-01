package Java2;

import java.util.Scanner;

public class Exercise2 {
    public static void main (String arg[]) {
      String name1;
      Scanner reader = new Scanner(System.in);
      HandlStu hstu=new HandlStu();
      hstu.input();
      hstu.compare(hstu.stu);
      System.out.println("请输入你要查询的学生姓名：");
      name1=reader.next();
      hstu.search(hstu.stu,name1);
    }
 }

