import sun.text.normalizer.Trie;

import java.util.HashMap;

//初级版 isTrie标识单词是否在该点结尾
//public class Tries {
//    boolean isTrie;
//    HashMap<Character, Tries> children=new HashMap<Character, Tries>();
//}

public class Tries{
    TrieNode root;
    public Tries(){
        root=new TrieNode();
    }
    public void insert(String words){
        if(words==null){
            return;
        }
        TrieNode cur=root;
        char[] chars=words.toCharArray();
        for(char c:chars){
            if(!cur.children.containsKey(c)){
                cur.children.put(c,new TrieNode());
            }
            cur=cur.children.get(c);
            cur.path++;
        }
        cur.end++;
    }

    public boolean search(String words){
        if(words==null){
            return false;
        }
        TrieNode cur=root;
        char[] chars=words.toCharArray();
        for(char c:chars){
            if(!cur.children.containsKey(c)){
                cur.children.put(c,new TrieNode());
            }
            cur=cur.children.get(c);
        }
        return cur.end>0?true:false;
    }

    public boolean startWith(String prefix){
        if (prefix == null) return false;
        char[] chars = prefix.toCharArray();
        TrieNode cur=root;
        for(char c:chars){
            if(!cur.children.containsKey(c)){
                return false;
            }
            cur=cur.children.get(c);
        }
        return true;
    }

    public int countStartWith(String prefix) {
        if (prefix == null) return 0;
        char[] chars = prefix.toCharArray();
        TrieNode cur = root;
        for (char c : chars) {
            if (!cur.children.containsKey(c)) {
                return 0;
            }
            cur = cur.children.get(c);
        }
        return cur.path;
    }
    public int countWords(String words){
        if(words==null){
            return 0;
        }
        TrieNode cur=root;
        char[] chars=words.toCharArray();
        for(char c:chars){
            if(!cur.children.containsKey(c)){
                return 0;
            }
            cur=cur.children.get(c);
        }
        return cur.end;
    }
}