import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        Tries tries=new Tries();
        String strs[]={"abc","abd","b","abdc","abdc"};

        for(int i=0;i<strs.length;i++)
            tries.insert(strs[i]);
        int res=tries.countWords("abdc");
        int res2=tries.countStartWith("abd");
        System.out.println(1);
    }
//    public static boolean insertNode(String str,Tries head)
//    {
//        if(str==null||str.length()==0)
//            return false;
//        char chs[]=str.toCharArray();
//        int i=0;
//        Tries cur=head;
//        while(i<chs.length)
//        {
//            if(!cur.children.containsKey(chs[i]))
//            {
//
//                cur.children.put(chs[i], new Tries());
//            }
//            cur=cur.children.get(chs[i]);
//            if(cur.isTrie==true)
//            {
//                System.out.println(" trie tree");
//                return true;
//            }
//            i++;
//        }
//        cur.isTrie=true;
//        if(cur.children.size()>0)
//        {
//            System.out.println(" trie tree");
//            return true;
//        }
//        return false;
//    }
}