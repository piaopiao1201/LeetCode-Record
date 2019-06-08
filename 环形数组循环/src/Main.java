public class Main {
    public static void main(String[] args) {
        int[] arr={-2,1,-1,-2,-2};
        boolean res=circularArrayLoop(arr);
        System.out.println(1);
    }
    public static boolean circularArrayLoop(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int start=i;
            boolean[] flag=new boolean[nums.length];
            flag[start]=true;
            while (true){
                int next=nextIndex(nums,start);
                if(next==-1){
                    break;
                }
                if(flag[next]){
                    if(next!=start){
                        return true;
                    }else{
                        break;
                    }
                }
                flag[next]=true;
                start=next;
            }

        }
        return false;
    }
    public static int nextIndex(int[] nums,int nowIndex){
        int temp=nowIndex+nums[nowIndex];
        while (temp<0){
            temp+=nums.length;
        }
        int nextIndex=temp%nums.length;
        return nums[nowIndex]*nums[nextIndex]<0?-1:nextIndex;
    }
}
