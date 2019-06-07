import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class main {
    public static void main(String[] args) {
        Integer[] arr={1,2,3,4,5,6};
        List list=Arrays.asList(arr);
        List<Integer> list2=new ArrayList<Integer>(list);
        int res=GetUglyNumber_Solution2(200,list2);
        System.out.println(1);
    }
    public static int GetUglyNumber_Solution2(int index,List<Integer> list) {
        while(list.size()<index){
            int maxItem=list.get(list.size()-1);
            List<Integer> tmp=new ArrayList<Integer>();
            for(Integer i:list){
                if(i*2>maxItem){
                    tmp.add(i*2);
                    break;
                }
            }
            if(tmp.size()>0){
                maxItem=tmp.get(tmp.size()-1);
            }else{
                maxItem=list.get(list.size()-1);
            }
            for(Integer i:list){
                if(i*3>maxItem){
                    tmp.add(i*3);
                    break;
                }
            }
            if(tmp.size()>0){
                maxItem=tmp.get(tmp.size()-1);
            }else{
                maxItem=list.get(list.size()-1);
            }
            for(Integer i:list){
                if(i*5>maxItem){
                    tmp.add(i*5);
                    break;
                }
            }
            list.addAll(tmp);
        }
        return list.get(index-1);
    }
    public static boolean judge(int n){
        while(n%2==0){
            n=n/2;
        }
        while(n%3==0){
            n=n/3;
        }
        while(n%5==0){
            n=n/5;
        }
        return n==1?true:false;
    }
}
