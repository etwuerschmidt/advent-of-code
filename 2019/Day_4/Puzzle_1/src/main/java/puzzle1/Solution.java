package puzzle1;

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
        while (passwordCheck > 0) {
            int currDigit = passwordCheck % 10;
            if (prevDigit == currDigit) {
                doubleFound = true;
            }
            
            if (prevDigit < currDigit) {
                decreasingDigits = false;
            }

            prevDigit = currDigit;
            passwordCheck /= 10;
        }
        return doubleFound && decreasingDigits;
    }

}