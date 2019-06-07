import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;

public class main {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] wordList = {"hot","dot","dog","lot","log","cog"};
        List<String> wordList2= Arrays.asList(wordList);
        List<String> wordList3=new ArrayList<String>(wordList2);
        System.out.println(findLadders(beginWord,endWord,wordList3));
    }
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> allRes=new ArrayList<List<String>>();
        if(!wordList.contains(endWord)){
            return allRes;
        }
        if(!wordList.contains(beginWord)){
            wordList.add(beginWord);
        }
        //创建关联数组
        boolean[][] wordDis=new boolean[wordList.size()][wordList.size()];
        Map<String,Boolean> flag=new HashMap<String,Boolean>();
        for(int i=0;i<wordDis.length;i++){
            for(int j=0;j<i;j++){
                if(check(wordList.get(i),wordList.get(j))){
                    wordDis[i][j]=wordDis[j][i]=true;
                }
            }
            flag.put(wordList.get(i),false);
        }
        bfs(wordList,wordDis,flag,beginWord,endWord,allRes);
        return allRes;
    }
    public static void bfs(List<String> wordList,boolean[][] wordDis,Map<String,Boolean> flag,String beginWord,String endWord,List<List<String>> allRes){
        Queue<levelWord> queue=new LinkedList<levelWord>();
        queue.add(new levelWord(beginWord,1,new ArrayList<String>(),new HashMap<String,Boolean>()));
        //flag.put(beginWord,true);
        int minLevel=-1;
        while(!queue.isEmpty()){
            levelWord temp=queue.poll();
            if(minLevel!=-1&&temp.level>minLevel){
                continue;
            }
            if(temp.word.equals(endWord)){
                if(minLevel==-1||temp.level==minLevel){
                    minLevel=temp.level;
                    allRes.add(temp.tempRes);
                    continue;
                }
            }
            int n=wordList.indexOf(temp.word);
            for(int i=0;i<wordDis[n].length;i++){
                if(wordDis[n][i]){
                    if(!temp.flag.containsKey(wordList.get(i))||temp.flag.get(wordList.get(i))==false){
                        queue.add(new levelWord(wordList.get(i),temp.level+1,new ArrayList<String>(temp.tempRes),new HashMap<String,Boolean>(temp.flag)));
                    }
                }
//                if(wordDis[n][i]&&!temp.flag.get(wordList.get(i))){
//                    queue.add(new levelWord(wordList.get(i),temp.level+1,new ArrayList<String>(temp.tempRes),new HashMap<String,Boolean>(temp.flag)));
//                    //flag.put(wordList.get(i),true);
//                }
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
    static class levelWord{
        public String word;
        public int level;
        public List<String> tempRes;
        public Map<String,Boolean> flag;
        public levelWord(String word,int level,List<String> tempRes,Map<String,Boolean> flag){
            this.word=word;
            this.level=level;
            tempRes.add(word);
            this.tempRes=tempRes;
            flag.put(word,true);
            this.flag=flag;
        }
    }
}
