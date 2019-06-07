import java.util.ArrayList;
import java.util.List;

public class main {
    private static List<List<Integer>> ret;
    public static void main(String[] args) {
        System.out.println(climbStairs(35));
    }
    public static int climbStairs(int n) {
        if(n==1){
            return 1;
        }

        if(n==2){
            return 2;
        }
        int[] sum=new int[n+1];
        sum[1]=1;
        sum[2]=2;
        for(int i=3;i<=n;i++){
            sum[i]=sum[i-1]+sum[i-2];
        }
        return sum[n];
    }

    public static void find(int[] steps, List<Integer> tmpRes,int sum,int n){
        boolean[] visit={false,false};
        if(sum==n){
            List<Integer> resList=new ArrayList<Integer>();
            resList.addAll(tmpRes);
            ret.add(resList);
            return;
        }

        if(sum>n){
            return;
        }

        for(int i=0;i<visit.length;i++){
//            if(!visit[i]){
//                visit[i]=true;
                tmpRes.add(steps[i]);
                find(steps,tmpRes,sum+steps[i],n);
//                visit[i]=false;
                tmpRes.remove(tmpRes.size()-1);
//            }
        }

    }
}
