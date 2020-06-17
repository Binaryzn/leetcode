package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: niezheng
 * @create: 2020-06-16 21:21
 **/
public class permutation {


    private StringBuilder path = new StringBuilder();
private List<String> res = new ArrayList<String>();
    public String[] permutation(String S) {
        char[] chars = S.toCharArray();
        //排序解决数据相同问题
        Arrays.sort(chars);
        boolean[] use = new boolean[chars.length];
        String[] ans = new String[res.size()];
        dsf(chars,use);
    }


    void dsf(char[] chars, boolean[] use){
      if(chars.length == path.length()){
          res.add(path.toString());
          return;
      }
      for (int i=0;i<chars.length;i++){
          if(use[i]){
              continue;
          }
          use[i] =true;
          //处理相同元素问题
          if(i>0 && chars[i]==chars[i-1] && ){
              continue;
          }
          path.append(chars[i]);
          dsf(chars,use);
          path.deleteCharAt(path.length()-1);

      }
    }
}
