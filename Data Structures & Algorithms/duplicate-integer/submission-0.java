class Solution {
    public boolean hasDuplicate(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : nums) {
            if (!list.isEmpty() && list.contains(i)) {
                return true;
            }
            list.add(i);
        }
        return false;
    }
}