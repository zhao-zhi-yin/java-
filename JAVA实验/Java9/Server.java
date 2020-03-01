package Java9;

import java.io.*;
import java.net.*;
public class Server
{
    public static void main(String args[])throws Exception //为突出重点，不捕获异常
    {
        DatagramSocket ds=new DatagramSocket(2288);
        BufferedReader kbr=new BufferedReader(new InputStreamReader(System.in)); //键盘输入
        byte[] buf=new byte[1024];
        DatagramPacket rdp=null;
        DatagramPacket sdp=null;
        boolean flag=true;
        while(flag)
        {
            rdp=new DatagramPacket(buf,1024); //创建一个用于接收数据的UDP数据包
            ds.receive(rdp); //等待一个客户机发送数据包
            InetAddress caddr=rdp.getAddress(); //获取客户机的IP地址
            int cport=rdp.getPort(); //获取客户机的端口号
            String s=new String(rdp.getData(),rdp.getOffset(),rdp.getLength());//获取客户机发送的文本内容
            /*do {
                byte[] sbuf1=null;
                System.out.println("Send to client:\r\n");
                s = kbr.readLine(); //从键盘读入一行文本行
                sbuf1 = s.getBytes(); //将键盘输入放到字节缓冲区内
                sdp = new DatagramPacket(sbuf1, sbuf1.length, caddr, cport); //生成一个
                ds.send(sdp);
            }while(!s.equals("end"));
            */
            if(s.equals("end")) //服务器端收到end之后，向客户端返回一个回答，然后结束
            {
                String rs=new String("ok,end!");
                byte[] sbuf=rs.getBytes(); //服务器将要发回的串
                sdp=new DatagramPacket(sbuf,sbuf.length,caddr,cport);//生成一个
                //发回客户机的UDP数据包的DatagramPacket对象
                ds.send(sdp);
                ds.close();
                break;
            }
            System.out.println("Client's IP is："+caddr+" Client's Port is："+cport+" Data from Client is："+s+"\r\n");

            String rs=new String("length of "+s+" is "+s.length());
            byte[] sbuf=rs.getBytes(); //服务器将要发回的串
            sdp=new DatagramPacket(sbuf,sbuf.length,caddr,cport); //生成一个
            //发回客户机的UDP数据包的DatagramPacket对象
            ds.send(sdp);

        }
    }
}