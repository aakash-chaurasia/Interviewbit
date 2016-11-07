package Array.Math;

/**
 * Created by Aakash on 10/25/2016.
 */
public class Array_MaxSumContigousSubArray {
    public static void main(String[] args) {
        Array_MaxSumContigousSubArray obj = new Array_MaxSumContigousSubArray();
        int[] a = {1, 2, 3, -2, 4, 1, -3, 5, 6};
        long sum = obj.largestSum(a);
        System.out.println("sum = " + sum);
    }

    private long largestSum(int[] a) {
        long sum = 0;
        long max = 0;
        for(int i : a) {
            sum += i;
            if(sum < 0) {
                sum = 0;
            }
            if(sum > max) {
                max = sum;
            }
        }
        return sum;
    }
}
