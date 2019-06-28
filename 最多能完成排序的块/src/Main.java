public class Main {
    public static void main(String[] args) {
        System.out.println(1);
    }
    public int maxChunksToSorted(int[] arr) {
        int cnt=0;
        int maxValue=0;
        for(int i=0;i<arr.length;i++){
            maxValue=Math.max(maxValue,arr[i]);
            if(maxValue<=i){
                cnt++;
            }
        }
        return cnt;
    }
}
