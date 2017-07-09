import javax.print.attribute.standard.MediaSize;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by VALV on 7/5/2017.
 */
public class Program {

    public static void main(String[] args) {
        float t;
        ArrayList<Integer> arr = new ArrayList<>();
        float a = 1.0f;
        float b = 0;
        float c = 1.0f;
        float dt;
        dt = b*b + 4 * a * c;
//        if (dt<0)
//        {
//            System.out.println("pt vo nghiem");
//        }
//        else if (dt == 0)
//        {
//            double x = (-b/(2*a));
//            System.out.println(String.format("pt co nghiem kep x = %s", x));
//        }
//        else
//        {
//            double x1 = (-b + Math.sqrt(dt))/(2*a);
//            double x2 = (-b - Math.sqrt(dt))/(2*a);
//            System.out.println(String.format("pt co 2 nghiem phan biet: \n x1 = %s \n x2 = %s", x1,x2));
//        }
//        Scanner lol = new Scanner(System.in);
//        int Numberr = lol.nextInt();
//        System.out.println(Numberr);


        arr = new ArrayList<>();
//        int[] arr2 = {1 , 3, 4, 5};
        ArrayList<String> arr2 = new ArrayList<>();
        ArrayList<Integer> Number = new ArrayList<>();
        Number.add(3);
        Number.add(5);
        Number.add(7);
        Number.add(11);
        for(int Num : Number)
        {
            System.out.println(Num);
        }
        ArrayList<String> Name = new ArrayList<>();
        Name.add("Huy");
        Name.add("Nam");
        Name.add("Cuong");
        Name.add("Duy");
        System.out.println(Name);
        for(String Ten : Name)
        {
            System.out.println(Ten);
//            System.out.println(Name);

        }
        Name.set(0,"Boss");
        Name.remove(3);
//        Name.remove(1);
//        System.out.println(Name.get(3));
        System.out.println(Name);
        for(String x : Name)
        {
            System.out.println(x);
        }


    }
}
