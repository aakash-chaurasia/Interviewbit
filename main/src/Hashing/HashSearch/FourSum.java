package Hashing.HashSearch;

/**
 * Created by Aakash on 12/17/2016.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class FourSum {
    public void threeSum(int[] nums, int start, int end, int target, int z, List<List<Integer>> result) {

        if(end - start < 2 || 3 * nums[start] > target || 3 * nums[end - 1] < target) {
            return;
        }
        for (int i = start; i < end; i++) {
            int first = nums[i];
            int j = i + 1;
            int k = end - 1;
            while (j < k) {
                int temp = first + nums[j] + nums[k];
                if(temp == target) {
                    List<Integer> l = new ArrayList<>();
                    l.add(z);
                    l.add(first);
                    l.add(nums[j]);
                    l.add(nums[k]);
                    result.add(l);
                    while(j < k && nums[j] == nums[j + 1]) j++;
                    j++;
                } else if(temp > target) {
                    k--;
                } else {
                    j++;
                }
            }
            while(i <  end - 2 && nums[i] == nums[i + 1])i++;
        }
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int len  = nums.length;
        if(len < 4 || 4 * nums[0] > target || 4 * nums[len - 1] < target) {
            return result;
        }
        for (int i = 0; i < len - 3; i++) {
            threeSum(nums, i + 1, len, target - nums[i], nums[i], result);
            while(i <  len - 2 && nums[i] == nums[i + 1])i++;
        }
        return result;
    }

    public static void main(String[] args) {
        FourSum problem18_4SUM = new FourSum();
        int[] a = {1, 0, -1, 0, -2, 2};
        List<List<Integer>> res = problem18_4SUM.fourSum(a, 0);
        for (Iterator<List<Integer>> iterator = res.iterator(); iterator.hasNext(); ) {
            List<Integer> next =  iterator.next();
            for (Iterator<Integer> integerIterator = next.iterator(); integerIterator.hasNext(); ) {
                Integer integer =  integerIterator.next();
                System.out.println(" " + integer);
            }
            System.out.println();
        }
    }
}
