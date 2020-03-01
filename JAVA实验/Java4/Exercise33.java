package Java4;
import java.util.Scanner;
public class Exercise33 {
    public static void main(String[] args) {
        address_list address_list1=new address_list();
        int userChoice;
        Scanner userInput=new Scanner(System.in);
        do {
            System.out.println("请选择：\n1.新增\n2.删除\n3.修改\n4.查询\n5.退出");
            userChoice=userInput.nextInt();
            switch(userChoice) {
                case 1:
                    address_list1.add();
                    address_list1.print();
                    break;
                case 2:
                    address_list1.delete();
                    address_list1.print();
                    break;
                case 3:
                    address_list1.modification();
                    address_list1.print();
                    break;
                case 4:
                    address_list1.find();
                    address_list1.print();
                    break;
                default:
                    break;
            }
        }while(userChoice!=5);
    }
}

class address_list
{
    int count=0;
    int[] number=new int[50];
    String[] name=new String[50];
    String[] sex=new String[50];
    long[] telephone_number=new long[50];
    String[] address=new String[50];

    void print()//打印
    {
        int j;
        j=1;
        System.out.println("编号 姓名 性别   电话    通信地址");
        for(int i=0;i<count;i++)
        {
            number[i]=j;
            System.out.println(number[i]+"  "+name[i]+"   "+
                    sex[i]+"   "+telephone_number[i]+"   "+address[i]);
            j++;
        }
    }

    void find()//查询
    {
        int i;
        Scanner input=new Scanner(System.in);
        System.out.println("请输入要查询的编号");
        i=input.nextInt();
        if((i>0)&&(i<=count))
        {
            System.out.println("编号  姓名  性别  电话  通信地址");
            System.out.println(number[i-1]+"  "+name[i-1]+"   "+
                    sex[i-1]+"   "+telephone_number[i-1]+"   "+address[i-1]);
        }else
        {
            System.out.println("输入 有误！");
        }
    }

    void add()//增加
    {
        if(count<50)
        {
            System.out.println("请输入新增的姓名 性别 电话号码 通讯地址");
            Scanner input=new Scanner(System.in);
            name[count]=input.next();
            sex[count]=input.next();
            telephone_number[count]=input.nextLong();
            address[count]=input.next();
            count++;
            number[count+1]=count;
        }else
        {
            System.out.println("通讯录已满！");
        }
    }

    void delete()//删除
    {
        int j;
        print();
        System.out.println("请输入要删除的编号：");
        Scanner input=new Scanner(System.in);
        j=input.nextInt();
        if((j>0)&&(j<=count))
        {
            if(j!=100)
            {
                for(int i=j-1;i<count;i++)
                {
                    name[i]=name[i+1];
                    sex[i]=sex[i+1];
                    telephone_number[i]=telephone_number[i+1];
                    address[i]=address[i+1];
                    count--;
                }
            }else
            {
                count--;
            }
        }else
        {
            System.out.println("要删除的编号不存在！");
        }
    }
    void modification()//修改
    {
        int i;
        System.out.println("请输入要修改的人员的编号：");
        Scanner input=new Scanner(System.in);
        i=input.nextInt();
        if((i>0)&&(i<=count))
        {
            System.out.println("请输入要修改的姓名 性别 电话号码 通讯地址");
            name[i-1]=input.next();
            sex[i-1]=input.next();
            telephone_number[i-1]=input.nextLong();
            address[i-1]=input.next();
        }else
        {
            System.out.println("输入 的编号有误！");
        }
    }
}
