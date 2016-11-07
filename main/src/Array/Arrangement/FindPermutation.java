package Array.Arrangement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aakash on 11/7/2016.
 */
public class FindPermutation {
    public ArrayList<Integer> findPerm(final String A, int B) {
        ArrayList<Integer> a = permute(generateRle(A));
        return a;
    }

    public List<String> generateRle(String s){
        List<String> result = new ArrayList<>();
        char prev=s.charAt(0);
        result.add(prev+"");
        int count = 1;
        for(int i = 1; i < s.length();i++){
            if(prev == s.charAt(i)) {
                count++;
            } else {
                result.add(count+"");
                prev = s.charAt(i);
                result.add(prev+"");
                count = 1;
            }
        }
        result.add(count + "");
        return result;
    }

    boolean flag = false;
    private ArrayList<Integer> permute(List<String> rle) {
        int count = 1;
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < rle.size(); i = i + 2) {
            int c = Integer.parseInt(rle.get(i + 1));
            if(rle.get(i).equalsIgnoreCase("I")){
                if(i != 0 && i+2 != rle.size()) {
                    c--;
                }
                if(i+2 == rle.size() && !flag){
                    c = c + 1;
                }
                for(int j = 0; j < c; j++) {
                    result.add(count);
                    count++;
                }
            } else {
                flag = true;
                for(int j = count + c; j > count; j--) {
                    result.add(j);
                }
                result.add(count);
                count = count + c + 1;
            }
        }
        return result;
    }
}
