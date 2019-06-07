import java.util.*;

public class Main {
    public static void main(String[] args) {

    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> resMap = new LinkedHashMap<String, List<String>>();
        for (int i = 0; i < strs.length; i++) {
            String biaoqian = outZi(strs[i]);
            if (resMap.containsKey(biaoqian)) {
                resMap.get(biaoqian).add(strs[i]);
            } else {
                resMap.put(biaoqian,new ArrayList<String>());
                resMap.get(biaoqian).add(strs[i]);
            }
        }
        List<List<String>> res=new ArrayList<List<String>>();
        for(String key:resMap.keySet()){
            res.add(resMap.get(key));
        }
        return res;
    }
    public static String outZi (String ques){
        char[] quesArr = ques.toCharArray();
        List<Character> listArr = new ArrayList<Character>();
        for (Character c : quesArr) {
            listArr.add(c);
        }
        Collections.sort(listArr, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return o1.compareTo(o2);
            }
        });
        String res = "";
        for (Character c : listArr) {
            res += c;
        }
        return res;
    }
}
