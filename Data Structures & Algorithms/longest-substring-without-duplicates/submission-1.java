class Solution {
    public int lengthOfLongestSubstring(String s) {
        String sub = "";
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            HashSet<Character> set = new HashSet<>();
            for (int j = i; j <s.length() ; j++) {
                if(set.contains(s.charAt(j))){
                    break;
                }
                set.add(s.charAt(j));
                int currentLength = j - i + 1;
                if(currentLength > maxLength){
                    maxLength = currentLength;
                    sub = s.substring(i, j + 1) + " ";
                }

            }
        }
        return maxLength;
    }
}
