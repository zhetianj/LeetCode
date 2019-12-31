package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
	 public static String longestCommonPrefix(String[] strs) {
		 if(strs.length == 0) return "";
		 String prefix = strs[0];
		 for(int i = 1; i < strs.length; i++) {
			 while(strs[i].indexOf(prefix) != 0) {
				 prefix = prefix.substring(0, prefix.length() - 1);
				 if(prefix.isEmpty()) return "";
			 }
		 }
		 return prefix;
		 
		}

	 public static String multiply(String num1, String num2) {
		 return Long.toString(Long.parseLong(num1)*Long.parseLong(num2));
	 }
	 
	 //Leetcode 41. First Missing Positive; Hard
	 //Runtime: 3 ms, faster than 6.99%; Memory Usage: 34.7 MB, less than 100.00%
	 public static int firstMissingPositive(int[] nums) {
		 List<Integer> ll = new ArrayList();
		 for(int num: nums) {
			 ll.add(num);
		 }
	     Collections.sort(ll);
	     if(!ll.contains(1)) return 1;
	     int last = 2;
	     for(int i: ll) {
	    	 if(!ll.contains(last)) return last;
	    	 last++;
	     }
	     return 0;
	 }
	 

	 //29. Divide Two Integers; Medium
	 //need to optimize due to time limit; test case : divide(2147483647,3)
	 public static int divide(int dividend, int divisor) {

		 if(dividend == Integer.MAX_VALUE && divisor == 1) {
			 return Integer.MAX_VALUE;
		 }
		 else if(dividend == Integer.MAX_VALUE && divisor == -1) {
			 return -Integer.MAX_VALUE;
		 }
		 else if(dividend == Integer.MIN_VALUE && divisor == 1) {
			 return Integer.MIN_VALUE;
		 }
		 else if(dividend == Integer.MIN_VALUE && divisor == -1) {
			 return Integer.MAX_VALUE;
		 }
	        int division = 0;
	        boolean flag = (divisor > 0 && dividend > 0) || (divisor < 0 && dividend < 0);
	        int divCopy = dividend;
	        while((divCopy > 0 && dividend > 0) || (divCopy < 0 && dividend < 0)){
	        	if(division == Integer.MAX_VALUE) {
	        		return Integer.MAX_VALUE;
	        	}
	        	else if(division == Integer.MIN_VALUE) {
	        		return Integer.MIN_VALUE;
	        	}
	        	//System.out.printf("divisor: %d, dividend: %d, division: %d%n", divisor, dividend, division);
        		if((Math.abs(divisor)>Math.abs(dividend)) && dividend != Integer.MIN_VALUE) return division;
	        	if(!flag) {
	        		division--;
	        		dividend += divisor;
	        	}
	        	else {
	        		division++;
	        		dividend -= divisor;
	        	}
	            
	        }
	        return division;
	    }
	   
	 //Runtime: 1 ms, faster than 93.90% of Java online submissions for Trapping Rain Water.
	 //Memory Usage: 37.6 MB, less than 97.95% of Java online submissions for Trapping Rain Water.
	 //42. Trapping Rain Water; Hard
	 public static int trap(int[] height) {

		    int len = height.length;
		    int waterCollectedSoFar =0;

		    int i = 0;
		    int j = len - 1;
		    if(len<=1){
		      return waterCollectedSoFar;
		    }
		    while (height[i] == 0) {
		      i++;
		    }
		    while (height[j] == 0) {
		      j--;
		    }
		    int leftMax = height[i];
		    int rightMax = height[j];

		    int maxHeightFoundSoFar = Math.min(rightMax, leftMax);
		    if(j-1<=i){
		      return waterCollectedSoFar;
		    }
		    waterCollectedSoFar = maxHeightFoundSoFar * (j - i - 1);

		    while (i < j - 1) {
		      int newHeightFound;
		      if (height[i] <= height[j]) {
		        i++;
		        newHeightFound = height[i];
		      } else {
		        j--;
		        newHeightFound = height[j];
		      }
		      if (newHeightFound <= maxHeightFoundSoFar) {
		        waterCollectedSoFar -= newHeightFound;
		      } else {
		        waterCollectedSoFar -= maxHeightFoundSoFar;
		        waterCollectedSoFar += (Math.min(height[i], height[j]) - maxHeightFoundSoFar) * (j - i - 1);
		        maxHeightFoundSoFar = Math.min(height[i], height[j]);
		      }
		    }

		    return waterCollectedSoFar;
		  }
	 
	  //public static boolean isMatch(String s, String p) {
	        
	  
	  //}
	 //Given an array nums of n integers, are there elements a, b, c in nums 
	 //such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
	 //Runtime: 75 ms, faster than 32.39% of Java online submissions for 3Sum.
	 //Memory Usage: 46.9 MB, less than 90.81% of Java online submissions for 3Sum.
	 public static List<List<Integer>> threeSum(int[] nums) {
	        List<List<Integer>> solution = new ArrayList<>();
            Map<Integer, List<Integer>> check = new HashMap();
	        Arrays.sort(nums);
	        for(int i = 0; i < nums.length; i++){
	            if(nums[i] > 0) break;
	            if(!check.containsKey(nums[i])) check.put(nums[i], new ArrayList());
	            int j = i+1;
	            int k = nums.length-1;
	            while(j < k) {
	            	if(nums[i]+nums[j]+nums[k]>0) {
	            		k--;
	            	}
	            	else if(nums[i]+nums[j]+nums[k]<0) {
	            		j++;
	            	}
	            	//get 0
	            	else{
	            		if(!check.get(nums[i]).contains(nums[j])) {
		            		List<Integer> sol = new ArrayList();
		            		sol.add(nums[i]);
		            		sol.add(nums[j]);
		            		sol.add(nums[k]);
			            	solution.add(sol);
			            	check.get(nums[i]).add(nums[j]);
	            		}
	            		j++;
	            	}
	            }
	        }
	        return solution;
	 }
	 
	 //	19	Remove Nth Node From End of List    
	 //Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Nth Node From End of List.
	 //Memory Usage: 35 MB, less than 100.00% of Java online submissions for Remove Nth Node From End of List.
	 public ListNode removeNthFromEnd(ListNode head, int n) {
	        ListNode newHead = new ListNode(0);
	        newHead.next = head;
			ListNode fore = newHead;
			ListNode late = newHead;
			 
			 while(n > 0) {
				 fore = fore.next;
				 n--;
			 }
			 
			 while(fore.next != null) {
				 fore = fore.next;
				 late = late.next;
			 }
			 
			 late.next = late.next.next;
			 
			 return newHead.next;
	 }
	 
	public static int dominantIndex(int[] nums) {
		  if(nums.length == 0) return -1;
	      if(nums.length == 1) return 0;
	      int largest = Integer.MIN_VALUE;
	      int second = Integer.MIN_VALUE;
	      int index = 0;
	      for(int i = 0; i < nums.length; i++){
	            if(nums[i] > largest) {
	            	second = largest;
	            	largest = nums[i];
	            	index = i;
	            }
	            else if(nums[i] > second) {
	            	second = nums[i];
	            }
	      }
	      System.out.println(largest);
	      System.out.println(second);
	      return (largest>=2*second)?index:-1;
	 }
	 public class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) { val = x; }
	 }
	 
	 //	20	Valid Parentheses   
	 //Runtime: 1 ms, faster than 98.74% of Java online submissions for Valid Parentheses.
	 //Memory Usage: 34.3 MB, less than 100.00% of Java online submissions for Valid Parentheses.
	 public static boolean isValid(String s) {
	        Deque<Character> stack = new ArrayDeque<Character>();
	        try {
		        for(int i = 0; i < s.length(); i++) {
		        	if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
		        		stack.addFirst(s.charAt(i));
		        	}
		        	else if (s.charAt(i) == ')') {
		        		if(stack.removeFirst() != '(') {
		        			return false;
		        		}
		        	}
		        	else if (s.charAt(i) == ']') {
		        		if(stack.removeFirst() != '[') {
		        			return false;
		        			}
		        	}
		        	else if (s.charAt(i) == '}') {
		        		if(stack.removeFirst() != '{') {
		        			return false;
		        			}
		        	}
		        }
	        }
	        catch(Exception e) {
	        	return false;
	        }

	        return stack.isEmpty()?true:false;
	 }
	 
	 //Runtime: 1 ms, faster than 20.79% of Java online submissions for Merge Two Sorted Lists.
	 //Memory Usage: 38.9 MB, less than 19.53% of Java online submissions for Merge Two Sorted Lists
	 public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	 /*       ListNode newList = new ListNode(0);
	        ListNode cur = newList;
	        while(l1 != null && l2 != null){
	            if(l1.val >= l2.val){
	                cur.next = new ListNode(l2.val);
	                l2 = l2.next;
	            }
	            else{
	                cur.next = new ListNode(l1.val);
	                l1 = l1.next;
	            }
	            cur = cur.next;
	        }
	        if(l1 != null){
	            cur.next = l1;
	        }
	        else if(l2 != null){
	            cur.next = l2;
	        }
	        return newList.next;
	 */
		 //recursive
		 //Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Two Sorted Lists.
		 //Memory Usage: 40.8 MB, less than 10.10% of Java online submissions for Merge Two Sorted Lists.
	        if(l1 == null) return l2;
	        if(l2 == null) return l1;
	        if(l1.val <= l2.val){
	            l1.next = mergeTwoLists(l1.next, l2);
	            return l1;
	        }
	        else{
	            l2.next = mergeTwoLists(l1, l2.next);
	            return l2;
	        }
	 }
	 
	 //22. Generate Parentheses
	 //Runtime: 1 ms, faster than 95.18% of Java online submissions for Generate Parentheses.
	 //Memory Usage: 36.4 MB, less than 100.00% of Java online submissions for Generate Parentheses.
	 public static List<String> generateParenthesis(int n) {
		 List<String> solution = new ArrayList<String>();
		 helper(solution, "", 0, 0, n);
		 return solution;
	 }
	 
	 public static void helper(List<String> list, String cur, int open, int close, int max) {
		 if(open == max && close == max) {
			 list.add(cur);
			 return;
		 }
		 if(open < max) {
			 helper(list, cur+"(", open+1, close, max);
		 }
		 if(close < open) {
			 helper(list, cur+")", open, close+1, max);
		 }
	 }
	 
	 //Runtime: 195 ms, faster than 11.02% of Java online submissions for Merge k Sorted Lists.
	 //Memory Usage: 50.5 MB, less than 12.57% of Java online submissions for Merge k Sorted Lists.
	 public ListNode mergeKLists(ListNode[] lists) {
	        if(lists == null || lists.length == 0) return null;
	        ListNode sol = new ListNode(0);
	        int min = Integer.MAX_VALUE;
	        int minIndex = 0;
	        boolean allNull = true;
	        for(int i = 0; i < lists.length; i++){
	            if(lists[i] != null){
	                allNull = false;
	                if(lists[i].val < min){
	                    minIndex = i;
	                    min = lists[i].val;
	                }
	            }

	        }
	        if(allNull) return null;
	        sol.next = new ListNode(lists[minIndex].val);
	        lists[minIndex] = lists[minIndex].next;
	        sol = sol.next;
	        sol.next = mergeKLists(lists);
	        return sol;
	 }
	 
	 //Runtime: 0 ms, faster than 100.00% of Java online submissions for Swap Nodes in Pairs.
	 //Memory Usage: 34.5 MB, less than 100.00% of Java online submissions for Swap Nodes in Pairs.   
	 public ListNode swapPairs(ListNode head) {
		 
		 if(head == null) return head;
		 else if(head.next == null) return head;
	        
		 ListNode temp = head.next;
		 head.next = swapPairs(temp.next);
		 temp.next = head;
	        
		 return temp;
	    
	 }
	 
	 //Runtime: 3 ms, faster than 61.65% of Java online submissions for Longest Valid Parentheses.
	 //Memory Usage: 37.6 MB, less than 82.35% of Java online submissions for Longest Valid Parentheses.
	 //32 Longest Valid Parentheses  Hard
	 public int longestValidParentheses(String s) {
		        LinkedList<Integer> stack = new LinkedList();
		        int maxLength = 0;
		        int previous = 0;
		        for(int i = 0; i < s.length(); i++){
		            if(s.charAt(i) == '('){
		                stack.push(i);
		            }
		            else{
		                if(stack.isEmpty()){
		                    previous = 0;
		                }
		                else{
		                    stack.pop();
	                        previous += 2;
	                        if(stack.isEmpty()){
	                            maxLength = Math.max(previous, maxLength);
	                        }
	                        else{
	                            maxLength = Math.max(i - stack.peek(), maxLength);
	                        }
	                        
		                }
		            }
		        
		        }
		        return maxLength;
		}
	 
	 //Runtime: 0 ms, faster than 100.00% of Java online submissions for Search in Rotated Sorted Array.
	 //Memory Usage: 40.6 MB, less than 6.92% of Java online submissions for Search in Rotated Sorted Array.
	 public static int search(int[] nums, int target) {
		 
		 int left = 0;
		 int right = nums.length - 1;
		 int mid;
         
		 while(left <= right){
             mid = (left + right)/2;
             if(nums[mid] == target){
                 return mid;
             }
             else if(nums[left] == target){
                 return left;
             }
             else if(nums[right] == target){
                 return right;
             }
             
             if(nums[mid] > nums[left]){
                 if(target >= nums[left] && target <= nums[mid]){
                     right = mid - 1;
                 }
                 else{
                     left = mid + 1;
                 }
             }
             else if(nums[mid] < nums[left]){
                 if(target >= nums[mid] && target <= nums[right]){
                     left = mid + 1;
                 }
                 else{
                     right = mid - 1;
                 }
             }
             else{
                 //nums[left] == nums[mid], means left == mid
                 return -1;
             }
		 }
	     return -1;
	    }
	 
	 
	 //Runtime: 0 ms, faster than 100.00% of Java online submissions for Find First and Last Position of Element in Sorted Array.
	 //Memory Usage: 43.5 MB, less than 97.16% of Java online submissions for Find First and Last Position of Element in Sorted Array.
	 //34. Find First and Last Position of Element in Sorted Array; Medium
	 public static int[] searchRange(int[] nums, int target) {
	        
		 if(nums == null || nums.length == 0) return new int[] {-1, -1};
		 int left = 0;  
		 int right = nums.length - 1;
		 int mid = (left + right)/2;
		 int search = -1;
		 int start = -1;
		 int end = -1;
		 while(left <= right){
			 if(nums[left] == target){
				 search = left;
				 break;
	            }
			 else if(nums[right] == target){
				 search = right;
				 break;
	            }
			 else if(nums[mid] == target){
				 search = mid;
				 break;
	            }
			 else if(nums[mid] > target){
				 right = mid - 1;
				 mid = (left + right)/2;
	            }
			 else if(nums[mid] < target){
				 left = mid + 1;
				 mid = (left + right)/2;
	            }
	        }
		 if(search == -1){
			 return new int[] {-1, -1};
	        }
		 else{
			 start = end = search;
			 while(start >= 0 && nums[start] == target ){
				 start--;
	            }
			 start++;
	         
			 while(end < nums.length && nums[end] == target){
				 end++;
	            }
			 end--;
	         
			 return new int[] {start, end};
	        }
	    }
	 
	 //Runtime: 4 ms, faster than 46.97% of Java online submissions for Valid Sudoku.
	 //Memory Usage: 44.2 MB, less than 71.01% of Java online submissions for Valid Sudoku.
	 //36. Valid Sudoku; Medium
	 public boolean isValidSudoku(char[][] board) {
		 Set seen = new HashSet();
		 for(int i = 0; i < 9; i++) {
			 for(int j = 0; j < 9; j++) {
				 char num = board[i][j];
				 if(num != '.') {
					 if(!seen.add(num + "row" + i) ||
						!seen.add(num + "col" + j) ||
						!seen.add(num + "square" + i/3 + j/3)) {
						 return false;
					 }
				 }
			 }
		 }
		 return true;
	 
	 }
	 
	 //Runtime: 0 ms, faster than 100.00% of Java online submissions for Rotate Image.
	 //Memory Usage: 36.1 MB, less than 100.00% of Java online submissions for Rotate Image.
	 //48. Rotate Image, Medium
	 public void rotate(int[][] matrix) {
	        
		 int squareSize = (matrix.length%2==0)?matrix.length/2:matrix.length/2+1;
		 for(int i = 0; i < squareSize; i++){
			 for(int j = i; j < matrix.length-i-1; j++){
	         
				 int temp = matrix[i][j];
				 matrix[i][j] = matrix[matrix.length-j-1][i];
				 matrix[matrix.length-j-1][i] = matrix[matrix.length-i-1][matrix.length-j-1];
				 matrix[matrix.length-i-1][matrix.length-j-1] = matrix[j][matrix.length-i-1];
				 matrix[j][matrix.length-i-1] = temp;
	            }
	        }
	    }
	 
		 public static void main(String[] args) {
			 //System.out.println(longestCommonPrefix(new String[] {"flower","flow","flight"}));
			 //System.out.println(divide(2147483647,1));
			 //int[] tt = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
			 //System.out.println(firstMissingPositive(tt));
			 //System.out.println(threeSum(tt));
			 //System.out.println(isValid("[()]"));
			 //int[] test = {5,6,7,8,9,0,1,2,3,4};
			 //System.out.println(search(test, 4));
			 //int[] test = {1};
			 //System.out.println(Arrays.toString(searchRange(test,1)));
			 int[] test = {0,1,0,2,1,0,1,3,2,1,2,1};
			 System.out.println(trap(test));
		 }
