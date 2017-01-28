package Array;

/**
 * Created by Aakash on 1/27/2017.
 */
public class StairCase {
    public int generateSteps(int n) {
        if(n == 0) {
            return 1;
        }
        if(n < 0) {
            return 0;
        }
        return generateSteps(n - 1) + generateSteps(n - 2) + generateSteps(n - 3);
    }

    public static void main(String[] args) {
        StairCase sc = new StairCase();
        int steps = sc.generateSteps(6);
        System.out.println("steps = " + steps);
    }
}
