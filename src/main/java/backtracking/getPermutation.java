package backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class getPermutation {

    List<List<Integer>> ans  = new ArrayList<>();

    List<Integer> res = new ArrayList<>();
    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        int[] flag = new int[n];
        dfs(1,n,list,k,flag);
        StringBuilder s = new StringBuilder();
        res.forEach(s::append);
        return  s.toString();
    }

  void dfs(int index, int n,List<Integer> list,int k,int[]  flag){
        if(list.size() == n){
            ans.add(new ArrayList<>(list));
            if(ans.size() == k){
             res.addAll(new ArrayList<>(list));
            }
            return ;
        }
        for (int i = 0;i<n;i++){
            if(flag[i] == 1){
                continue;
            }
            list.add(i+1);
            flag[i] = 1;
            dfs(index+1,n,list,k,flag);
            flag[i] = 0;
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        getPermutation permutation = new getPermutation();
        System.out.println(permutation.getPermutation(3,3));
    }

}
