package StackAndQueues.SimplifyDirectoryPath;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aakash on 1/10/2017.
 */
public class RainTrapWater {

    public static void main(String[] args) {
        RainTrapWater rainTrapWater = new RainTrapWater();
        List<Integer> a = new ArrayList<>();
        a.add(3);
        a.add(0);
        a.add(0);
        a.add(2);
        a.add(0);
        a.add(4);
        int rain = rainTrapWater.trap(a);
        System.out.println("rain = " + rain);
    }

    public int trap(final List<Integer> a) {
        int len = a.size();
        if(len == 0) {
            return 0;
        }
        int[] left = new int[len];
        left[0] = a.get(0);
        for (int i = 1; i < len; i++) {
            left[i] = Math.max(left[i - 1], a.get(i));
        }

        int[] right = new int[len];
        right[len - 1] = a.get(len - 1);
        for (int i = len - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], a.get(i));
        }

        int water = 0;
        for (int i = 0; i < len; i++) {
            water += Math.min(left[i], right[i]) - a.get(i);
        }
        return water;
    }
}
