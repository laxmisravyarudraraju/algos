package amazon;
import java.util.HashSet;
import java.util.Set;

class KLengthSubstring {
    private String s;
    
    KLengthSubstring(String s) {
        this.s = s;
    }
    
    public Set<String> findKSubstring(int k) {
        Set<String> answer = new HashSet<>();
        int[] lettersCount = new int[26];
        int low = 0;
        int high = 0;
        while (low <= high && high < s.length()) {
            lettersCount[s.charAt(high) - 'a']++;
            while (lettersCount[s.charAt(high) - 'a'] != 1) {
                lettersCount[s.charAt(low) - 'a']--;
                low++;
            }
            if (high - low + 1 == k) {
                answer.add(s.substring(low, high + 1));
                lettersCount[s.charAt(low) - 'a']--;
                low++;
            }
            high++;
        }
        return answer;
    }
}


class HelloWorld {
    public static void main(String[] args) {
        KLengthSubstring k = new KLengthSubstring("awaglknagawunagwkwagl");
        System.out.println(k.findKSubstring(4).toString());
    }
}