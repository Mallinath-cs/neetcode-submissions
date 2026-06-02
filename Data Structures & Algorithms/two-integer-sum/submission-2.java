class Solution {
    public int[] twoSum(int[] nums, int target) {
         // 3 5 7 8
        // 12
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <nums.length ; i++) {
            int findMe = target - nums [i]; // 7
            if(map.containsKey(findMe) ){
                return new int[] {map.get(findMe), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
