package LeetCode.Medium;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String []args){
        String s = "abcabcbb";
        int length = lengthOfLongestSubstring(s);
        System.out.println(length);
    }
    public static int lengthOfLongestSubstring(String s) {
        int left=0,right=0,res=0;
        Set<Character> set = new HashSet<>();
        while(right<s.length()){
            if(set.add(s.charAt(right))){
                res=Math.max(res, right-left+1);
                right++;
            }else {
                set.remove(s.charAt(left++));
            }

        }
        return res;
    }

    public static int lengthOfLongestSubstring2(String s) {
        HashSet<Character> set = new HashSet<>();
        int left=0, res=0;
        //loop the string, left starts from 0
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            //if set has the character, remove this char from the set and move left pointer
            //repeat this until set can add this character
            //otherwise, add this element into the set
            while(!set.add(c)){
                set.remove(s.charAt(left));
                left++;
            }
            res=Math.max(res, i-left+1);
        }
        return res;
    }

    public int lengthOfLongestSubstring3(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return max;
    }

    public int lengthOfLongestSubstring4(String s) {
        int left=0;
        int res=0;
        HashSet<Character> set = new HashSet<>();
        for(int r=0;r<s.length();r++){
            char c = s.charAt(r);
            if(!set.contains(c)){
                set.add(c);
            } else {
                while(set.contains(c)){
                    set.remove(s.charAt(left));
                    left++;
                }
                set.add(c);
            }
            res=Math.max(res, r-left+1);
        }

        return res;
    }
}
