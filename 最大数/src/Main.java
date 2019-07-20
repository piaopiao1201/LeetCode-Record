import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] nums={121,12};
        String s1="42313";
        String s2="22343";
        int c1=s1.compareTo(s2);
        largestNumber(nums);
    }
    public static String largestNumber(int[] nums) {
        List<Integer> ques=new ArrayList<Integer>();
        for(int i:nums){
            ques.add(i);
        }
        ques.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                boolean swap=false;
                String q1=String.valueOf(o1);
                String q2=String.valueOf(o2);
                if(q1.length()>q2.length()){
                    swap=true;
                    String temp=q1;
                    q1=q2;
                    q2=temp;
                }
                for(int i=0;i<q1.length();i++){
                    if(q1.charAt(i)>q2.charAt(i)){
                        return swap?1:-1;
                    }else if(q1.charAt(i)<q2.charAt(i)){
                        return swap?-1:1;
                    }
                }
                if(q2.length()>q1.length()){
                    String q1Addq2=q1+q2;
                    String q2Addq1=q2+q1;
                    return q1Addq2.compareTo(q2Addq1)>0?(swap?1:-1):(swap?-1:1);
//                    if(q2.charAt(0)>q2.charAt(q1.length())){
//                        return swap?1:-1;
//                    }else{
//                        return swap?-1:1;
//                    }
                }
                return 0;
            }
        });
        StringBuilder res=new StringBuilder();
        for(int i:ques){
            res.append(i);
        }
        int start=-1;
        for(int i=0;i<res.length();i++){
            if(res.charAt(i)=='0'){
                start=i;
            }else{
                break;
            }
        }
        if(start!=-1){
            res.delete(0,start);
        }
        if(res.length()==0){
            res.append('0');
        }
        return res.toString();
    }
}
