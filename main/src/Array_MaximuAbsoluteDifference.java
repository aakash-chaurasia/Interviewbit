import java.util.ArrayList;

/**
 * Created by Aakash on 10/26/2016.
 */
public class Array_MaximuAbsoluteDifference {
    public int maxArrMine(ArrayList<Integer> A) {
        int max = 0;
        int start = 0;
        for(int i : A.subList(0, A.size() - 1)) {
            int diff = 1;
            start++;
            for(int j : A.subList(start, A.size())){
                int sum = Math.abs(i - j) + diff++;
                if(sum >  max){
                    max = sum;
                }
            }
        }
        return max;
    }

    public int maxArr(ArrayList<Integer> A) {

        int max1 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int max2 = Integer.MIN_VALUE;
        int min2 = Integer.MAX_VALUE;
        int index = 0;
        for(int i : A) {
            if(max1 < i + index) {
                max1 = i +index;
            }
            if(max2 < i - index) {
                max2 = i - index;
            }
            if(min1 > i + index) {
                min1 = i + index;
            }
            if(min2 > i - index) {
                min2 = i - index;
            }
            index++;
        }

        return Math.max(max1 - min1, max2 - min2);
    }

    public static void main(String[] args) {
        Array_MaximuAbsoluteDifference obj = new Array_MaximuAbsoluteDifference();
        ArrayList<Integer> input =  new ArrayList<Integer>();
        input.add(1);
        input.add(2);
        input.add(5);
        input.add(-7);
        int sum = obj.maxArr(input);
        System.out.println("sum = " + sum);
    }
}

