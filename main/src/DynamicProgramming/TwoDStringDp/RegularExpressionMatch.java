package DynamicProgramming.TwoDStringDp;

/**
 * Created by Aakash on 1/25/2017.
 */
public class RegularExpressionMatch {
    public int isMatch(final String s, final String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= p.length(); i++) {
            if(p.charAt(i - 1) == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (p.charAt(j - 1) == '?' || p.charAt(j - 1) == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*' && (dp[i][j - 1] || dp[i - 1][j])) {
                    dp[i][j] = true;
                }
            }
        }

        return dp[s.length()][p.length()] ? 1 : 0;
    }
}
