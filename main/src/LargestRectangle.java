import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Aakash on 11/10/2016.
 */
public class LargestRectangle {
    public static void main(String[] args) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        LargestRectangle largestRectangle = new LargestRectangle();
        Scanner sc= new Scanner(System.in);
        ArrayList<Integer> a = new ArrayList<>();
        int n = sc.nextInt();
        while(n-- > 0) {
            a.add(sc.nextInt());
        }
        int max = largestRectangle.largestRectangleArea(a);
        System.out.println("max = " + max);
    }
    public int largestRectangleArea(ArrayList<Integer> a) {
        System.out.println("MaxHistogramArea.getMaxArea");
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int i = 0;
        for (i = 0; i < a.size(); i++) {
            int i1 = a.get(i);
            if(stack.empty() || a.get(stack.peek()) <= i1) {
                stack.push(i);
            } else {
                int temp = stack.pop();
                int new_area = 0;
                if(stack.empty()) {
                    new_area = a.get(temp)*i;
                } else {
                    new_area = a.get(temp) * (i - stack.peek() - 1);
                }
                max = max < new_area ? new_area : max;
                i--;
            }
        }
        while(!stack.empty()) {
            int temp = stack.pop();
            int new_area = 0;
            if(stack.empty()) {
                new_area = a.get(temp) * i;
            } else {
                new_area = a.get(temp) * (i - stack.peek() - 1);
            }
            max = max < new_area ? new_area : max;
        }
        return max;
    }
}
