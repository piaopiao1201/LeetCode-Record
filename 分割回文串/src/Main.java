import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<List<String>> res=partition("aab");
        System.out.println(1);
    }
    public static List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<List<String>>();
        List<String> tempRes=new ArrayList<String>();
        DFS(tempRes,s,res,0);
        return res;
    }
    public static void DFS(List<String> list,String s,List<List<String>> res,int index){
        if(index==s.length()){
            res.add(new ArrayList<String>(list));
            return;
        }
        for(int i=index;i<s.length();i++){
            if(isHuiWen(s.substring(index,i+1))){
                list.add(s.substring(index,i+1));
                DFS(list,s,res,i+1);
                list.remove(list.size()-1);
            }
        }
    }
    public static boolean isHuiWen(String s){
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }
}
