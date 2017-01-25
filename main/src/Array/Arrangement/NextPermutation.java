package Array.Arrangement;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Aakash on 1/10/2017.
 */
public class NextPermutation {
    
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        NextPermutation next = new NextPermutation();
        next.nextPermutation(a);
        for (Iterator<Integer> iterator = a.iterator(); iterator.hasNext(); ) {
            Integer integer =  iterator.next();
            System.out.println("integer = " + integer);
        }
    }
    
    public void nextPermutation(ArrayList<Integer> a) {
        int pivot = a.size() - 2;
        while (pivot > -1 && a.get(pivot) >= a.get(pivot + 1)) {
            pivot--;
        }
        if(pivot == -1) {
            for (int i = 0; i < a.size()/2; i++) {
                int temp = a.get(i);
                a.set(i, a.get(a.size() - 1 - i));
                a.set((a.size() - 1 - i), temp);
            }
            return;
        }
        int pivotValue = a.get(pivot);
        int swap = a.size() - 1;
        while(swap > pivot && pivotValue >= a.get(swap))
        {
            swap--;
        }

        a.set(pivot, a.get(swap));
        a.set(swap, pivotValue);

        for (int i = 0; i < (a.size() - pivot - 1)/2; i++) {
            int temp = a.get(pivot + i + 1);
            a.set(pivot + i + 1, a.get(a.size() - i - 1));
            a.set(a.size() - i - 1, temp);
        }
    }
}
