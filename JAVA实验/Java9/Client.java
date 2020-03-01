package Java9;

import java.io.*;
import java.net.*;
public class Client
{
    public static void main(String args[])throws Exception //为突出重点，不捕获异常
    {
        DatagramSocket ds=new DatagramSocket(); //生成一个客户机用的UDP Socket
        DatagramPacket sdp=null; //发送用的UDP数据包
        DatagramPacket rdp=null; //接收用的UDP数据包
        BufferedReader kbr=new BufferedReader(new InputStreamReader(System.in)); //键盘输入
        String s=null;
        byte[] rbuf=new byte[1024]; //接收缓冲区大小设置为1024
        byte[] sbuf=null;
        do
        {
            System.out.println("Send to server:\r\n");
            s=kbr.readLine(); //从键盘读入一行文本行
            sbuf=s.getBytes(); //将键盘输入放到字节缓冲区内
            sdp=new DatagramPacket(sbuf,sbuf.length,InetAddress.getByName("127.0.0.1"),2288);
//生成一个
            //发送给服务器的UDP数据包
            ds.send(sdp);
            rdp=new DatagramPacket(rbuf,1024); //生成一个接收用的数据包
            ds.receive(rdp); //等待并读取服务器的响应
            String data=new String(rdp.getData(),rdp.getOffset(),rdp.getLength());//获取服务器发回的数据
            System.out.println("the response of UDP Server is:"+data+"\r\n");
        }while(!s.equals("end")); //直到客户端用户输入“end”时才结束
        ds.close(); //关闭UDP Socket
    }

}