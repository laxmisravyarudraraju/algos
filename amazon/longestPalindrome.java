package amazon;

class LongestCommonSubsequence {
    private String x;
    private String y;

    LongestCommonSubsequence(String x, String y) {
        this.x = x;
        this.y = y;
    }

    public  char[] getLcs() {
        int lengthX = x.length();
        int lengthY = y.length();
        int[][] C = new int[lengthX+1][lengthY+1];

        for (int i = 0; i <= lengthX; i++) {
            for (int j = 0; j <= lengthY; j++) {
                if (i == 0 || j == 0) {
                    C[i][j] = 0;
                } else if (x.charAt(i-1) == y.charAt(j-1)) {
                    C[i][j] = 1 + C[i-1][j-1]; 
                } else {
                    C[i][j] = Math.max(C[i-1][j], C[i][j-1]);
                }
            }
        }

        int index = C[lengthX][lengthY];
        char[] lcs = new char[index+1];
        lcs[index] = '\0';

        int i = lengthX;
        int j = lengthY;
        while (i > 0 && j > 0) {
            if (x.charAt(i-1) == y.charAt(j-1)) {
                lcs[index-1] = x.charAt(i-1);
                i--; 
                j--; 
                index--;
            } else if (C[i-1][j] > C[i][j-1]) {
                i--;
            } else {
                j--;
            }
        }

        return lcs;
    }
}

class LongestPalindrome {
    private String x;
    
    longestPalindrome(String x) {
        this.x = x;
    }

    public char[] getLongestPalindrome() {
        StringBuilder y = new StringBuilder();
        y.append(x);
        y.reverse();
        String reversedString = y.toString();
        LongestCommonSubsequence lcs = new LongestCommonSubsequence(x, reversedString);
        return lcs.getLcs();
    }
}


