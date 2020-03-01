package Java5;
import java.util.Scanner;
public class Exercise4 {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int array[];
        array = new int[5];
        System.out.println("请输入五个整型数据：");
        for (int i = 0; i < 100; i++)
            array[i] = s.nextInt();
    }
}
