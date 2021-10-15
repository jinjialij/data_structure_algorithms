package LeetCode.Medium;

public class permutationInString {
    public static void main(String []args){
        String s1 = "ab", s2 = "eidbaooo";
        boolean res = checkInclusion2(s1,s2);
        System.out.println(res);

    }
    public static boolean checkInclusion1(String s1, String s2) {
        //loop s1 to store it in 26 character array
        //using sliding window, check the frequency of characters
        //if s1 matches s2 return true, otherwise false
        if(s1.length()>s2.length())
            return false;
        int [] s1map = new int [26];
        for(int i=0;i<s1.length();i++){
            s1map[s1.charAt(i)-'a']++;
        }

        int left=0;
        while(left+s1.length()<=s2.length()){
            int [] s2map = new int [26];

            for(int j=left;j<s1.length()+left;j++){
                s2map[s2.charAt(j)-'a']++;
            }

            //check if s1map matches s2map
            if(matches(s1map,s2map)){
                return true;
            } else{
                left++;
            }
        }

        return false;
    }

    public static boolean checkInclusion2(String s1, String s2) {
        //approach 2: using sliding window
        if(s1.length()>s2.length())
            return false;
        int [] s1map=new int[26];
        int [] s2map=new int [26];
        for(int i=0;i<s1.length();i++){
            s1map[s1.charAt(i)-'a']++;
            s2map[s2.charAt(i)-'a']++;
        }
        if(matches(s1map,s2map))
            return true;

        //maintain window
        int left=0,right= s1.length();
        while(right<s2.length()){
            s2map[s2.charAt(right++)-'a']++;//add the character of the right pointer into the array and move one step right
            s2map[s2.charAt(left++)-'a']--;//remove the character of the left pointer from the array and move one step right
            if(matches(s1map,s2map))
                return true;
        }
        return false;
    }

    public static boolean matches(int [] s1map, int []s2map){
        for(int i=0;i<s1map.length;i++){
            if(s1map[i]!=s2map[i]){
                return false;
            }
        }
        return true;
    }
}
