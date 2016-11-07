package Array;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by Aakash on 11/7/2016.
 */
public class KthPascal {
    public ArrayList<Integer> getRow(int a) {
        ArrayList<Integer> list = new ArrayList<>();
        int nCk = 1;
        for (int k = 0; k <= a; k++) {
            list.add(nCk);
            nCk = nCk * (a-k) / (k+1);
        }
        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        KthPascal kthPascal = new KthPascal();
        ArrayList<Integer> list = kthPascal.getRow(n);
        for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext(); ) {
            Integer next =  iterator.next();
            System.out.println("next = " + next);
        }
    }
}
