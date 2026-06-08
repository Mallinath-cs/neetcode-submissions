class TimeMap {
     private static class Pair {
        List<Integer> times = new ArrayList<>();
        List<String> values = new ArrayList<>();
    }

    private Map<String, Pair> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new Pair());
        Pair p = map.get(key);

        p.times.add(timestamp);
        p.values.add(value);
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";

        Pair p = map.get(key);

        int idx = binarySearch(p.times, timestamp);

        if (idx < 0) return "";
        return p.values.get(idx);
    }
    private int binarySearch(List<Integer> arr, int target) {
        int left = 0, right = arr.size() - 1;
        int res = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr.get(mid) <= target) {
                res = mid;      // valid answer, try to go right
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return res;
    }
}
