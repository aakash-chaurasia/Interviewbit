package Array;

import java.util.ArrayList;

/**
 * Created by Aakash on 10/25/2016.
 */
public class Array_AddOneToNumber {
    public ArrayList<Integer> plusOne(ArrayList<Integer> a) {
        int len = a.size();
        int carry = 0;
        int i = 1;
        do {
            int sum = (a.get(len - i) + 1)%10;
            carry = (a.get(len - i) + 1)/10;
            a.set(len - i++, sum);
        } while (carry == 1 && i <= len);
        ArrayList<Integer> res = new ArrayList<Integer>();
        boolean flag = false;
        if(carry == 1){
            res.add(1);
            flag = true;
        }
        for(int value : a) {
            if(value != 0) {
                flag = true;
            }
            if(flag) {
                res.add(value);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Array_AddOneToNumber obj = new Array_AddOneToNumber();
        ArrayList<Integer> input =  new ArrayList<Integer>();
        input.add(0);
        input.add(0);
        input.add(9);
        input.add(9);
        input.add(9);
        input.add(9);
        input  = obj.plusOne(input);
        for(int v : input){
            System.out.println("v = " + v);
        }
    }
}
