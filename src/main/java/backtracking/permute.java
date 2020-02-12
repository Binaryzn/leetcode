package backtracking;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Classname permute
 * @Description TODO
 * @Date 2020/2/12 10:30
 * @Created by zheng.nie
 *  1 2 3
 *
 *   1 2 3
 *   1 3 2
 *   2 1 3
 *   2 3 1
 *   3 1 2
 *   3 2 1
 */
public class permute {

    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        int [] flag = new int[nums.length];
        backtracking(new LinkedList<>(),nums,flag);
        System.out.println(ans);
        return ans;
    }


    private void backtracking(Deque<Integer> deque,int[] nums,int[] flag){
        if(deque.size() == nums.length){
            ans.add(new ArrayList<>(deque));
            return;
        }
        for (int i=0;i<nums.length;i++){
            if(flag[i] == 1){
                continue;
            }
            flag[i] =1;
            deque.addLast(nums[i]);
            backtracking(deque,nums,flag);
            //回溯还原
            flag[i] =0;
            deque.removeLast();
        }

    }

    public static void main(String[] args) {
        int[] ints = {1,2,3};
        permute permute = new permute();
        permute.permute(ints);
    }
}
