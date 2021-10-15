//public BinaryTree <T> search(T key){
//    BinaryTree <T> t = tree;
//    boolean found = false;
//    while(t!=null && !found){
//        int c=key.compareTo(t.getData());
//        if(c<0) t=t.left;
//        if(c>0) t=t.right;
//        if(c==0) found = true;
//    }
//    if(found)
//        return t;
//    else
//        return null;
//}
//
//
//public List<String> fizzBuzz(int n) {
//    List<String> list = new ArrayList<String>();
//        for(int i=1;i<=n;i++){
//            boolean divisibleBy3 = (i % 3 == 0);
//            boolean divisibleBy5 = (i % 5 == 0);
//            if(divisibleBy3 && divisibleBy5){//need to be checked in the first place
//                list.add("FizzBuzz");
//            }else if(divisibleBy3){
//                list.add("Fizz");
//            } else if(divisibleBy5){
//                list.add("Buzz");
//            } else{
//                list.add(Integer.toString(i));
//            }
//        }
//        return list;
//}
//
//public boolean canAttendMeeting(Interval[] intervals){
//    Arrays.sort(intervals, (a,b)->a.start-b.start);
//    for(int i=0;i<intervals.length-1;i++){
//        if(intervals[i].end>intervals[i+1].start){
//            return false;
//        }
//    }
//    return true;
//}
//
//public int miniMeetingRooms(int[][] intervals){
//    Arrays.sort(intervals, (a,b)->a[0]-b[0]);
//    PriorityQueue<int[]> heap = new PriorityQueue<>((a,b)->a[1]-b[1]);
//    if(intervals.length !=0){
//        heap.offer(intervals[0]);
//    }
//    doe(int i=0;i<intervals.length;i++){
//        int [] cur = heap.poll();
//        if(cur[1] <= intervals[i][0]){
//            cur[1]=intervals[i][1];
//        }else {
//            heap.offer(intervals[i]);
//        }
//        heap.offer(cur);
//    }
//    return heap.size();
//}
//
//public List<Integer> inorderTraversal(TreeNode root) {
//    ArrayList<Integer> list = new ArrayList<>();
//    helper(root, list);
//    return list;
//}
//
//public List<Integer> helper(TreeNode root, ArrayList list){
//    if(root==null) return;
//    helper(root.left, list);
//    list.add(root.val);
//    helper(root.right, list);
//}
//
//public List<Integer> inorderTraversal(TreeNode root) {
//    ArrayList<Integer> list = new ArrayList<>();
//    if(root==null){
//        return list;
//    }
//    Stack<TreeNode> stack = new Stack<>();
//    while(root!=null || !stack.isEmpty()){
//        while(root!=null){
//                stack.push(root);
//                root=root.left;
//        }
//        root=stack.pop();
//        list.add(root.val);
//        root=root.right;
//    }
//    return list;
//}
//
//public List<List<Integer>> subsets(int[] nums) {
//    List<List<Integer>> list = new ArrayList<>();
//    backtrack(list, new ArrayList<>(), nums, 0);
//    return list;
//}
//
//private void backtrack(List<List<Integer>> res, List<Integer> temp, int [] nums, int start){
//    res.add(new ArrayList<>(temp));
//    for(int i=start;i<nums.length;i++){
//        temp.add(nums[i]);
//        backtrack(res, temp, nums, i+1);
//        temp.remove(temp.size()-1);
//    }
//}
//
//public List<List<Integer>> subsets(int[] nums) {
//    int totalNumber =1 << nums.length;
//    List<List<Integer>> res = new ArrayList<>();
//    for(int mask =0; mask<totalNumber;mask++){
//        List<Integer> set = new ArrayList<>();
//        for(int j=0;j<nums.length;j++){
//            if((mask&(1>>j))!=0){
//                set.add(nums[j]);
//            }
//            res.add(set);
//        }
//        return res;
//    }
//}