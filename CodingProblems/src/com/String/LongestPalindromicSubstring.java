package com.String;

public class LongestPalindromicSubstring {

    static String longestPalindromicSubstring(String s) {

        if (s == null || s.length() < 1) return "";

        //O(n square time) since we loop once and at each char we go left and right
        //O(1)
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            //center is the letter i . for odd length pallindrome
            int len1 = expandAroundCenter(s, i, i);
            //center is between letter i and next letter . even length pallindrom
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        //end + 1 because index end is included in string
        return s.substring(start, end + 1);
    }

    static int expandAroundCenter(String s, int left, int right) {

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;

    }
}
