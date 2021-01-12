package offer;

/**
 * @author: niezheng
 * @create: 2021-01-12 21:18
 **/
public class Solution2 {
    public String replaceSpace(StringBuffer str) {
        int newSize = 0;
        for (int i = 0;i< str.length();i++){
            if(str.charAt(i) == ' '){
                newSize++;
            }
        }
        int oldIndex = str.length()-1;
        int newLength = str.length() + 2* newSize;
        str.setLength(newLength);
        int newIndex = newLength-1;
        for (;oldIndex >=0;oldIndex--){
            if(str.charAt(oldIndex) == ' '){
                str.setCharAt(newIndex--, '0');
                str.setCharAt(newIndex--,'2');
                str.setCharAt(newIndex--,'%');
            }else {
                str.setCharAt(newIndex--,str.charAt(oldIndex));
            }
        }
        return str.toString();
    }
}
