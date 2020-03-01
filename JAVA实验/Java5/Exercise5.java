package Java5;
import java.util.Scanner;
public class Exercise5 {
    public static boolean even(int m) throws ArgumentOutOfBoundsException {
        if (m<0||m>100) {
            ArgumentOutOfBoundsException ae = new ArgumentOutOfBoundsException();
            throw ae;
        } else {
            return true;
        }
    }
    public static void main(String args[]) {
        int num;
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个正整数：");
        num = input.nextInt();
        try {
            boolean result = even(num);
            System.out.println("输入正常！");
        } catch (ArgumentOutOfBoundsException e) {

            System.out.println("产生的异常名称为：" + e.toString());
        }
    }
}

class ArgumentOutOfBoundsException extends Exception {
    ArgumentOutOfBoundsException() {
        System.out.println("输入错误！预判断的数不在0-100范围内！");
    }
}

