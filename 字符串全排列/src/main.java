import java.util.ArrayList;
import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        String str="a";
        ArrayList<String> res=Permutation(str);
        System.out.println(1);
    }
    public static ArrayList<String> Permutation(String str) {
        ArrayList<Character> tmpRes=new ArrayList<Character>();
        ArrayList<String> res=new ArrayList<String>();
        if(str.length()==0){
            return res;
        }
        boolean[] visited=new boolean[str.length()];
        Arrays.fill(visited,false);
        find(str,visited,tmpRes,res);
        return res;
    }
    public static void find(String str,boolean[] visited,ArrayList<Character> tmpRes,ArrayList<String> res){
        if(tmpRes.size()==str.length()){
            StringBuilder sb=new StringBuilder();
            for(Character i:tmpRes){
                sb.append(i);
            }
            //Character[] tmp=(Character[])tmpRes.toArray();
            if(!res.contains(sb.toString())) {
                res.add(sb.toString());
            }
            return;
        }
        for(int i=0;i<str.length();i++){
            if(!visited[i]){
                tmpRes.add(str.charAt(i));
                visited[i]=true;
                find(str,visited,tmpRes,res);
                visited[i]=false;
                tmpRes.remove(tmpRes.size()-1);
            }
        }
    }
}
