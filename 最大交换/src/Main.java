import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
*给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
示例 1 :

输入: 2736
输出: 7236
解释: 交换数字2和数字7。
示例 2 :

输入: 9973
输出: 9973
解释: 不需要交换。
*/
public class Main {
    public static void main(String[] args) {
        System.out.println(1);
    }
    public int maximumSwap(int num) {
        List<Integer> list=new ArrayList<Integer>();
        while(num>0){
            list.add(num%10);
            num/=10;
        }
        Collections.reverse(list);
        int allRes=0;
        for(int i=0;i<list.size();i++){
            int maxNum=0;
            int maxPos=0;
            for(int j=i;j<list.size();j++){
                if(list.get(j)>=maxNum){
                    maxNum=list.get(j);
                    maxPos=j;
                }
            }
            int temp=list.get(maxPos);
            list.set(maxPos,list.get(i));
            list.set(i,temp);
            int res=0;
            for(int k=0;k<list.size();k++){
                res=res*10+list.get(k);
            }
            list.set(i,list.get(maxPos));
            list.set(maxPos,temp);
            allRes=Math.max(res,allRes);
        }
        return allRes;
    }
}
