import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class main {
//    public static List<List<String>> allRes=new ArrayList<List<String>>();
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] wordList = {"hot","dot","dog","lot","log","cog"};
        List<String> wordList2= Arrays.asList(wordList);
        int res=ladderLength(beginWord,endWord,wordList2);
        System.out.println(res);
    }
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return 0;
        }
        List<String> tempRes=new ArrayList<String>();
        List<List<String>> allRes=new ArrayList<List<String>>();
        tempRes.add(beginWord);
        boolean[] flag=new boolean[wordList.size()];
        Arrays.fill(flag,false);
        dfs(wordList,beginWord,endWord,flag,tempRes,allRes);
        if(allRes.size()==0){
            return 0;
        }
        int minCount=Integer.MAX_VALUE;
        for(int i=0;i<allRes.size();i++){
            minCount=Math.min(minCount,allRes.get(i).size());
        }
        return minCount;
    }
    public static void dfs(List<String> wordList,String beginWord,String endWord,boolean[] flag,List<String> tempRes,List<List<String>> allRes){
        if(tempRes.size()>1&&tempRes.get(tempRes.size()-1).equals(endWord)){
            List<String> temp=new ArrayList<String>(tempRes);
//            if(allRes.size()==0){
//                allRes.add(temp);
//                return;
//            }
//            int i=0;
//            for(i=0;i<allRes.size();i++){
//                int j=0;
//                for(;j<tempRes.size();j++){
//                    if(!allRes.get(i).contains(tempRes.get(j))){
//                        break;
//                    }
//                }
//                if(j==tempRes.size()){
////                    allRes.add(temp);
////                    return;
//                    break;
//                }
//            }
//            if(i==allRes.size()){
//                allRes.add(temp);
//                return;
//            }
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
