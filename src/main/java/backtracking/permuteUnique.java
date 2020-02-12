package backtracking;

import java.util.*;

/**
 * @Classname permuteUnique
 * @Description TODO
 * @Date 2020/2/12 11:23
 * @Created by zheng.nie
 */
public class permuteUnique {

    private List<List<Integer>> ans = new ArrayList<>();


    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        backtracking(nums, new LinkedList<>(), new boolean[nums.length]);
        return ans;
    }

    private void backtracking(int[] nums, Deque<Integer> deque, boolean[] flag) {
        if (deque.size() == nums.length) {
            ans.add(new ArrayList<>(deque));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (flag[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !flag[i-1]) {
                continue;
            }
            flag[i] = true;
            deque.addLast(nums[i]);
            backtracking(nums, deque, flag);
            flag[i] = false;
            deque.removeLast();
        }
    }

}
