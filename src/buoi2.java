import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created by VALV on 7/9/2017.
 */
public class buoi2 {
    public static void main(String[] args) {
        Vector<Integer> Numbers = new Vector<>();
        Numbers.add(10);
        Numbers.add(5);
        Numbers.add(6);
        Numbers.add(9);

//        Numbers.remove(1);
        System.out.println(String.format("Numbers [%s] = %s", 2,Numbers.get(2)));

//        for(int i = 0; i < Numbers.size(); i++)
//        {
//            Integer Number = Numbers.get(i);
//            if (Number % 2 == 0)
//            {
//                Numbers.remove(Number);
//                i--;
//            }
////            System.out.println(Number);
////            if(Number % 2 == 0)
////                Numbers.remove(Number);
//
//        }
//        System.out.println(Numbers);

        // chú ý phần Iterator
        Iterator<Integer> iterator = Numbers.iterator();
        Vector<Integer> newNumber = new Vector<>();
//        while(iterator.hasNext())
//        {
//            Integer Number = iterator.next();
//            if(Number == 6)
//                iterator.remove();
//        }
        for(Integer Number : Numbers)
        {
            if(Number == 6)
            {
                // Add new Number
                newNumber.add(Number + 6);
            }
        }

        Numbers.addAll(newNumber);
        newNumber.clear();
//        for(Integer i : newNumber)
//        {
//            Numbers.add(i);
//        }

        //   Numbers.removeIf(Number -> Number == 6); // bang voi ham iterator tren
        //   lam da expression
        System.out.println(Numbers);
    }

}
