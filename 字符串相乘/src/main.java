import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class main {
    public static void main(String[] args) {
        String s1="0";
        String s2="0";
        //Integer[] sa=new Integer[10];
        //Arrays.fill(sa,0);
        //List<Integer> list=new ArrayList<Integer>(Arrays.asList(sa));
        //list.add(1);
        System.out.println(multiply(s1,s2));
    }

    public static String multiply(String num1, String num2) {
        if(num1.equals("0")||num2.equals("0")){
            return "0";
        }
        Integer[] list=new Integer[num1.length()+num2.length()+2];
        Arrays.fill(list,0);
        //List<Integer> list=new ArrayList<Integer>(num1.length()+num2.length()+2);
        int k=num1.length()+num2.length()-2;
        for(int i=num1.length()-1;i>=0;i--){
            for(int j=num2.length()-1;j>=0;j--){
                int tmp=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                list[k-i-j]+=tmp;
            }
        }

        StringBuilder sb=new StringBuilder();
        int carryBit=0;
        for(int i=0;i<k+2;i++){
            sb.append((list[i]+carryBit)%10);
            carryBit=(list[i]+carryBit)/10;
        }

        while(carryBit!=0){
            sb.append(carryBit%10);
            carryBit/=10;
        }

        String res=null;
        int zeroNum=0;
        for(int i=sb.length()-1;i>=0;i--){
            if(sb.charAt(i)=='0'){
                zeroNum++;
            }else {
                break;
            }
        }

        sb.setLength(sb.length()-zeroNum);
        res=sb.reverse().toString();
        return res;
    }
}
