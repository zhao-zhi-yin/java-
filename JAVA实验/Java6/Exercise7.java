package Java6;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;
class MyException extends Exception{
    public MyException() {
        super();
    }
    public MyException(String message) {
        super(message);
    }
}
public class Exercise7 extends JFrame {
    private JTextField textField;               //输入文本框
    private String input;                       //结果
    private String operator;                    //操作符
    public Exercise7() {
        input = "";
        operator = "";
        JPanel panel = new JPanel();
        textField = new JTextField(30);
        textField.setEditable(false);                       //文本框禁止编辑
        textField.setHorizontalAlignment(JTextField.LEFT);

        textField.setPreferredSize(new Dimension(500,60));//设置该组件的初始大小
        this.add(textField, BorderLayout.NORTH);//将textField加入本JFrame中，布局为边界布局，位置为north
        String[] name= {"7","8","9","+","4","5","6","-","1","2","3","*","0","C","=","/"};
        //将这个panel的布局设置为网格布局，有四行四列，行间距和列间距为1
        panel.setLayout(new GridLayout(4,4,1,1));
        for(int i=0;i<name.length;i++) {
            JButton button = new JButton(name[i]);
            //设置按钮的时间监听
            button.addActionListener(new MyActionListener());
            //将按钮加入到panel中
            panel.add(button);
        }
        //将panel加入到本JFrame中，布局为边界布局，位置为centre
        this.add(panel,BorderLayout.CENTER);
    }
    class MyActionListener implements ActionListener{           //内部类实现按钮响应
        @Override
        public void actionPerformed(ActionEvent e) {
            int cnt=0;
            String actionCommand = e.getActionCommand();            //获取按钮上的字符串
            if(actionCommand.equals("+") || actionCommand.equals("-") || actionCommand.equals("*")
                    || actionCommand.equals("/")) {
                input += " " + actionCommand + " ";
            }
            else if(actionCommand.equals("C")) {                    //清除输入
                input = "";
            }
            else if(actionCommand.equals("=")) {                    //按下等号
                try {
                    input+= "="+calculate(input);
                } catch (MyException e1) {
                    if(e1.getMessage().equals("被除数不能为0"))
                        input = e1.getMessage();
                    else
                        input = e1.getMessage();
                }
                textField.setText(input);
                input="";
                cnt = 1;
            }
            else
                input += actionCommand;                         //按下数字
            //因为如果不按“=”按钮cnt一直未0，所以可以保证显示输入的数字和操作键
            if(cnt == 0)
                textField.setText(input);
        }
    }
    private String calculate(String input) throws MyException{              //计算函数
        String[] comput = input.split(" ");
        //System.out.println(input);
        Stack<Double> stack = new Stack<>();
        Double m = Double.parseDouble(comput[0]);
        stack.push(m);                                      //第一个操作数入栈

        for(int i = 1; i < comput.length; i++) {
            if(i%2==1) {
                if(comput[i].equals("+"))
                    stack.push(Double.parseDouble(comput[i+1]));
                if(comput[i].equals("-"))
                    stack.push(-Double.parseDouble(comput[i+1]));
                if(comput[i].equals("*")) {                 //将前一个数出栈做乘法再入栈
                    Double d = stack.peek();                //取栈顶元素
                    stack.pop();
                    stack.push(d*Double.parseDouble(comput[i+1]));
                }
                if(comput[i].equals("/")) {                 //将前一个数出栈做乘法再入栈
                    double help = Double.parseDouble(comput[i+1]);
                    if(help == 0)
                        throw new MyException("被除数不能为0");           //不会继续执行该函数
                    double d = stack.peek();
                    stack.pop();
                    stack.push(d/help);
                }
            }
        }
        double d = 0d;
        while(!stack.isEmpty()) {           //求和
            d += stack.peek();
            stack.pop();
        }
        String result = String.valueOf(d);
        return result;
    }
    public static void main(String[] args) {
        JFrame f = new Exercise7();
        f.setTitle(f.getClass().getSimpleName());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setBounds(400, 200, 300, 300);
        f.setVisible(true);
    }
}
