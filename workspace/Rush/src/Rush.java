
import java.io.*;

public class Rush
{
    public static void main(String[] args)throws Exception 
    {
     BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
     
     String name = reader.readLine();
     String a = reader.readLine();
     String b = reader.readLine();
     int num1 = Integer.parseInt(a);
     int num2 = Integer.parseInt(b);
     
     System.out.print(name+" получет "+num1+" через "+num2+" лет.");

    }
}