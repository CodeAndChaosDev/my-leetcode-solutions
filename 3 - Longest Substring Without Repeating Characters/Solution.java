
import java.util.HashSet;

// LeetCode Problem: 3. Longest Substring Without Repeating Characters
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // This soluytion is based on the sliding window technique
        // Set of characters to keep track of the ones we seen
       HashSet<Character> set = new HashSet<>();
       //left pointer
       int left = 0, maxLength = 0;
       for (int right=0; right < s.length (); right ++) {
        //basically if a character repeats itself we remove the left pointer and keep moving to the right
        //until we reach a combination of different characters in the set that represent (left to right) length
        while(set.contains(s.charAt(right))) {
            // we remove the character represented by the left pointer
            set.remove(s.charAt(left));
            //we move to the next character
            left++;
        }
        // we add the character represented  by the right pointer to the set
        set.add(s.charAt(right));
        // the max length is the maximum between the old max length and the new difference of (right - left ) pointer
        maxLength = Math.max(maxLength, right - left +1);
       }
    
       return maxLength;
    }
}
