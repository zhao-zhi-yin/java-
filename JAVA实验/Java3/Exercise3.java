package Java3;

import java.util.Scanner;

public class Exercise3 {
    public static void main (String arg[]) {
        int p;
        Handle handl;
        handl= new Handle();
        Scanner reader = new Scanner(System.in);
        handl.input();
            System.out.println("输入你想进入的菜单栏：");
            System.out.println("1.输出通讯录 ");
            System.out.println("2.查询通讯录 ");
            System.out.println("3.增加通讯录 ");
            System.out.println("4.修改通讯录 ");
            System.out.println("5.删除通讯录 ");
            p = reader.nextInt();
            switch (p) {
                case 1:
                    handl.output(handl.person);
                    break;
                case 2:
                    handl.serch(handl.person);
                    break;
                case 3:
                    handl.add(handl.person);
                    break;
                case 4:
                    handl.modifi(handl.person);
                    break;
                case 5:
                    handl.delete(handl.person);
                    break;
                default: break;
            }
        handl.output(handl.person);
    }
}
