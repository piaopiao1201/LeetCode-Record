import java.util.HashSet;
import java.util.Set;

public class main {
    public static void main(String[] args) {
        int res=LastRemaining_Solution(5,3);
        System.out.println(1);
    }
    public static int LastRemaining_Solution(int n, int m) {
        if(n==0){
            return -1;
        }
        Set<Integer> selected=new HashSet<Integer>();
        int lastOrder=0;
        boolean first=true;
        for(int i=0;i<n;i++){
            int time=0;
            int nowOrder=lastOrder;
//            if(first){
//                nowOrder--;
//                first=false;
//            }
            if(first){
                nowOrder-=1;
                first=false;
            }
            while(time<m){
                if(!selected.contains((nowOrder+1)%(n))){
                    time++;
                    nowOrder=(nowOrder+1)%(n);
//                    if(first){
//                        nowOrder=(nowOrder)%(n);
//                        first=false;
//                    }else{
//                        nowOrder=(nowOrder+1)%(n);
//                    }

                }else{
                    nowOrder=(nowOrder+1)%(n);
                }
            }
            selected.add(nowOrder);
            lastOrder=nowOrder;
            if(i==n-1){
                return nowOrder;
            }
        }
        return 0;
    }
}
