class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int max_length = 0;

        for (int right = 0; right < s.length() ; right++) {
            char ch = s.charAt(right);
            if(map.containsKey(ch) && map.get(ch) >= left){
                left = map.get(ch) + 1;
            }
            map.put(ch, right);
            max_length = Math.max(max_length, right - left + 1);
        }
    return max_length;
    }
}
