import java.util.Arrays;
import java.util.Comparator;

public class main {
    public static void main(String[] args) {
        int[][] ques={{1,3},{-2,2}};
        int[][] res=kClosest(ques,1);
        System.out.println(1);
    }
    public static int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                double o1Length=Math.pow(o1[0],2)+Math.pow(o1[1],2);
                double o2Length=Math.pow(o2[0],2)+Math.pow(o2[1],2);
                if(o1Length==o2Length){
                    return 0;
                }
                return o1Length<o2Length?-1:1;
            }
        });
        return Arrays.copyOf(points,K);
    }
}
