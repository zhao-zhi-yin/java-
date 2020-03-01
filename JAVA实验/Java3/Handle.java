package Java3;

import java.util.Scanner;

 class Handle {
    int size=10;
    People[] person=new People[size];
    public void input() {
        int i;
        Scanner reader = new Scanner(System.in);
        System.out.println("输入你想输入的联系人数量：");
        size=reader.nextInt();
        for(i=0;i<size;i++) {
           person[i]=new People();
           System.out.print("输入联系人编号： ");
           person[i].number=reader.next();
           System.out.print("输入联系人姓名： ");
           person[i].name=reader.next();
           System.out.print("输入联系人性别： ");
           person[i].sex=reader.next();
           System.out.print("输入联系人电话： ");
           person[i].phone_num=reader.next();
           System.out.print("输入联系人通信地址： ");
           person[i].ID=reader.next();
        }
    }
 void output(People[] person){
        System.out.println("编号   姓名   性别   电话   通信地址");
        for(int i=0;i<person.length;i++ ) {
            System.out.println(""+person[i].number+"   "+person[i].name+"     "+person[i].sex+"    "+person[i].phone_num+"   "+person[i].ID);
        }
    }

 void serch(People[] person){
        String name1;int temp;
        temp=0;
        Scanner reader = new Scanner(System.in);
        System.out.print("输入你想查询的联系人的姓名： ");
        name1=reader.next();
        for(int i=0;i<person.length;i++ ) {
            boolean n=person[i].name.equals(name1);
           if(n)
           {
               System.out.println(""+person[i].number+"   "+person[i].name+"     "+person[i].sex+"    "+person[i].phone_num+"   "+person[i].ID);
               temp=1;
           }
        }
        if(temp==0)
            System.out.println("查无此人！ ");
    }
  void add(People[] person)//增加
    {
            People personk;
            People persong;
            int k;
            personk=new People();
            persong=new People();
            System.out.println("请输入新增的序号 姓名 性别 电话号码 通讯地址");
            Scanner reader = new Scanner(System.in);
            personk.number=reader.next();
            personk.name=reader.next();
            personk.sex=reader.next();
            personk.phone_num=reader.next();
            personk.ID=reader.next();
            System.out.println("请输入你所想插入的位置");
            k=reader.nextInt();
            for(int i=0;i<person.length;i++ ) {
                if(k==i) {
                    persong = person[i];
                    person[i] = personk;
                    for(int j=person.length;j>i;j-- ) {
                        person[j+1]=person[j];
                    }
                    person[i+1]=persong;
                }
            }
        System.out.println("编号   姓名   性别   电话   通信地址");

    }

   void delete(People[] person)//删除
    {
        String k;
        int temp;
        temp = 0;
        System.out.println("请输入要删除的编号：");
        Scanner input = new Scanner(System.in);
        k = input.next();
        for (int i = 0; i < person.length; i++)
            {
                boolean n = person[i].number.equals(k);
                if (n) {
                    temp = 1;
                    for (int j = i; j < person.length; j++) {
                        person[j] = person[j + 1];
                    }
                }
            }
            if (temp == 0) {
                System.out.println("要删除的编号不存在！");
            }
        System.out.println("编号   姓名   性别   电话   通信地址");

    }
  void modifi(People[] person) //修改
    {
        String k;
        int temp;
        temp = 0;
        System.out.println("请输入要修改的编号：");
        Scanner reader = new Scanner(System.in);
        k = reader.next();
        for (int i = 0; i < person.length; i++)
            {
                boolean n = person[i].number.equals(k);
                if (n) {
                    temp = 1;
                    System.out.println("请输入新的序号 姓名 性别 电话号码 通讯地址");
                    person[i].number=reader.next();
                    person[i].name=reader.next();
                    person[i].sex=reader.next();
                    person[i].phone_num=reader.next();
                    person[i].ID=reader.next();
                    }
            }
            if (temp == 0) {
                System.out.println("要删除的编号不存在！");
            }

    }
}

class People{
    String number;
    String name;
    String sex;
    String phone_num;
    String ID;
}