  
 class Animal  
 {  
    public void eat()  
    {  
        System.out.println("����� eating...");  
    }  
}  
class Bird extends Animal  
{     
    @Override  
    public void eat()  
    {  
        System.out.println("������д�ĸ����  eatting...");  
    }     
    public void fly()  
    {  
        System.out.println("�����·���  flying...");  
    }  
}  
public class Sys  
{  
    public static void main(String[] args)   
    {  
        Animal b=new Bird(); //����ת��  
        b.eat();   
        // b.fly(); //b��ָ��������󣬵���ʱ������Ϊ���ϵĴ��۶�ʧ�͸��಻ͬ��fly()����  
        sleep(new Male());  
        sleep(new Female());//����Ĳ���������-----����  
    }  
      
    public static void sleep(Human h) //�����Ĳ����Ǹ���------������  
        {  
         h.sleep();  
        }  
}                          
   
 class Human   
{  
    public void sleep()   
    {  
        System.out.println("��������   sleep..");  
    }  
}  
class Male extends Human  
{  
    @Override  
    public void sleep()   
    {  
        System.out.println("���� sleep..");  
    }  
}  
class Female extends Human   
{  
    @Override  
    public void sleep()  
    {  
        System.out.println("Ů�� sleep..");  
    }  
} 