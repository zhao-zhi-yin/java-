package Java8;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Exercise11 extends JFrame
{
    private JLabel lblTime = new JLabel();
    private JLabel lblDo = new JLabel();

    public Exercise11()
    {
        this.setLayout(new GridLayout(2, 1));
        add(lblTime);
        add(lblDo);
        new TimeThread().start(); //线程1 -> 获取系统时间
        new DoThread().start();  //线程2 -> 进行提醒
    }

    private class TimeThread extends Thread
    {
        public void run()
        {
            while (true)
            {
                Calendar calendar = new GregorianCalendar();
                lblTime.setText(String.format("现在是：%d年%02d月%02d日 %02d:%02d:%02d",
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH)+1,
                        calendar.get(Calendar.DATE),
                        calendar.get(Calendar.HOUR_OF_DAY),
                        calendar.get(Calendar.MINUTE),
                        calendar.get(Calendar.SECOND)));
                try
                {
                    Thread.sleep(1000); //计时等待
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    private class DoThread extends Thread
    {
        public void run()
        {
            while (true)
            {
                Calendar calendar = new GregorianCalendar();
                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                //int minute = calendar.get(Calendar.MINUTE);
                //int secord = calendar.get(Calendar.SECOND);
                if (8 <= hour && hour < 9)
                {
                    lblDo.setText("消息：该上课了!!");
                }
                else if (23 <= hour || hour < 8)
                {
                    lblDo.setText("消息：该休息了!!");
                }
                else
                {
                    lblDo.setText("消息：无");
                }

                try
                {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                JFrame frame = new Exercise11();
                frame.setSize(250, 100);
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //自定义关闭
            }
        });
    }
}