package Array;

import java.util.*;
/**
 * Created by Aakash on 10/25/2016.
 */
public class Arrays_MinStepInfiniteGrid {
    int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
        int result = 0;
        for(int i = 0; i < X.size() - 1; i++) {
            result += calculateSteps(X.get(i), Y.get(i), X.get(i+1), Y.get(i+1));
        }
        return result;
    }

    int calculateSteps(int x1, int y1,int x2, int y2) {
        return Math.max(Math.abs(x2 - x1), Math.abs(y2 - y1));
    }
}


