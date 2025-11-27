import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class App {
    public static void main(String[] args) {
    //    System.out.println(isAnagaram("rat", "art"));
    
    // List l = groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"});
    // System.out.println(l);
    }

    public static int[] twoSum(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0;i < nums.length;i++){
            int diff = target - nums[i];

            if(map.containsKey(diff)){
                return new int[] {i, map.get(diff)};
            }

            map.put(nums[i], i);
        }
        return null;
    }

    public static boolean containsDuplicate(int[] nums){
        Set<Integer> seenNumbers = new HashSet<>();

        for(int i = 0;i < nums.length;i++){
            if(seenNumbers.contains(nums[i])){
                return true;
            }

            seenNumbers.add(nums[i]);
        }

        return false;
    }

    public static boolean containsDuplicateII(int[] nums, int k){
        Set<Integer> set = new HashSet<>();

        for(int i = 0;i < nums.length;i++){
            if(set.contains(nums[i])) return true;

            set.add(nums[i]);

            if(set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    public static boolean isAnagaram(String s, String t) {
        // If the lengths are different, they can't be anagrams
        if(s.length() != t.length()) return false;
        String first = s.toLowerCase();
        String second = t.toLowerCase();

        // Create an array to count characters frequencies
        int[] charCounts = new int[26]; // asuming only lowercase English letters
        
        // Increment count for each character in 's' and decrement for each in 't'
        for(int i = 0;i < first.length();i++){
            charCounts[first.charAt(i) - 'a']++;
            charCounts[second.charAt(i) - 'a']--;
        }

        // Check if all counts are zero
        for(int count : charCounts){
            if(count != 0) return false;
        }

        return true; // All counts are zero, so String t is anagram of String s
    }

    public static List<List<String>> groupAnagrams(String[] strs){
        if(strs.length == 0) return new ArrayList<>();

        Map<String, List<String>> ansMap = new HashMap<>();

        int[] count = new int[26];

        for(String s:strs){
            Arrays.fill(count, 0);
            
            for(char c:s.toCharArray()){
                count[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder("");
            for(int i = 0;i < 26;i++){
                sb.append("#");
                sb.append(count[i]);
            }
            String key = sb.toString();
            if(!ansMap.containsKey(key)){
                ansMap.put(key, new ArrayList<>());
            }
            ansMap.get(key).add(s);
        }
        return new ArrayList<>(ansMap.values());
    }
}
