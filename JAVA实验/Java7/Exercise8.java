package Java7;
import java.io.*;

public class Exercise8 {
    public static void main(String[] args) throws IOException {
        //创建字节缓冲流输入对象，构造方法在传递字节输入流
         BufferedInputStream fis = new BufferedInputStream(new FileInputStream("D:\\JAVA\\Java文件\\桂电计算机学院Java实验指导书2019-V1.0.pdf")); //创建一个输入流
        // 创建字节缓冲流输出对象，构造方法在传递字节输出流
        BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream("D:\\JAVA\\Java文件\\copy.pdf"));   //创建一个输出流
         byte[] bytes = new byte[1024];   //数组缓冲读取多个字节
         int len = 0;
         while ((len=fis.read(bytes))!=-1)
         {
             fos.write(bytes,0,len);
         }
         System.out.println("复制成功！");
         fis.close();
         fos.close();
    }
}