import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aakash on 10/29/2016.
 */
public class Array_MissingAndRepeatNumber {
    public ArrayList<Integer> repeatedNumber(final List<Integer> a) {
        int len = a.size();
        int miss = 0;
        for(int i = 1; i < len + 1; i++){
            if(!a.contains(i)) {
                miss = i;
            } else {
                a.remove(new Integer(i));
            }
        }
        a.add(miss);
        return (ArrayList)a;
    }

    public ArrayList<Integer> repeatedNumberOptimized(final List<Integer> a) {
        int len = a.size();
        boolean flag[] = new boolean[len];
        ArrayList<Integer> myList = new ArrayList<Integer>();
        long Expectedsum =  len * (len + 1) / 2;
        long actualSum = 0;
        int repeat = 0;
        for(int i : a) {
            actualSum += i;
            if(flag[i - 1]) {
                repeat = i;
            }
            flag[i - 1] = true;
        }
        int diff = (int)(actualSum - Expectedsum);
        int miss = repeat - diff;
        myList.add(repeat);
        myList.add(miss);
        return myList;
    }

    public static void main(String[] args) {
        Array_MissingAndRepeatNumber array_missingAndRepeatNumber = new Array_MissingAndRepeatNumber();
        final ArrayList<Integer> input =  new ArrayList<Integer>();
        ArrayList<Integer> input2 = null;
        input.add(5);
        input.add(2);
        input.add(1);
        input.add(2);
        input.add(3);
        input2  = array_missingAndRepeatNumber.repeatedNumberOptimized(input);
        for(int v : input2) {
            System.out.println("v = " + v);
        }
    }
}
