package backtracking;

import java.util.*;

/**
 * @Classname combinationSum2
 * @Description TODO
 * @Date 2020/2/11 14:27
 * @Created by zheng.nie
 */
public class combinationSum2 {

    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Deque<Integer> res = new LinkedList<>();
        Arrays.sort(candidates);
        backtracking(0, target, candidates, res);
        return ans;
    }


    /**
     * @param index      数组的下标  因为数组元素不能重复 每次递归的时候下标+1
     * @param target     目标数 依次用目标数减去当前数组值
     * @param candidates 数组
     * @param deque      存放每个满足和为traget的元素
     */
    private void backtracking(int index, int target, int[] candidates, Deque<Integer> deque) {
        //和为target满足条件
        if (target == 0) {
            ans.add(new ArrayList<>(deque));
            return;
        }
        //不满足条件
        if (target < 0) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            //剪枝
            if (target - candidates[i] < 0) {
                break;
            }
            //相同层级不允许出现相同的元素 来达到去重的  i>index 主要时允许不同层级出现相同的元素
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            deque.addLast(candidates[i]);
            backtracking(i + 1, target - candidates[i], candidates, deque);
            deque.removeLast();
        }
    }

}
