import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        List<String> res=letterCombinations("2");
        String a="dsf";

        System.out.println(a.contains("ds"));
        System.out.println(1);
    }
    public static List<String> letterCombinations(String digits) {
        Map<Integer,List<Character>> map=new LinkedHashMap<Integer, List<Character>>();
        List<String> res=new ArrayList<String>();
        if(digits.equals("")){
            return res;
        }
        for(char i='a';i<='z';i=(char)(i+1)){
            int num=i-'a';
            if(num<15){
                int index=num/3+1+1;
                if(map.containsKey(index)){
                    map.get(index).add(i);
                }else{
                    map.put(index,new ArrayList<Character>());
                    map.get(index).add(i);
                }
            }else if(num>=15&&num<19){
                if(map.containsKey(7)){
                    map.get(7).add(i);
                }else{
                    map.put(7,new ArrayList<Character>());
                    map.get(7).add(i);
                }
            }else if(num>=19&&num<22){
                if(map.containsKey(8)){
                    map.get(8).add(i);
                }else{
                    map.put(8,new ArrayList<Character>());
                    map.get(8).add(i);
                }
            }else{
                if(map.containsKey(9)){
                    map.get(9).add(i);
                }else{
                    map.put(9,new ArrayList<Character>());
                    map.get(9).add(i);
                }
            }
        }
        if(digits.length()==1){
            int index=digits.charAt(0)-'0';
            for(Character i:map.get(index)){
                res.add(String.valueOf(i));
            }
            return res;
        }
        int[] indexArr=new int[digits.length()];

        while(indexArr[0]<map.get(digits.charAt(0)-'0').size()){
            String temp="";
            for(int i=0;i<indexArr.length;i++){
                temp+=map.get(digits.charAt(i)-'0').get(indexArr[i]);
            }
            res.add(temp);
            int jinwei=0;
            for(int j=indexArr.length-1;j>=0;j--){
                if(j==indexArr.length-1){
                    int lastIndex=indexArr[j];
                    if(lastIndex+1>=map.get(digits.charAt(j)-'0').size()){
                        indexArr[j]=0;
                        jinwei++;
                    }else{
                        indexArr[j]++;
                    }
                }else{
                    if(jinwei>0){
                        jinwei=0;
                        int lastIndex=indexArr[j];
                        if(lastIndex+1>=map.get(digits.charAt(j)-'0').size()){
                            if(j==0){
                                indexArr[j]++;
                                break;
                            }
                            indexArr[j]=0;
                            jinwei++;
                        }else{
                            indexArr[j]++;
                        }
                    }else{
                        break;
                    }
                }
            }

        }
        return res;
    }
}
