package puzzle2;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        Solution mySolution = new Solution();
        int totalValidPasswords = 0;
        for (int i = 128392; i < 643282; i++) {
            if (mySolution.validPassword(i)) {
                totalValidPasswords++;
            }
        }
        System.out.println(totalValidPasswords);
    }

    public boolean validPassword(int password) {
        boolean doubleFound = false;
        boolean decreasingDigits = true;
        int passwordCheck = password;
        int prevDigit = passwordCheck % 10;
        passwordCheck /= 10;
        Map<Integer, Integer> digitFreq = new HashMap<Integer, Integer>();
        digitFreq.put(prevDigit, 1);
        while (passwordCheck > 0) {
            int currDigit = passwordCheck % 10;
            digitFreq.put(currDigit, digitFreq.getOrDefault(currDigit, 0)+1);
            if (prevDigit < currDigit) {
                decreasingDigits = false;
            }
            
            prevDigit = currDigit;
            passwordCheck /= 10;
        }

        for (Integer frequency : digitFreq.values()) {
            if (frequency == 2) {
                doubleFound = true;
                break;
            }
        }
        return doubleFound && decreasingDigits;
    }

}