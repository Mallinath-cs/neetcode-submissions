class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[n - k + 1]; // 7 - 3 + 1 = 5 == totals answers possible when sliding
        // If you see a smaller element remove it from the back
        for (int i = 0; i < k ; i++) {
            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]){
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        //The front of the deque is the max of the first window
        result[0] = nums[deque.peekFirst()];

        // Process the remaining elements
        for (int i = k; i < n; i++) {
            if(deque.peekFirst() <= i - k){
                deque.pollFirst();
            }
            // Remove all the elements smaller than the incoming element
            while(!deque.isEmpty() && nums[deque.peekLast()] <=nums[i]){
                deque.pollLast();
            }
            // Add current element's index
            deque.offerLast(i);

            // The front of the deque is always the max
            result[i - k + 1] = nums[deque.peekFirst()];
        }
        return result;
    }
}
