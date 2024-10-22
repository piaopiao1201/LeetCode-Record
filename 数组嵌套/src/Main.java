import java.util.HashSet;
import java.util.Set;
/*
索引从0开始长度为N的数组A，包含0到N - 1的所有整数。找到并返回最大的集合S，S[i] = {A[i], A[A[i]], A[A[A[i]]], ... }且遵守以下的规则。

假设选择索引为i的元素A[i]为S的第一个元素，S的下一个元素应该是A[A[i]]，之后是A[A[A[i]]]... 以此类推，不断添加直到S出现重复的元素。

示例 1:

输入: A = [5,4,0,3,1,6,2]
输出: 4
解释:
A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.

其中一种最长的 S[K]:
S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}

 */
public class Main {
    public static void main(String[] args) {
        String path="file:/D:/Code6/web/sas";
        path=path.replace("/","\\");
        System.out.println(path);
        System.out.println("阿萨");
    }
    public int arrayNesting(int[] nums) {
        Set<Integer> visit=new HashSet<Integer>();
        int maxSum=0;
        for(int i=0;i<nums.length;i++){
            if(!visit.contains(i)){
                maxSum=Math.max(getLength(nums,visit,i),maxSum);
            }
        }
        return maxSum;
    }
    public int getLength(int[] nums,Set<Integer> visit,int start){
        int sum=0;
        while(true){
            if(visit.contains(start)){
                break;
            }
            sum++;
            visit.add(start);
            start=nums[start];
        }
        return sum;
    }
}
