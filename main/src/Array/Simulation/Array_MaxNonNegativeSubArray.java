package Array.Simulation;

import java.util.ArrayList;

/**
 * Created by Aakash on 10/25/2016.
 */
public class Array_MaxNonNegativeSubArray {
    public ArrayList<Integer> maxset(ArrayList<Integer> a) {
        int start = -1;
        int end = -1;
        Long max = Long.MIN_VALUE;
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i < a.size(); i++) {
            Long sum = (long)a.get(i);
            if (sum > -1) {
                if (sum > max) {
                    max = sum;
                    start = i;
                    end = i;
                }
                for (int j = i + 1; j < a.size() && a.get(j) > -1; j++) {
                    sum += a.get(j);
                    if (sum > max) {
                        max = sum;
                        start = i;
                        end = j;
                    } else if (sum == max) {
                        if (end - start < j - i) {
                            start = i;
                            end = j;
                        }
                    }
                }
            }
        }
        for(int i = start; i <= end && end != -1; i++){
            result.add(a.get(i));
        }
        return result;
    }

    public ArrayList<Integer> optimised(ArrayList<Integer> a) {
        long maxSum = 0;
        long newSum = 0;
        ArrayList<Integer> maxArr = new ArrayList<Integer>();
        ArrayList<Integer> newArr = new ArrayList<Integer>();
        for(int i : a) {
            if(i >= 0) {
                newSum += i;
                newArr.add(i);
            } else {
                newSum = 0;
                newArr = new ArrayList<Integer>();
            }
            if(newSum > maxSum || (maxSum == newSum && newArr.size() > maxArr.size())) {
                maxSum = newSum;
                maxArr = newArr;
            }
        }
        return maxArr;
    }

    public static void main(String[] args) {
        Array_MaxNonNegativeSubArray obj = new Array_MaxNonNegativeSubArray();
        ArrayList<Integer> input =  new ArrayList<Integer>();
        input.add(1);
        input.add(2);
        input.add(5);
        input.add(-7);
        input  = obj.optimised(input);
        for(int v : input) {
            System.out.println("v = " + v);
        }
    }
}
