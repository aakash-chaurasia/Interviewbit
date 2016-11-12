package DynamicProgramming.MatrixDp;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Aakash on 11/10/2016.
 */
public class MaxRectangleInBinaryMatrix {
    public static void main(String[] args) {
        MaxRectangleInBinaryMatrix maxRectangleInBinaryMatrix = new MaxRectangleInBinaryMatrix();
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> t = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                t.add(sc.nextInt());
            }
            a.add(t);
        }
        int res = maxRectangleInBinaryMatrix.maximalRectangle(a);
        System.out.println("res = " + res);
    }

    public int maximalRectangle(ArrayList<ArrayList<Integer>> a) {
        int result = 0;
        if(a.size() > 0) {
            int m = a.size();
            int n = a.get(0).size();
            int left[] = new int[n];
            int right[] = new int[n];
            int height[] = new int[n];
            for (int i = 0; i < n; i++) {
                right[i] = n;
            }
            for (int i = 0; i < m; i++) {
                int curLeft = 0;
                int curRight = n;
                for (int j = 0; j < n; j++) {
                    if(a.get(i).get(j) == 1) {
                        height[j] += 1;
                    } else {
                        height[j] = 0;
                    }
                }

                for (int j = 0; j < n; j++) {
                    if(a.get(i).get(j) == 1) {
                        left[j] = Math.max(left[j], curLeft);
                    } else {
                        left[j] = 0;
                        curLeft = j + 1;
                    }
                }

                for (int j = n - 1; j > -1; j--) {
                    if(a.get(i).get(j) == 1) {
                        right[j] = Math.min(right[j], curRight);
                    } else {
                        right[j] = n;
                        curRight = j;
                    }
                }

                for (int j = 0; j < n; j++) {
                    result = Math.max(result, (right[j] - left[j])*height[j]);
                }
            }
        }
        return result;
    }
}
