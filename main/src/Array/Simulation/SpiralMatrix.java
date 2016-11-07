package Array.Simulation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by Aakash on 11/7/2016.
 */
public class SpiralMatrix {
    public ArrayList<ArrayList<Integer>> generateMatrixZigZag(int a) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int counter = 0;
        int inc_dec = 1;
        for (int i = 0; i < a; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = 0; j < a; j++) {
                counter += inc_dec;
                temp.add(counter);
            }
            counter += a + 1*inc_dec;
            inc_dec *= -1;
            result.add(temp);
        }
        return result;
    }

    public ArrayList<ArrayList<Integer>> generateMatrix(int a) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int mat[][] = new int[a][a];
        int counter = 1;
        int row = 0;
        int col = 0;
        int dir = 1;
        boolean rowcol = true;
        while (counter <= a*a) {
            if(rowcol) {
                while(col < a && col >= 0 && mat[row][col] == 0) {
                    mat[row][col] = counter++;
                    col += dir;
                }
                rowcol = false;
                col -= dir;
                row += dir;
            } else {
                while(row < a && row >= 0 && mat[row][col] == 0) {
                    mat[row][col] = counter++;
                    row += dir;
                }
                row -= dir;
                col -= dir;
                dir *= -1;
                rowcol = true;
            }
        }
        for (int i = 0; i < a; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = 0; j < a; j++) {
                temp.add(mat[i][j]);
            }
            result.add(temp);
        }
        return result;
    }

    public static void main(String[] args) {
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<ArrayList<Integer>> result = spiralMatrix.generateMatrix(n);
        for (Iterator<ArrayList<Integer>> iterator = result.iterator(); iterator.hasNext(); ) {
            ArrayList<Integer> next =  iterator.next();
            for (Iterator<Integer> integerIterator = next.iterator(); integerIterator.hasNext(); ) {
                Integer integer =  integerIterator.next();
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
