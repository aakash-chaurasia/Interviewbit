package Array.Math;

import java.util.ArrayList;

/**
 * Created by Aakash on 10/29/2016.
 */
public class Array_Flip {
    public ArrayList<Integer> flip(String A) {
        char[] input = A.toCharArray();
        int finalStart = -1;
        int finalEnd = -1;
        int start = -1;
        int end = -1;
        int max = -1;
        int curr = 0;
        for(int i = 0; i < input.length; i++) {
            if(input[i] == '0'){
                curr++;
                if(start == -1){
                    start = i;
                }
                end = i;
                if(curr > max) {
                    max = curr;
                    finalStart = start;
                    finalEnd = end;
                }
            } else {
                curr--;
                if(curr < 0) {
                    curr = 0;
                    start = -1;
                    end = -1;
                }
            }
        }
        ArrayList<Integer> output = new ArrayList<>();
        if(finalStart != -1) {
            output.add(finalStart+1);
            output.add(finalEnd+1);
        }
        return output;
    }

    public static void main(String[] args) {
        Array_Flip array_flip = new Array_Flip();
        ArrayList<Integer> output = array_flip.flip("010");
        for(int i : output) {
            System.out.println("i = " + i);
        }
    }
}
