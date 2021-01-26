package offer;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 * @author: niezheng
 * @create: 2021-01-22 16:43
 **/
public class Solution6 {

    //45123   01234

    public int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int first = 0;
        int last = array.length - 1;
        while (first < last) {
            if (array[first] < array[last]) {
                return array[first];
            }
            int mid = first + ((last - first) >> 1);
            if (array[mid] > array[last]) {
                first = mid + 1;
            } else if (array[mid] < array[last]) {
                last = mid;
            } else {
                last--;
            }

        }
        return array[first];
    }


}
