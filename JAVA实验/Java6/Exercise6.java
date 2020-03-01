package Java6;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Exercise6 {
     JPanel b=new JPanel();
     JFrame jf=new JFrame("简易计算器");
     JLabel j11=new JLabel("简易计算器");
     JLabel j12=new JLabel("运算数一");
     JLabel j13=new JLabel("运算数二");
     JLabel j14=new JLabel("运算结果");
     JButton button1=new JButton("相加");
     JButton button2=new JButton("相减");
     JButton button3=new JButton("全部清零");
     JTextField a1=new JTextField(20);
     JTextField a2=new JTextField(20);
     JTextField a3=new JTextField(20);
    public Exercise6(){
         jf.add(b);
         jf.setSize(350,400);
         b.setLayout(null);
         b.add(j11);
         b.add(j12);
         b.add(j13);
         b.add(j14);
         b.add(a1);
         b.add(a2);
         b.add(a3);
         b.add(button1);
         b.add(button2);
         b.add(button3);
         j11.setBounds(120,0,80,40);
         j12.setBounds(60,40,80,20);
         j13.setBounds(60,80,80,20);
         j14.setBounds(60,120,80,20);
         a1.setBounds(140,40,100,30);
         a2.setBounds(140,80,100,30);
         a3.setBounds(140,120,100,30);
         button1.setBounds(60,160,100,30);
         button2.setBounds(200,160,100,30);
         button3.setBounds(120,220,100,30);
         jf.setResizable(true);
         jf.setVisible(true);
         button1.addMouseListener(new MouseListener() {
              @Override
              public void mouseClicked(MouseEvent e) {

              }

              @Override
              public void mousePressed(MouseEvent e) {
                   String s1=a1.getText();
                   String s2=a2.getText();
                   if(s2.isEmpty()||s1.isEmpty()) //判断输入是否为空
                   {
                        JOptionPane.showMessageDialog(null,"请填入数据再计算！");
                        return;
                   }
                   if(s1.charAt(0)=='.'||s2.charAt(0)=='.')  //判断开头是否非法
                   {
                    JOptionPane.showMessageDialog(null,"输入开头数据非法！");
                    return;
                   }
                   char x,y;
                   for(int i=0;i<s1.length();i++) //判断数据1是否正确
                   {
                        x=s1.charAt(i);
                        if(x=='.')
                        {
                             for(int m=i+1;m<s1.length();m++)
                               if(s1.charAt(m)=='.')
                             {
                               JOptionPane.showMessageDialog(null,"运算数一中有多个小数点");
                               return;
                             }
                        }
                        if(!((x>'0'&&x<'9')||x=='.'))
                        {
                             JOptionPane.showMessageDialog(null,"运算数一输入错误");
                             return;
                        }
                   }
                   for(int j=0;j<s2.length();j++) //判断数据2输入是否正确
                   {
                        y=s2.charAt(j);
                        if(y=='.')
                        {
                             for(int n=j+1;n<s2.length();n++)
                                  if(s2.charAt(n)=='.')
                                  {
                                       JOptionPane.showMessageDialog(null,"运算数二中有多个小数点");
                                       return;
                                  }
                        }
                        if(!((y>'0'&&y<'9')||y=='.'))
                        {
                             JOptionPane.showMessageDialog(null,"运算数二输入错误");
                             return;
                        }
                   }
                   Double te1=Double.valueOf(s1);
                   Double te2=Double.valueOf(s2);
                   String s3=String.valueOf(te1+te2);
                   a3.setText(s3);
              }

              @Override
              public void mouseReleased(MouseEvent e) {

              }

              @Override
              public void mouseEntered(MouseEvent e) {

              }

              @Override
              public void mouseExited(MouseEvent e) {

              }
         });
         button2.addMouseListener(new MouseListener() {
              @Override
              public void mouseClicked(MouseEvent e) {

              }

              @Override
              public void mousePressed(MouseEvent e) {
                   String s1 = a1.getText();
                   String s2 = a2.getText();
                   if(s2.isEmpty()||s1.isEmpty()) //判断输入是否为空
                   {
                        JOptionPane.showMessageDialog(null,"请填入数据再计算！");
                        return;
                   }
                   if(s1.charAt(0)=='.'||s2.charAt(0)=='.')  //判断开头是否非法
                   {
                        JOptionPane.showMessageDialog(null,"输入开头数据非法！");
                        return;
                   }
                   char x,y;
                   for(int i=0;i<s1.length();i++) //判断数据1是否正确
                   {
                        x=s1.charAt(i);
                        if(x=='.')
                        {
                             for(int m=i+1;m<s1.length();m++)
                                  if(s1.charAt(m)=='.')
                                  {
                                       JOptionPane.showMessageDialog(null,"运算数一中有多个小数点");
                                       return;
                                  }
                        }
                        if(!((x>'0'&&x<'9')||x=='.'))
                        {
                             JOptionPane.showMessageDialog(null,"运算数一输入错误");
                             return;
                        }
                   }
                   for(int j=0;j<s2.length();j++) //判断数据2输入是否正确
                   {
                        y=s2.charAt(j);
                        if(y=='.')
                        {
                             for(int n=j+1;n<s2.length();n++)
                                  if(s2.charAt(n)=='.')
                                  {
                                       JOptionPane.showMessageDialog(null,"运算数二中有多个小数点");
                                       return;
                                  }
                        }
                        if(!((y>'0'&&y<'9')||y=='.'))
                        {
                             JOptionPane.showMessageDialog(null,"运算数二输入错误");
                             return;
                        }
                   }
                   Double te1 = Double.valueOf(s1);
                   Double te2 = Double.valueOf(s2);
                   String s3 = String.valueOf(te1 - te2);
                   a3.setText(s3);
              }

              @Override
              public void mouseReleased(MouseEvent e) {

              }

              @Override
              public void mouseEntered(MouseEvent e) {

              }

              @Override
              public void mouseExited(MouseEvent e) {

              }
         });
         button3.addMouseListener(new MouseListener() {
              @Override
              public void mouseClicked(MouseEvent e) {

              }

              @Override
              public void mousePressed(MouseEvent e) {
                  a1.setText("");
                  a2.setText("");
                  a3.setText("");
              }

              @Override
              public void mouseReleased(MouseEvent e) {

              }

              @Override
              public void mouseEntered(MouseEvent e) {

              }

              @Override
              public void mouseExited(MouseEvent e) {

              }
         });
    }
     public static void main(String[] args){
         Exercise6 jba=new Exercise6();
     }
}
