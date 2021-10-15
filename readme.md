# Leetcode Notes

## Table of Contents

1. [Recursion Linked List](#recursion-Linked-List)
    - 206 Reverse Linked List
    - 92 Reverse Linked List II
    - 25 Reverse Nodes in k-Group
    - 19 Remove Nth Node From End of List
    - 234 Palindrome Linked List 
          
2. [Two pointers](#two-pointers)
    - [Left and right](#left-and-right)
        - 125 Valid Palindrome
        - 167 Two Sum II - Input array is sorted
        - 189 Rotate array
        - 567 Permutation in String
        - 704 Binary Search
    - [Slow and fast pointer](#slow-and-fast-pointer)
        - 26 Remove Duplicates from Sorted Array
        - 27 Remove Element
        - 83 Remove Duplicates from Sorted List
        - 141 Linked List Cycle
        - 142 Linked List Cycle II
        - 876 Middle of the Linked List 
           
    - [Sliding window](#sliding-window)
      - 340 Longest Substring with At Most K Distinct Characters 
      - 3 Longest Substring Without Repeating Characters
      - 76 Minimum Window Substring
      - 209 Minimum Size Subarray Sum
      - 424 The Longest Repeating Character Replacement 
         
3. [Prefix sum](#prefix-sum)
    - 560 Subarray Sum Equals K

4. [LinkedList](#linkedlist)
    - 2 Add Two Numbers

5. [Tree](#tree)
    - [BST](#bst)
        - 94 Binary Tree Inorder Traversal
        - 226 Invert Binary Tree
        - 114 Flatten Binary Tree to Linked List
        - 116 Populating Next Right Pointers in Each Node
        - 654 Maximum Binary Tree
        - 652 Find Duplicate Subtrees
         
    - [DFS](#dfs)
       - 252 Meeting Room	
       - 253 Meeting room

6. Subsets

---

## Recursion Linked List

### 206 Reverse Linked List
> Given the head of a singly linked list, reverse the list, and return the reversed list. 
```java
class Solution{
    //Iterative
    public ListNode reverseList(ListNode head) {
        if (head==null || head.next==null)
            return head;
        ListNode cur=head, pre=null;
        while(cur!=null){
            ListNode temp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=temp;
        }
        return pre;
    }

    //Recursion
    public ListNode reverseList(ListNode head) {
        if (head==null|| head.next==null)
            return head;
        ListNode last= reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return last;
    }
}
```
### 92 Reverse Linked List II
> Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from the position left to position right, and return the reversed list.

```java
class Solution{
    ListNode successor = null;

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left==1){
        return reverseN(head, right);
        }

        head.next=reverseBetween(head.next, left-1, right-1);
        return head;
    }



    public ListNode reverseN(ListNode head, int n) {

        if (n == 1) {
            successor = head.next;
            return head;
        }

        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }
}
```

### 25 Reverse Nodes in k-Group
>Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
You may not alter the values in the list's nodes, only nodes themselves may be changed.

<strong>Solution</strong>
- to reverse k group, for each group, it reverses from head to kth node b, returned to be the new head continuously reverse until k is smaller than the length


```java
class Solution{
    public ListNode reverseKGroup(ListNode head, int k) {

        if (head==null)
            return null;
        ListNode a,b;
        a=b=head;

        //loop the list until get kth node
        for(int i=0;i<k;i++){
            if(b==null) return head;
            b=b.next;
        }

        ListNode newHead = reverse(a, b);//reverse [a,b)
        a.next=reverseKGroup(b,k);//b is the new head for the next group
        return newHead;
    }

    public ListNode reverse(ListNode head, ListNode b) {
        if(head==null)
            return null;
        ListNode pre=null,curr,next;
        curr=next=head;
        while(curr!=b){
            next=curr.next;
            curr.next=pre;
            pre=curr;
            curr=next;
        }
        return pre;
    }
}   

```
### 19 Remove Nth Node From End of List
>Given the head of a linked list, remove the nth node from the end of the list and return its head.

```java
class Solution{
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head==null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        int length=0;

        //loop the list node to get the length
        ListNode current = head;
        while(current!=null){
            length++;
            current = current.next;
        }

        //get the index of the removed node
        length = length-n;
        current = dummy;

        //move to the position before the to be removed node
        while(length>0){
            current = current.next;
            length--;
        }

        current.next=current.next.next;
        return dummy.next;
    }
}
```

### 234 Palindrome Linked List
> Given the head of a singly linked list, return true if it is a palindrome.
 
```java
class Solution{
    public boolean isPalindrome(ListNode head) {
        //O(n)
        if(head==null || head.next==null) return true;
        ListNode slow=head,fast=head;

        //quickly attain the mid node
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        if(fast != null){
            slow = slow.next;
        }
        //get a reversed list
        slow=reverse(slow);//see 206
        fast=head;


        //check if two lists are the same
        while(slow!=null){
            if(slow.val!=fast.val)return false;
            slow=slow.next;
            fast=fast.next;
        }
        return true;
    }
}
```
     
---

## Two pointers

### left and right

### 125 Valid Palindrome
> Given a string s, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
```java
class Solution {
    public boolean isPalindrome(String s) {
        //use two pointer
        //one at the front, the other from the end
        //compare s.charAt(front) and s.charAt(end) until front > end
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            char left = s.charAt(l);
            char right = s.charAt(r);
            //skip if left or right is not digits or letter
            if (!Character.isLetter(left) && !Character.isDigit(left)) {
                l++;
                continue;
            }

            if (!Character.isLetter(right) && !Character.isDigit(right)) {
                r--;
                continue;
            }

            //compare letters
            if (Character.toLowerCase(left) != Character.toLowerCase(right)) {
                return false;
            } else {
                l++;
                r--;
            }
        }
        return true;
    }
}
```

### 167 Two Sum II - Input array is sorted
> Given an array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number.
<br> Return the indices of the two numbers (1-indexed) as an integer array answer of size 2, where 1 <= answer[0] < answer[1] <= numbers.length.
<br>The tests are generated such that there is exactly one solution. You may not use the same element twice.

Example 1:  
Input: numbers = [2,7,11,15], target = 9       
Output: [1,2]       
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2.
```java
class Solution{
     public int[] twoSum(int[] numbers, int target) {
         int left=0, right = numbers.length-1;
         while(left<right){
             int sum =numbers[left]+numbers[right];
             if(sum==target){
                 return new int[]{left+1, right+1};
             } else if(sum<target){
                 left++;
             } else if(sum>target){
                 right--;
             }
         }
         return new int[]{-1, -1};
    }
}
```

### 189 Rotate Array
>Given an array, rotate the array to the right by k steps, where k is non-negative.

Example 1:  
Input: nums = [1,2,3,4,5,6,7], k = 3  
Output: [5,6,7,1,2,3,4]  
Explanation:
1. rotate 1 steps to the right: [7,1,2,3,4,5,6]
2. rotate 2 steps to the right: [6,7,1,2,3,4,5]
3. rotate 3 steps to the right: [5,6,7,1,2,3,4]

```java
class Solution{
    public void rotate(int[] nums, int k) {
        //approach 1 O(n^2)
        //loop k times to rotate
        //for each loop, switch numbers
        k=k%nums.length;//when k=8, it is the same as rotating once
        int temp, pre;
        for(int i=0;i<k;i++){
            pre=nums[nums.length-1];
            for(int j=0;j<nums.length;j++){
                temp=nums[j];
                nums[j]=pre;
                pre=temp;
            }
        }

        //approach 2 O(n)
        //create a new array and store elements in the right order
        //copy the array to nums
        int [] arr = new int[nums.length];
        for (int i=0;i<nums.length;i++){
            arr[(i+k)%nums.length]=nums[i];
        }
        for( int i=0;i<nums.length;i++){
            nums[i]=arr[i];
        }
    }
    //approach 3 space O(1)
    public void rotate(int[] nums, int k) {

        if(nums == null || nums.length < 2){
            return;
        }

        k = k % nums.length;
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);

    }
    private void reverse(int[] nums, int i, int j){
        int tmp;
        while(i < j){
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }
}
```

Explanation:  
The basic idea is that, for example, nums = [1,2,3,4,5,6,7] and k = 3, first we reverse [1,2,3,4], it becomes[4,3,2,1];  
then we reverse[5,6,7], it becomes[7,6,5],   
finally we reverse the array as a whole, it becomes[4,3,2,1,7,6,5] ---> [5,6,7,1,2,3,4].  
Reverse is done by using two pointers, one point at the head, and the other point at the tail, after switching these two, these two pointers move one position towards the middle.

### 567 Permutation in String
> Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise. In other words, return true if one of s1's permutations is the substring of s2.

Example 1:  
Input: s1 = "ab", s2 = "eidbaooo"  
Output: true  
Explanation: s2 contains one permutation of s1 ("ba").

#### Approach 1: using array
```java
class Solution{
    public boolean checkInclusion(String s1, String s2) {
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
        while(left+s1.length()<=s2.length()){//be aware of the boundary
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

    public boolean matches(int [] s1map, int []s2map){
        for(int i=0;i<s1map.length;i++){
            if(s1map[i]!=s2map[i]){
                return false;
            }
        }
        return true;
    }
}
```

#### Approach 2: sliding window
```java
class Solution{
    public boolean checkInclusion(String s1, String s2) {
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

    public boolean matches(int [] s1map, int []s2map){
        for(int i=0;i<s1map.length;i++){
            if(s1map[i]!=s2map[i]){
                return false;
            }
        }
        return true;
    }
}
```

### 704 Binary Search
> Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1. You must write an algorithm with O(log n) runtime complexity.

Input: nums = [-1,0,3,5,9,12], target = 9

Output: 4

Explanation: 9 exists in nums and its index is 4

```java
class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            mid = left + (right - left) / 2; // avoid overflow as it can be greater than int max value (231 - 1)
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
```

---

## Slow and fast pointer

### 26 Remove Duplicates from Sorted Array
    
Example 1:  
Input: nums = [1,1,2]  
Output: 2, nums = [1,2,_]  
Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.  
It does not matter what you leave beyond the returned k (hence they are underscores).  
Loop the array, use two pointer
- If nums[left]==nums[right], skip it
- If nums[left]!=nums[right], nums[left]=nums[right], left++, right++
  
```java
class Solution{
    public int removeDuplicates(int[] nums) {
        if(nums.length<=1) return nums.length;
        int pointer=0;
        for(int r=1;r<nums.length;r++){
            if(nums[pointer]!=nums[r]){
                nums[++pointer]=nums[r];
            }
        }
        return pointer+1;
    }
}
```
### 27 Remove Element
> Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The relative order of the elements may be changed.
<br>Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
<br>Return k after placing the final result in the first k slots of nums.
<br>Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
    
Example 1:  
Input: nums = [3,2,2,3], val = 3  
Output: 2, nums = [2,2,_,_]  
Explanation: Your function should return k = 2, with the first two elements of nums being 2.It does not matter what you leave beyond the returned k (hence they are underscores).

```java
class Solution{
    public int removeElement(int[] nums, int val) {
        //loop the array
        //when the fast find the duplicates, skip it
        //fast++
        //otherwise, replace slow with the fast value, slow++ and fast++
        //return slow
        int slow = 0;
        for(int fast=0;fast<nums.length;fast++){
            if(nums[fast]!=val){
                nums[slow]=nums[fast];
                slow++;
            }
        }
        return slow;
    }
}
```

### 83 Remove Duplicates from Sorted List
> Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
```java
class Solution{
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode cur=head, fast=head.next;
        //loop the list
        while(fast!=null){
            if(cur.val!=fast.val){
                cur.next=fast;
                cur=cur.next;
            }
            fast=fast.next;
        }
        cur.next=null;
        return head;
    }
}
```

### 141. Linked List Cycle
> Given head, the head of a linked list, determines if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.   
Internally, pos is used to denote the index of the node that tail's next pointer is connected to.  
Note that pos is not passed as a parameter.  
Return true if there is a cycle in the linked list. Otherwise, return false.
```java
class Solution{
     public boolean hasCycle(ListNode head) {
         if(head==null || head.next==null) 
             return false;
         ListNode fast = slow = head;
         while(fast!=null && fast.next!=null){
             slow=slow.next;
             fast=fast.next.next;
             if(fast=slow) return true;
         }
         return false;
     }
}
```

### 142. Linked List Cycle II
> Given a linked list, return the node where the cycle begins. If there is no cycle, return null. <br>There is a cycle in a linked list if some nodes in the list can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. 
<br> Note that pos is not passed as a parameter.
<br>Notice that you should not modify the linked list.
```java
class Solution{
    public ListNode detectCycle(ListNode head) {
        if(head==null) 
            return head;
        ListNode slow=fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        if(fast==slow) 
            break;
        }
        //no cycle
        if(fast==null) 
            return fast;
        slow=head;
        while(slow!=fast){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }
}
```

### 876. Middle of the Linked List
> Given the head of a singly linked list, return the middle node of the linked list.      If there are two middle nodes, return the second middle node.

Example 1:  
Input: head = [1,2,3,4,5]  
Output: [3,4,5]  
Explanation: The middle node of the list is node 3.
```java
class Solution{
     public ListNode middleNode(ListNode head) {
     ListNode slow=head,fast=head;
     while(fast!=null && fast.next!=null){
     slow=slow.next;
     fast=fast.next.next;
     }
     return slow;
     }
}
```

### 19. Remove Nth Node From End of List
> Given the head of a linked list, remove the nth node from the end of the list and return its head.

Example 1:  
Input: head = [1,2,3,4,5], n = 2  
Output: [1,2,3,5]

```java
class Solution{    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head, slow = head;
        for (int i = 0; i < n; i++) { // 快指针先前进 n 步
            fast = fast.next;
        }
        if (fast == null) // 如果此时快指针走到头了，说明倒数第 n 个节点就是第一个节点
            return head.next;
        while (fast.next != null) {// 让慢指针和快指针同步向前
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;// slow.next 就是倒数第 n 个节点，删除它
        return head;
    }
}
```

## Sliding window

### 340 Longest Substring with At Most K Distinct Characters
> Given a string find the length of the longest substring T that contains at most k distinct characters

Example:  
Input: s= eceba k=2  
Output: T=ece , length is 3  
Leetcode 159 is similiar

```java
class Solution{
    public int lengthOfLongestSubstringKDistinct(String s, int k){
        HashMap<Character, Integer> map= new HashMap<>();
        int left=0, res=0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
            //maintain the sliding window
            while(map.size()>k){
                char leftChar = s.charAt(left);
                map.put(c, map.get(c)-1);
                if(map.get(c)==0){
                    map.remove(c);
                }
                left++;
            }
            res=Math.max(res, i-left+1);
        }
        rturn res;
    }
}
```

### 3 Longest Substring Without Repeating Characters
> Given a string s, find the length of the longest substring without repeating characters. 
 
Example 1:  
Input: s = "abcabcbb"  
Output: 3  
Explanation: The answer is "abc", with the length of 3.
```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0, res = 0;
        //loop the string, left starts from 0
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //if set has the character, remove this char from the set and move left pointer
            //repeat this until set can add this character
            //otherwise, add this element into the set
            while (!set.add(c)) {
                set.remove(s.charAt(left));
                left++;
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }

    //approach 2
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();

        while (j < s.length()) {
            // if(set.add(s.charAt(j))){
            //     res=Math.max(res, j-i+1);
            //     j++;
            // }
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return max;
    }

    //explanation
    public int lengthOfLongestSubstring(String s) {
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
```

### 76 Minimum Window Substring
> Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "". A substring is a contiguous sequence of characters within the string.

Example 1:  
Input: s = "ADOBECODEBANC", t = "ABC"  
Output: "BANC"

```java
class Solution{
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        // Dictionary which keeps a count of all the unique characters in t.
        Map<Character, Integer> dictT = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            int count = dictT.getOrDefault(t.charAt(i), 0);
            dictT.put(t.charAt(i), count + 1);
        }

        // Number of unique characters in t, which need to be present in the desired window.
        int required = dictT.size();

        int l = 0, r = 0; // Left and Right pointer

        // formed is used to keep track of how many unique characters in t
        // are present in the current window in its desired frequency.
        // e.g. if t is "AABC" then the window must have two A's, one B and one C.
        // Thus formed would be = 3 when all these conditions are met.
        int formed = 0;

        // Dictionary which keeps a count of all the unique characters in the current window.
        Map<Character, Integer> windowCounts = new HashMap<Character, Integer>();

        // ans list of the form (window length, left, right)
        Int [ ] ans = {-1, 0, 0};

        while (r < s.length()) {
            // Add one character from the right to the window
            char c = s.charAt(r);
            int count = windowCounts.getOrDefault(c, 0);
            windowCounts.put(c, count + 1);

            // If the frequency of the current character added equals to the
            // desired count in t then increment the formed count by 1.
            if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
                formed++;
            }

            // Try and contract the window till the point where it ceases to be 'desirable'.
            while (l <= r && formed == required) {
                c = s.charAt(l);
                // Save the smallest window until now.
                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }
                // The character at the position pointed by the
                // `Left` pointer is no longer a part of the window.
                windowCounts.put(c, windowCounts.get(c) - 1);
                if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
                    formed--;
                }
                // Move the left pointer ahead, this would help to look for a new window.
                l++;
            }
            // Keep expanding the window once we are done contracting.
            r++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}
```

Explanation:  
1. Store chars of t into a hashmap  
2. Create a hashmap to track the sliding window which stores characters in the window  
3. Use formed to record if the window contains all characters of string t  
4. Use an array to store window size(i-l+1) and start and end index of the window  
5. Loop the string s while(r<s.length)  
6. Put every char into the window  
7. Update formed when windowMap.get(char).intValue()==tMap.get(char).intValue() && tMap.containsKey(char)  
8. While the window contains all chars of t, moving left pointer until the window no longer contains all
9. While(l<=r && formed == tMap.size()), update the left and the res array, remove s.charAt(left) from the window map  
10. Check formed: whether the window map contains all chars of string t  

### 209 Minimum Size Subarray Sum
> Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.

Example 1:  
Input: target = 7, nums = [2,3,1,2,4,3]  
Output: 2  
Explanation: 
- The subarray [4,3] has the minimal length under the problem constraint. 
- Loop the array using two pointer
- Move right pointer and calculate sum
- When sum>target, record res(size) and move left until sum<target, (decrease sum meanwhile)
- Continue above procedure until right reach the end of nums

```java
class Solution{
    public int minSubArrayLen(int target, int[] nums) {
        if(nums.length==0||nums==null) return 0;
        int left=0,right=0, sum=0, res=Integer.MAX_VALUE;
        while(right<nums.length){
            sum+=nums[right];
            while(sum>=target){
                res=Math.min(res, right-left+1);
                sum-=nums[left++];
            }
            right++;
        }
        return res==Integer.MAX_VALUE ? 0 : res;
    }
}
```

### 424 The Longest Repeating Character Replacement
> You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
<br>Return the length of the longest substring containing the same letter you can get after performing the above operations.

Example 1:  
Input: s = "ABAB", k = 2  
Output: 4  
Explanation: Replace the two 'A's with two 'B's or vice versa.
```java
class Solution{
     public int characterReplacement(String s, int k) {
     //use int [26] to store characters
     int [] count = new int[26];
     int left=0,res=0;
     for(int i=0;i<s.length();i++){
        count[s.charAt(i)-'A']++;
     while(i-left+1-getMax(count)>k){
         //shrink window from left
         count[s.charAt(left)-'A']--;
         left++;
         }
         res=Math.max(res, i-left+1);
         }
         return res;
     }

    public int getMax(int [] arr){
        int max=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        return max;
    }
}
```

---

## Prefix sum

### 560 Subarray Sum Equals K
> Given an array of integers nums and an integer k, return the total number of continuous subarray whose sum equals to k.

Example 1:  
Input: nums = [1,1,1], k = 2  
Output: 2
Explanation
- Use an array to store prefix sum, so the sum of the subarray is sum[j]-sum[i]
- Use two for loop to check if sum[j]-sum[i]==k

```java
class Solution{
    public int subarraySum(int[] nums, int k) {
        int count=0;
        if(nums.length==0) return count;
        int [] sum = new int [nums.length+1];
        sum[0]=0;
        for(int i=0; i<nums.length;i++){
            sum[i+1]=nums[i]+sums[i];
        }
        for(int i=0;i<nums.length;i++){
            for(int j=1;j<i;j++){
                if(sum[j]-sum[i]==k){
                    count++;
                }
            }
        }
        return count;
    }

    //Improve using hash map
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0,1);
        int count=0, sumi=0;
        for(int i=0;i<nums.length;i++){
            sumi+=nums[i];
            int sumj=sumi-k;
            if (preSum.containsKey(sumj)){
                count += preSum.get(sumj);
            }

            preSum.put(sumi,preSum.getOrDefault(sumi, 0) + 1);
        }
        return count;
    }
}
```

## LinkedList

### 2 Add Two Numbers
> You are given two non-empty linked lists representing two non-negative integers. 
<br>The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.
```java
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;

        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
```

---

## Tree
Traversals:  
- Preorder : root->left->right   
- Inorder : left->root->right  
- Postorder : left -> right -> root

### BST
```java
class BinaryTree{
    public BinaryTree <T> search(T key){
        BinaryTree <T> t = tree;
        boolean found = false;
        while(t!=null && !found){
            int c=key.compareTo(t.getData());
            if(c<0) t=t.left;
            if(c>0) t=t.right;
            if(c==0) found = true;
        }
        if(found)
            return t;
        else
            return null;
    }
}
```

### 94 Binary Tree Inorder Traversal
Example:  
Input: root = [1,null,2,3]  
Output: [1,3,2]

```java
class BTS{
    //Recursive:
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    public List<Integer> helper(TreeNode root, ArrayList list){
        if(root==null) return;
        helper(root.left, list);
        list.add(root.val);
        helper(root.right, list);
    }

    //Iterative
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if(root==null){
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            list.add(root.val);
            root=root.right;
        }
        return list;
    }
}
```

### 226 Invert Binary Tree
> Given the root of a binary tree, invert the tree, and return its root.

Example 1:
Input: root = [4,2,7,1,3,6,9]  
Output: [4,7,2,9,6,3,1]  
```java
class Solution{
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
```

### 114 Flatten Binary Tree to Linked List
> Given the root of a binary tree, flatten the tree into a "linked list":
<br>The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list, and the left child pointer is always null.
<br>The "linked list" should be in the same order as a pre-order traversal of the binary tree.

Example 1:  
Input: root = [1,2,5,3,4,null,6]  
Output: [1,null,2,null,3,null,4,null,5,null,6]  

```java
class Solution{
    public void flatten(TreeNode root) {
        TreeNode curr = root;

        while(curr != null){
            if(curr.left == null){
                curr = curr.right;
            }else{
                // save the right node
                TreeNode right = curr.right;

                // copy the left node to the right
                curr.right = curr.left;
                // delete left node
                curr.left = null;

                // save the curr node for recursion
                TreeNode lastCurr = curr;

                // find out the last right node
                while(curr.right != null)
                    curr = curr.right;

                // connect to the first right node
                curr.right = right;

                // move on to the next node
                curr = lastCurr.right;
            }
        }
    }
}
```

### 116 Populating Next Right Pointers in Each Node
> You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
     
```text
struct Node {
     int val;
     Node *left;
     Node *right;
     Node *next;
}
```
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
Initially, all next pointers are set to NULL.

Example 1:  
Input: root = [1,2,3,4,5,6,7]  
Output: [1,#,2,3,#,4,5,6,7,#]  
Explanation:   
Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.

### 654 Maximum Binary Tree
```text
You are given an integer array nums with no duplicates. A maximum binary tree can be built recursively from nums using the following algorithm:
1. Create a root node whose value is the maximum value in nums.
2. Recursively build the left subtree on the subarray prefix to the left of the maximum value.
3. Recursively build the right subtree on the subarray suffix to the right of the maximum value.
4. Return the maximum binary tree built from nums.
```

Example 1:  
Input: nums = [3,2,1,6,0,5]  
Output: [6,3,5,null,2,0,null,null,1]  
Explanation:  
The recursive calls are as follows:  
- The largest value in [3,2,1,6,0,5] is 6. Left prefix is [3,2,1] and right suffix is [0,5].
    - The largest value in [3,2,1] is 3. Left prefix is [] and right suffix is [2,1].
        - Empty array, so no child.
        - The largest value in [2,1] is 2. Left prefix is [] and right suffix is [1].
            - Empty array, so no child.
            - Only one element, so child is a node with value 1.
    - The largest value in [0,5] is 5. Left prefix is [0] and right suffix is [].
        - Only one element, so child is a node with value 0.
        - Empty array, so no child.
          public TreeNode constructMaximumBinaryTree(int[] nums) {
          return build(nums, 0, `nums.length` - 1);
          }
```java
class Solution{
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    TreeNode build(int[] nums, int lo, int hi) {
        // base case
        if (lo > hi) {
            return null;
        }
        int index = -1, maxVal = Integer.MIN_VALUE;
        for (int i = lo; i <= hi; i++) {
            if (maxVal < nums[i]) {
                index = i;
                maxVal = nums[i];
            }
        }

        TreeNode root = new TreeNode(maxVal);

        root.left = build(nums, lo, index - 1);
        root.right = build(nums, index + 1, hi);

        return root;
    }
}
```

### 652 Find Duplicate Subtrees
> Given the root of a binary tree, return all duplicate subtrees. <br>For each kind of duplicate subtrees, you only need to return the root node of any one of them.
<br>Two trees are duplicate if they have the same structure with the same node values.

Example 1:  
Input: root = [1,2,3,4,null,2,4,null,null,4]  
Output: [[2,4],[4]]  
Explanation:  
1. traverse the tree
2. store left-right-root data as string in HashMap, store node in LinkedList
3. the LinkedList is the result

---

## DFS

### 252 Meeting Room
> Given an array of meeting time intervals, consisting of start and end time, determine if a person could attend all meetings.

Example 1:  
Input [[0,30],[5,10],[15,20]]  
output false
```java
class Solution{
    public boolean canAttendMeeting(Interval[] intervals){
        Arrays.sort(intervals, (a,b)->a.start-b.start);
        for(int i=0;i<intervals.length-1;i++){
            if(intervals[i].end>intervals[i+1].start){
                return false;
            }
        }
        return true;
    }
}
```

### 253 Meeting room II
> Given an array of meeting time intervals, consisting of start and end time, find the minimum number of conference rooms required.

Example 1:  
Input [[0,30],[5,10],[15,20]]  
output: 2
```java
class Solution{
    public int miniMeetingRooms(int[][] intervals){
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b)->a[1]-b[1]);
        if(intervals.length !=0){
            heap.offer(intervals[0]);
        }
        for(int i=0;i<intervals.length;i++){
            int [] cur = heap.poll();
            if(cur[1] <= intervals[i][0]){
                cur[1]=intervals[i][1];
            }else {
                heap.offer(intervals[i]);
            }
            heap.offer(cur);
        }
        return heap.size();
    }
}
```
### 78. Subsets
> Given an integer array nums of unique elements, return all possible subsets (the power set). <br>The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:  
Input: nums = [1,2,3]  
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
```java
class Solution{
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> res,
                           List<Integer> temp,
                           int [ ] nums, int start)
    {
        res.add(new ArrayList<>(temp));
        for(int i=start;i<nums.length();i++){
            temp.add(nums[i]);
            backtrack(res, temp, nums, i+1);
            temp.remove(temp.size()-1);
        }
    }
    
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList();
        output.add(new ArrayList<Integer>());//output: [[]]

        for (int num : nums) {//loop [1,2,3]
            List<List<Integer>> newSubsets = new ArrayList();
            for (List<Integer> curr : output) {
                List<Integer> list = new ArrayList<Integer>(curr);
                list.add(num);
                newSubsets.add(list);
            }
            for (List<Integer> curr : newSubsets) {
                output.add(curr);
            }
        }
        return output;
    }
    
    
    public List<List<Integer>> subsets(int[ ] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for(int n : nums){
            int size = result.size();
            for(int i=0; i<size; i++){
                List<Integer> subset = new ArrayList<>(result.get(i));
                subset.add(n);
                result.add(subset);
            }
        }
        return result;
    }
}
```
Dynamic programming Explanation:  
While iterating through all numbers, for each new number, we can either pick it or not pick it  
1, if picked, just add the current number to every existing subset.  
2, if not pick, just leave all existing subsets as they are.  
We just combine both into our result.  

For example, {1,2,3} initially we have an empty set as result [ [ ] ]  
Consider 1, if not use it, still [ ], if use 1, add it to [ ], so we have [1] now.  
Combine them, now we have [ [ ], [1] ] as all possible subset  
Next considering 2, if not use it, we still have [ [ ], [1] ], if use 2, just add 2 to each previous subset, we have [2], [1,2]  
Combine them, now we have [ [ ], [1], [2], [1,2] ]  
Next considering 3, if not use it, we still have [ [ ], [1], [2], [1,2] ], if use 3, just add 3 to each previous subset, we have [ [3], [1,3], [2,3], [1,2,3] ]  
Combine them, now we have [ [ ], [1], [2], [1,2], [3], [1,3], [2,3], [1,2,3] ]  

### 90 Subsets II
> Given an integer array nums that may contain duplicates, return all possible subsets (the power set). The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:  
Input: nums = [1,2,2]  
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]


