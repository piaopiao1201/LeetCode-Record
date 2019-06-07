import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class main {
    //    public static List<List<String>> allRes=new ArrayList<List<String>>();
    public static void main(String[] args) {
        String beginWord = "qa";
        String endWord = "sq";
        String[] wordList = {"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"};
        List<String> wordList2= Arrays.asList(wordList);
        List<List<String>> res=ladderLength(beginWord,endWord,wordList2);
        System.out.println(res);
    }
    public static List<List<String>> ladderLength(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> allRes=new ArrayList<List<String>>();
        if(!wordList.contains(endWord)){
            return allRes;
        }
        List<String> tempRes=new ArrayList<String>();
        tempRes.add(beginWord);
        boolean[] flag=new boolean[wordList.size()];
        Arrays.fill(flag,false);
        dfs(wordList,beginWord,endWord,flag,tempRes,allRes);
        if(allRes.size()==0){
            return allRes;
        }
        int minCount=Integer.MAX_VALUE;
        for(int i=0;i<allRes.size();i++){
            minCount=Math.min(minCount,allRes.get(i).size());
        }
        List<List<String>> allRes2=new ArrayList<List<String>>();
        for(int i=0;i<allRes.size();i++){
            if(allRes.get(i).size()==minCount){
                allRes2.add(allRes.get(i));
            }
        }
        return allRes2;
    }
    public static void dfs(List<String> wordList,String beginWord,String endWord,boolean[] flag,List<String> tempRes,List<List<String>> allRes){
        if(tempRes.size()>1&&tempRes.get(tempRes.size()-1).equals(endWord)){
            List<String> temp=new ArrayList<String>(tempRes);
            allRes.add(temp);
            return;
        }
        for(int i=0;i<wordList.size();i++){
            if(wordList.get(i).equals(beginWord)){
                continue;
            }
            if(!flag[i]){
                if(check(tempRes.get(tempRes.size()-1),wordList.get(i))){
                    flag[i]=true;
                    tempRes.add(wordList.get(i));
                    dfs(wordList,beginWord,endWord,flag,tempRes,allRes);
                    tempRes.remove(tempRes.size()-1);
                    flag[i]=false;
                }
            }
        }
    }
    public static boolean check(String a,String b){
        if(a.length()!=b.length()){
            return false;
        }
        int count=0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i)){
                count++;
                if(count>1){
                    return false;
                }
            }
        }
        return true;
    }
}
