package Java8;

public class Exercise10 {
    public static void main(String args[]){
        Numbers num=new Numbers();
        Name na=new Name();
        num.start(); //线程1 ->run
        na.start(); //线程2 ->run
    }
}
class Numbers extends Thread{
    public void run(){
        for(int i=0;i<=20;i++){
            System.out.print("NO."+i+" 1800301406 ");
        }
    }
}
class Name extends Thread{
    public void run(){
        for(int i=0;i<=20;i++){
            System.out.print("NO."+i+" 赵芝因 ");
        }
    }
}
