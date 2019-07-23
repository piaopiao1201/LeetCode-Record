import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    int path;
    int end;
    Map<Character,TrieNode> children=new HashMap<>();
    public TrieNode(){
        path=0;
        end=0;
    }
}
