package recursion;

import java.util.Arrays;

/**
 * @Classname canPartitionKSubsets
 * @Description TODO
 * @Date 2020/2/10 14:15
 * @Created by zheng.nie
 * [4, 3, 2, 3, 5, 2, 1], k = 4
 */
public class canPartitionKSubsets {

    public static boolean search(int[] group, int len, int[] nums, int target) {
        if (len < 0) {
            return true;
        }
        int v = nums[len--];
        for (int i = 0; i < group.length; i++) {
            if (group[i] + v <= target) {
                group[i] += v;
                if(search(group,len,nums,target)){
                    return true;
                }
                group[i] -= v;
            }
        }
        return false;
    }

    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) {
            return false;
        }
        int target = sum / k;
        Arrays.sort(nums);
        int len = nums.length-1;
        if (nums[len] > target) {
            return false;
        }
        while (len >= 0 && nums[len] == target) {
            len--;
            k--;
        }
        int[] group = new int[k];
        System.out.println(search(group,len,nums,target));
        return  search(group,len,nums,target);
    }


    public static void main(String[] args) {
        int[] num = new int[]{10,10,10,7,7,7,7,7,7,6,6,6};
        canPartitionKSubsets(num, 3);
    }

}
