class Solution {

    class Num{
        int val, index;
        Num(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }
    
    Num[] num;
    
    public Solution(int[] nums) {
        num = new Num[nums.length];
        for (int i = 0; i < nums.length; i ++)
            num[i] = new Num(nums[i], i);
        Arrays.sort(num, new Comparator<Num>() {
            public int compare(Num a, Num b) {
                return a.val - b.val;
            }
        });
    }
    
    public int pick(int target) {
        int l = 0, r = num.length;
        while (l < r - 1) {
            int mid = (l + r) / 2 - 1;
            if (num[mid].val >= target)
                r = mid + 1;
            else l = mid + 1;
        }
        int left = l;
        
        l = 0;
        r = num.length;
        while (l < r - 1) {
            int mid = (l + r) / 2;
            if (num[mid].val > target)
                r = mid;
            else l = mid;
        }
        int right = l + 1;
        
        int index = (int)(Math.random() * (right - left) + left);
        
        return num[index].index;
    }
}

class Solution {

    Random random;
    int[] nums;
    
    public Solution(int[] nums) {
        this.nums = nums;
        random = new Random();
    }
    
    public int pick(int target) {
        int rtn = -1, count = 0;
        for (int i = 0; i < nums.length; i ++){
            if (nums[i] != target) continue;
            if (random.nextInt(++ count) == 0)
                rtn = i;
        }
        return rtn;
    }
}

class Solution {

    Map<Integer, List<Integer>> map;
    Random rand;
    
    public Solution(int[] nums) {
        map = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            List<Integer> list = map.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            map.put(nums[i], list);
        }
        rand = new Random();
    }
    
    public int pick(int target) {
        int index = rand.nextInt(map.get(target).size());
        return map.get(target).get(index);
    }
}

class Solution {

    int[] nums;
    Random rand;
    
    public Solution(int[] nums) {
        this.nums = nums;
        rand = new Random();
    }
    
    public int pick(int target) {
        int count = 0, rtn = -1;
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] == target)
                if (rand.nextInt(++ count) == 0)
                    rtn = i;
        }
        return rtn;
    }
}