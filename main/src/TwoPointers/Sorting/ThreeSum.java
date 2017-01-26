package TwoPointers.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Aakash on 11/16/2016.
 */
public class ThreeSum {
    public int threeSumClosest(ArrayList<Integer> a, int v) {
        int res =  Integer.MIN_VALUE;
        Collections.sort(a);
        for (int i = 0; i < a.size(); i++) {
            int first = a.get(i);
            int j = i + 1;
            int k = a.size() - 1;
            while(j < k) {
                int temp = first + a.get(j) + a.get(k);
                if(res == Integer.MIN_VALUE) {
                    res = temp;
                }
                if (temp == v) {
                    return v;
                } else if (temp < v) {
                    j++;
                    if(Math.abs(v - res) > Math.abs(v - temp)) {
                        res = temp;
                    }
                } else {
                    k--;
                    if(Math.abs(v - res) > Math.abs(v - temp)) {
                        res = temp;
                    }
                }
            }
        }
        return res;
    }
}
