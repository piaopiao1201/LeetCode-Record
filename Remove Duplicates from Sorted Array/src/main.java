public class main {
    public static void main(String[] args) {
        int nums[]={0,1,1,2};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int arrLength=nums.length;
        int curI=0;
        int sum=0;
        int lastNo=-1;
        int duplicateNum=0;
        while(curI<arrLength-duplicateNum){
            int tmpNo=nums[curI];
            if(sum==0||tmpNo!=lastNo){
                sum++;
                lastNo=tmpNo;
                curI++;
                continue;
            }else{
                remove(nums,curI,arrLength-duplicateNum);
                duplicateNum++;
                continue;
            }
        }
        return sum;
    }

    public static void remove(int[] nums,int index,int length){
        for(int i=index;i<length-1;i++){
            nums[i]=nums[i+1];
        }
    }
}
