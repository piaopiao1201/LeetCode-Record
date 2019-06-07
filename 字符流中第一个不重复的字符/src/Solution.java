import java.util.HashSet;
import java.util.LinkedHashSet;

public class Solution {
    private String s="";
    private HashSet<Character> hashSet=new LinkedHashSet<Character>();
    private HashSet<Character> set=new HashSet<Character>();
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        s+=ch;
        if(set.contains(ch)){
            hashSet.remove(ch);
        }else{
            set.add(ch);
            hashSet.add(ch);
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        for(Character a:hashSet){
            return a;
        }
        return '#';
    }
}
