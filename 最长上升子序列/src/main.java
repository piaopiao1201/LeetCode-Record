public class main {
    public static void main(String[] args) {
        Double a=1.0;

        System.out.println(1==1.2);
        int[] nums={1,3,6,7,9,4,10,5,6};
        System.out.println(lengthOfLIS(nums));
    }
    public static int lengthOfLIS(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int[] res=new int[nums.length];
        res[0]=1;
        for(int i=1;i<nums.length;i++){
            int j=i-1;
            int max=0;
            for(;j>=0;j--){
                if(nums[j]<nums[i]){
                    max=Math.max(res[j],max);
                }
            }
            res[i]=max+1;
        }

        int max=-1;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,res[i]);
        }
        return max;
    }
}
