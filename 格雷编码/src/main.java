import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class main {
    public static void main(String[] args) {
        List<Integer> ret=grayCode(2);
        System.out.println(1);

        Integer[] arr1={1,3,4};
        Integer[] arr2={3,1,4};
        List t1=Arrays.asList(arr1);
        List t2=Arrays.asList(arr2);
        List<Integer> list1=new ArrayList<Integer>(t1);
        List<Integer> list2=new ArrayList<Integer>(t2);
        System.out.println(list1.containsAll(list2));
    }

    public static List<Integer> grayCode(int n) {
        String[] tmp={"0"};
        List list=Arrays.asList(tmp);
        List<String> start=new ArrayList<String>(list) ;
        List<String> cur=new ArrayList<String>();
        List<Integer> ret=new ArrayList<Integer>();
        if(n==0){
            ret.add(0);
            return ret;
        }
        for(int i=1;i<=n;i++){
            cur.clear();
            for(String p:start){
                cur.add(p+"0");
            }
            for(int j=start.size()-1;j>=0;j--){
                cur.add(start.get(j)+"1");
            }
            start.clear();
            start.addAll(cur);
        }
        for(String p:cur){
            ret.add(Integer.valueOf(p,2));
        }
        return ret;
    }
}
