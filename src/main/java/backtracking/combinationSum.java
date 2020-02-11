package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname combinationSum2
 * @Description TODO
 * @Date 2020/2/11 9:46
 * @Created by zheng.nie
 */
public class combinationSum {

    private List<List<Integer>> ans = new ArrayList<>();


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> res = new ArrayList<>();
        backtracking(0, target, res, candidates);
        return ans;
    }

    private void backtracking(int index, int target, List<Integer> res, int[] candidates) {
        if (target == 0) {
            ans.add(new ArrayList<>(res));
            return ;
        }
        if (target < 0) {
            return ;
        }
        for (int i = index; i < candidates.length - 1; i++) {
            res.add(candidates[i]);
            backtracking(i + 1, target - candidates[i], res, candidates);
             res.remove(res.size()-1);
        }
    }

}
