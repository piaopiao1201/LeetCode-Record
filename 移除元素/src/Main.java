public class Main {
    public static void main(String[] args) {
        int[] nums={3,2,2,3};
        int res=removeElement(nums,3);
        System.out.println(1);
    }
    public static int removeElement(int[] nums, int val) {
        int maxLength=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==val){
                int res=findNext(nums,i,val);
                if(res!=-1){
                    int temp=nums[i];
                    nums[i]=nums[res];
                    nums[res]=temp;
                    maxLength=i+1;
                }else{
                    break;
                }
            }else{
                maxLength=i+1;
            }
        }
        return maxLength;
    }
    public static int findNext(int[] nums,int index,int val){
        for(int i=index+1;i<nums.length;i++){
            if(nums[i]!=val){
                return i;
            }
        }
        return -1;
    }
}
