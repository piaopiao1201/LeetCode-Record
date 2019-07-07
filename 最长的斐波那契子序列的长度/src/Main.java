import java.util.HashSet;
import java.util.Set;

public class Main {
    /*
    如果序列 X_1, X_2, ..., X_n 满足下列条件，就说它是 斐波那契式 的：

n >= 3
对于所有 i + 2 <= n，都有 X_i + X_{i+1} = X_{i+2}
给定一个严格递增的正整数数组形成序列，找到 A 中最长的斐波那契式的子序列的长度。如果一个不存在，返回  0 。

（回想一下，子序列是从原序列 A 中派生出来的，它从 A 中删掉任意数量的元素（也可以不删），而不改变其余元素的顺序。例如， [3, 5, 8] 是 [3, 4, 5, 6, 7, 8] 的一个子序列）
示例 1：

输入: [1,2,3,4,5,6,7,8]
输出: 5
解释:
最长的斐波那契式子序列为：[1,2,3,5,8] 。
示例 2：

输入: [1,3,7,11,12,14,18]
输出: 3
解释:
最长的斐波那契式子序列有：
[1,11,12]，[3,11,14] 以及 [7,11,18] 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/length-of-longest-fibonacci-subsequence
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {

    }
    public int lenLongestFibSubseq(int[] A) {
        Set<Integer> set=new HashSet<Integer>();
        for(int i:A){
            set.add(i);
        }
        int maxLength=0;
        for(int i=0;i<A.length-2;i++){
            for(int j=i+1;j<A.length;j++){
                int start1=A[i],start2=A[j];
                int tempLength=2;
                while(set.contains(start1+start2)){
                    int temp=start1+start2;
                    start1=start2;
                    start2=temp;
                    tempLength++;
                }
                maxLength=Math.max(maxLength,tempLength);
            }
        }
        return maxLength>=3?maxLength:0;
    }
}
