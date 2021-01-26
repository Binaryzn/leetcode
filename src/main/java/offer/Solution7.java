package offer;

/**
 * @author: niezheng
 * @create: 2021-01-26 16:39
 **/
public class Solution7 {



    public int Fibonacci(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        return Fibonacci(n-1)+Fibonacci(n-2);
    }



}
