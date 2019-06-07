import java.util.*;

public class main {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] wordList = {"hot","dot","dog","lot","log","cog"};
        List<String> wordList2= Arrays.asList(wordList);
        List<String> wordList3=new ArrayList<String>(wordList2);
        System.out.println(ladderLength(beginWord,endWord,wordList3));
    }
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return 0;
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
        int res=bfs(wordList,wordDis,flag,beginWord,endWord);
        return res;
    }
    public static int bfs(List<String> wordList,boolean[][] wordDis,Map<String,Boolean> flag,String beginWord,String endWord){
        Queue<levelWord> queue=new LinkedList<levelWord>();
        queue.add(new levelWord(beginWord,1));
        while(!queue.isEmpty()){
            levelWord temp=queue.poll();
            if(temp.word.equals(endWord)){
                return temp.level;
            }
            int n=wordList.indexOf(temp.word);
            for(int i=0;i<wordDis[n].length;i++){
                if(wordDis[n][i]&&!flag.get(wordList.get(i))){
                    queue.add(new levelWord(wordList.get(i),temp.level+1));
                    flag.put(wordList.get(i),true);
                }
            }
        }
        return 0;
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
        public levelWord(String word,int level){
            this.word=word;
            this.level=level;
        }
    }
}
