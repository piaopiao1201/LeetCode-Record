import java.util.*;

public class Main {
    int[] memory=new int[60];
    public static void main(String[] args) {
        int res=integerBreak(58);
        Set<List<Integer>> set=new HashSet<>();
        List<Integer> list1=new ArrayList<>();
        list1.add(1);
        list1.add(2);
        List<Integer> list2=new ArrayList<>();
        list2.add(2);
        list2.add(1);
        set.add(list1);
        set.add(list2);
        System.out.println(1);
    }
    public static int integerBreak(int n) {
        if(n==2){
            return 1;
        }
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        List<Integer> product=new ArrayList<>();
        List<Integer> start=new ArrayList<>();
        start.add(1);
        start.add(1);
        product.add(1);
        res.add(start);
        int maxProduct=0;
        for(int i=3;i<=n;i++){
            if(i==25){
                System.out.println(1);
            }
            //List<List<Integer>> tempRes=new ArrayList<List<Integer>>();
            Set<List<Integer>> set=new LinkedHashSet<>();
            List<Integer> product2=new ArrayList<>();
            int tempProduct=0;
            int size=res.size();
            for(int j=0;j<size;j++){
                for(int k=0;k<res.get(j).size();k++){
                    int temp=product.get(j)/res.get(j).get(k)*(res.get(j).get(k)+1);
                    tempProduct=Math.max(tempProduct,temp);
                    List<Integer> tempList=new ArrayList<>(res.get(j));
                    tempList.set(k,tempList.get(k)+1);
                    tempList.sort(new Comparator<Integer>() {
                        @Override
                        public int compare(Integer o1, Integer o2) {
                            return o1.compareTo(o2);
                        }
                    });
                    int s1=set.size();
                    set.add(tempList);
                    if(set.size()!=s1){
                        product2.add(temp);
                    }
                }
                List<Integer> tempList2=new ArrayList<>(res.get(j));
                tempList2.add(1);
                set.add(tempList2);
                product2.add(product.get(j));
            }
            maxProduct=Math.max(maxProduct,tempProduct);
            res=new ArrayList<>(set);
            product=product2;
        }
        return maxProduct;
    }
    public int integerBreak2(int n) {
        if (n == 2) {
            return 1;
        }
        if(memory[n]!=0){
            return memory[n];
        }
        int res = 0;
        for (int i = 1; i <= n - 1; i++) {
            res = Math.max(res, Math.max(i * (n - i), i * integerBreak(n - i)));
        }
        memory[n]=res;
        return res;
    }
}
