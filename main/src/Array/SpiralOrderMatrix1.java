package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aakash on 1/25/2017.
 */
public class SpiralOrderMatrix1 {

    public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> a) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        // Populate result;
        int rs = 0;
        int re = a.size() - 1;
        int cs = 0;
        int ce = a.get(0).size() - 1;

        while(rs <= re && cs <= ce) {
            for (int i = cs; i <= ce; i++) {
                result.add(a.get(rs).get(i));
            }
            rs++;

            for (int i = rs; i <= re; i++) {
                result.add(a.get(i).get(ce));
            }
            ce--;
            if(rs <= re) {
                for (int i = ce; i >= cs; i--) {
                    result.add(a.get(re).get(i));
                }
                re--;
            }

            if(cs <= ce) {
                for (int i = re; i >= rs; i--) {
                    result.add(a.get(i).get(cs));
                }
                cs++;
            }
        }
        return result;
    }
}
