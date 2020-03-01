package Java2;

import java.util.Scanner;

public class HandlStu {
    Student[] stu=new Student[10];
    public void input() {
        int i;
        Scanner reader = new Scanner(System.in);
        System.out.println("输入学生姓名和Java课分数：");
        for(i=0;i<10;i++) {
                stu[i]=new Student();
                stu[i].name = reader.next();
                stu[i].score = reader.nextInt();
            }
    }
    public void compare(Student[] stu){
        int i,q,p;
        q=0;p=0;
        for(i=0;i<10;i++) {
            if (stu[q].score < stu[i].score)
                q = i;
            if (stu[p].score > stu[i].score)
                p = i;
        }
        System.out.println("最高分："+stu[q].score+"姓名："+stu[q].name);
        System.out.println("最低分："+stu[p].score+"姓名："+stu[p].name);
    }
    public void search(Student[] stu,String name){
        int i;
        for(i=0;i<10;i++) {
            boolean n=stu[i].name.equals(name);
            if(n){
                System.out.print("该学生成绩："+stu[i].score);
                break;
            }else if(i==9&&n==false) System.out.print("不存在该学生！");
        }
    }
}

class Student{
    String name;
    int score;
}