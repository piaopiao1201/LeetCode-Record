import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String res=fractionToDecimal(-1,
                -2147483648);
        String res2=fractionToDecimal2(1,6);
        System.out.println(1);
    }
    //第一种:模拟长除法
    public static String fractionToDecimal(int numerator, int denominator) {
        if(numerator==0){
            return "0";
        }
        String res="";
        long numerator2,denominator2;
        if(numerator<0^denominator<0){
            res+="-";
        }
        numerator2=Math.abs(Long.valueOf(numerator));
        denominator2=Math.abs(Long.valueOf(denominator));
        long zs=0,ys=0;
        int index=0;
        List<Long> xsSet=new ArrayList<>();
        Map<Long,Integer> map=new HashMap<>();
        if(numerator>=denominator){
            zs = numerator2 / denominator2;
            ys = numerator2 % denominator2;
            if (ys == 0) {
                res += zs;
                return res;
            } else {
                res += zs;
                res += ".";
            }
        }else{
            res+="0.";
            ys=numerator2;
//            ys*=10;
        }
        long remainer=ys;
        while(remainer!=0){
            ys=ys%denominator;
            remainer=ys;
            ys*=10;
            zs=ys/denominator2;
            if(!map.containsKey(remainer)){
                map.put(remainer,index++);
                if(remainer!=0) {
                    xsSet.add(zs);
                }
            }else{
                int start=map.get(remainer);
                for(int i=0;i<start;i++){
                    res+=xsSet.get(i);
                }
                res+="(";
                for(int i=start;i<xsSet.size();i++){
                    res+=xsSet.get(i);
                }
                res+=")";
                return res;
            }
        }
        for (int i=0;i<xsSet.size();i++){
            res+=xsSet.get(i);
        }
        return res;
    }
    public static String fractionToDecimal2(int numerator, int denominator){
        if (numerator == 0) {
            return "0";
        }
        StringBuilder fraction = new StringBuilder();
        // If either one is negative (not both)
        if (numerator < 0 ^ denominator < 0) {
            fraction.append("-");
        }
        // Convert to Long or else abs(-2147483648) overflows
        long dividend = Math.abs(Long.valueOf(numerator));
        long divisor = Math.abs(Long.valueOf(denominator));
        fraction.append(String.valueOf(dividend / divisor));
        long remainder = dividend % divisor;
        if (remainder == 0) {
            return fraction.toString();
        }
        fraction.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                fraction.insert(map.get(remainder), "(");
                fraction.append(")");
                break;
            }
            map.put(remainder, fraction.length());
            remainder *= 10;
            fraction.append(String.valueOf(remainder / divisor));
            remainder %= divisor;
        }
        return fraction.toString();
    }
}
