import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        int[] nums={1,2,3};
        Solution solution=new Solution(nums);
        int[] temp=solution.shuffle();
        int[] temp2=solution.shuffle();
        int[] temp3=solution.shuffle();
        int[] temp4=solution.shuffle();
        int[] temp5=solution.shuffle();
        int[] origin=solution.reset();
        System.out.println(1);
    }
}
