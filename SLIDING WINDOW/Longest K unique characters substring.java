/*
Longest K unique characters substring 
Easy Accuracy: 49.84% Submissions: 26688 Points: 2
Given a string you need to print the size of the longest possible substring that has exactly K unique characters. If there is no possible substring then print -1.


Example 1:

Input:
S = "aabacbebebe", K = 3
Output: 7
Explanation: "cbebebe" is the longest 
substring with K distinct characters.
Example 2:

Input: 
S = "aaaa", K = 2
Output: -1
Explanation: There's no substring with K
distinct characters.

Your Task:
You don't need to read input or print anything. Your task is to complete the function longestKSubstr() which takes the string S and an integer K as input and returns the length of the longest substring with exactly K distinct characters. If there is no substring with exactly K distinct characters then return -1.


Expected Time Complexity: O(|S|).
Expected Auxiliary Space: O(1).


Constraints:
1 ≤ |S| ≤ 105
1 ≤ K ≤ 105
*/

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        HashMap<Character,Integer> mp=new HashMap<>();
        int start=0;
        int sizeAns=-1;
        for(int end=0;end<s.length();end++){
            char ch=s.charAt(end);
            mp.put(ch,mp.getOrDefault(ch,0)+1);
            while(start<end && mp.size()>k){
                char chr=s.charAt(start);
                if(mp.get(chr)==1){
                    mp.remove(chr);
                }
                else{
                    mp.put(chr,mp.get(chr)-1);
                }
                start++;
            }
            if(mp.size()==k){
               sizeAns=Math.max(sizeAns,end-start+1); 
            }
        }
        return sizeAns;
    }
}
