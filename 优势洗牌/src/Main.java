import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Main {
    /*
    给定两个大小相等的数组 A 和 B，A 相对于 B 的优势可以用满足 A[i] > B[i] 的索引 i 的数目来描述。

返回 A 的任意排列，使其相对于 B 的优势最大化。

 

示例 1：

输入：A = [2,7,11,15], B = [1,10,4,11]
输出：[2,11,7,15]
示例 2：

输入：A = [12,24,8,32], B = [13,25,32,11]
输出：[24,32,8,12]
 

提示：

1 <= A.length = B.length <= 10000
0 <= A[i] <= 10^9
0 <= B[i] <= 10^9

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/advantage-shuffle
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        int[] A={4,23,43,55,23,5,6};
        int[] B={5,25,53,15,64,3,4};
        int[] res=advantageCount(A,B);
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }

    }
    public static int[] advantageCount(int[] A, int[] B) {
        Temp[] tempB= new Temp[B.length];
        for(int i=0;i<B.length;i++){
            tempB[i]=new Temp(B[i],i);
        }
        Arrays.sort(tempB, new Comparator<Temp>() {
            @Override
            public int compare(Temp o1, Temp o2) {
                return o1.value-o2.value;
            }
        });
        Arrays.sort(A);
        int num=0;
        int l1=0,l2=0;
        int r1=A.length-1,r2=B.length-1;
        int[] res=new int[A.length];
        while(num<A.length){
            if(A[r1]>tempB[r2].value){
                res[tempB[r2].index]=A[r1];
                num++;
                r2--;
                r1--;
            }else if(A[r1]<tempB[r2].value){
                res[tempB[r2].index]=A[l1];
                num++;
                l1++;
                r2--;
            }else{
                if(A[l1]>tempB[l2].value){
                    res[tempB[l2].index]=A[l1];
                    num++;
                    l1++;
                    l2++;
                }else{
                    res[tempB[r2].index]=A[l1];
                    num++;
                    r2--;
                    l1++;
                }
            }
        }
        return res;
    }
    static class Temp {
        int value,index;
        public Temp(int value,int index){
            this.value=value;
            this.index=index;
        }

    }
}
