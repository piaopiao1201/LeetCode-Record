public class main {
    public static void main(String[] args) {
        int[] nums={3,1};
        System.out.println(search(nums,0));
    }

    public static int search(int[] nums, int target) {
        int left=0,right=nums.length-1;
        int mid=(left+right)/2;
        while(left<=right){
            mid=(left+right)/2;
            if(left==right&&nums[mid]!=target){
                return -1;
            }
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]<nums[right]){
                if(nums[mid]<target&&target<=nums[right]){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }else{
                if(nums[mid]>target&&target>=nums[left]){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }
        }
        return -1;
    }
}
