package hw;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Classname Test1
 * @Description TODO
 * @Date 2020/2/15 12:12
 * @Created by zheng.nie
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] pi = new int[10];
 /*       int index = 0;
        while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String next = in.next();
            if (next.endsWith("S")) {
                int i = Integer.valueOf(next.split("S")[0]) * 7;
                System.out.println(i);
                pi[index++] = i;
            } else {
                int i = Integer.valueOf(next.split("Y")[0]);
                System.out.println(i);
                pi[index++] = i;
            }
        }*/

        pi = new int[]{2,21,28,6,56};
        System.out.println(dp(pi));
    }

    static int dp(int[] pi) {
        int max = 0;
        int[] dp = new int[pi.length];
        Integer min = Integer.MIN_VALUE;
        for (int i = 1; i < pi.length; i++) {
            min = min<pi[i] ? pi[i] : min;
            if (pi[i]  < pi[i-1]) {
               max = max+ pi[i]-min;
               min = pi[i];
            }
        }
        return max;
    }

}
