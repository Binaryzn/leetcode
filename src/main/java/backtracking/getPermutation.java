package backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class getPermutation {

    List<List<Integer>> ans  = new ArrayList<>();

    List<Integer> res = new ArrayList<>();
    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();

        dfs(1,n,list,k);
        StringBuilder s = new StringBuilder();
        res.forEach(s::append);
        return s.toString();
    }

  void dfs(int index, int n,List<Integer> list,int k){
        if(list.size() == n){
            ans.add(new ArrayList<>(list));
            if(ans.size() == k){
             res.addAll(new ArrayList<>(list));
            }
            return ;
        }
        for (int i = index;i<=n;i++){
            list.add(i);
            dfs(index+1,n,list,k);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        getPermutation permutation = new getPermutation();
        permutation.getPermutation(3,3);
    }

}
