package Java7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;
public class Exercise9 {
    public static void main(String[] args) throws IOException {
            String str;
            int i=0,j=0,k=0,h=1;
            String per_string[] = new String[100];
            String last_string;
            int salary[] = new int[100];
            File fl = new File("D:\\JAVA\\Java文件\\工资记录.txt");
            FileReader fis = new FileReader(fl);
            BufferedReader br = new BufferedReader(fis);
           // System.out.println("读取文件中。。。");
            while((str=br.readLine())!=null)//得到文件内容
            {
                System.out.println(str);//显示信息
                StringTokenizer st =new StringTokenizer(str," ");//空格隔开
                while(st.hasMoreTokens())
                {
                    per_string[j]=st.nextToken();//将2每个空格之前的字符串存储到数组中
                    j++;
                }
            }
            fis.close();
            System.out.println("是否将工资加上10%后保存(Y/N):");
            @SuppressWarnings("resource")
            Scanner input   = new Scanner(System.in);
            if(input.next().equals("Y"))
            {
                File f2=new File("D:\\JAVA\\Java文件\\工资记录.txt");
                FileWriter fw = new FileWriter(f2);
                BufferedWriter bw = new BufferedWriter(fw);
                for(i=0;i<j;i++)
                {
                    if(i!=1)
                    {
                        if(h%3==2)
                        {
                            salary[k]=Integer.parseInt(per_string[i]);
                            k++;
                        }
                    }
                    h++;
                }
                for(i=0;i<k;i++)//将工资增加10%
                {
                    salary[i]=(int)(salary[i]*0.1+salary[i]);
                }
                h=1;
                k=0;
                for(i=0;i<j;i++)
                {
                    if(i!=1)
                    {
                        if(h%3==2)
                        {
                            per_string[i]=Integer.toString(salary[k]);
                            k++;
                        }
                    }
                    h++;
                }
                h=1;
                for(i=0;i<j;i++)
                {
                    last_string=per_string[i];
                    bw.write(last_string,0,last_string.length());
                    bw.write(" ",0,1);
                    if(h%3==0)
                    {
                        bw.write("\r\n",0,2);
                    }
                    h++;
                }
                bw.flush();
                fw.close();
                System.out.println("保存成功，系统已退出。。。");
            }
            else
            {
                System.out.println("系统已退出。。。");
            }
    }
}

