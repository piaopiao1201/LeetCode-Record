public class Main {
    public static void main(String[] args) {
        int[] nums={-1,-2,-3,0};
        int res=maxProduct(nums);
        System.out.println(res);
    }
    public static int maxProduct(int[] nums) {
        int[] dpZ = new int[nums.length];
        dpZ[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int temp = (dpZ[i - 1] == 0) ? 1 : dpZ[i - 1];
            dpZ[i] = nums[i] * temp;
        }
        int[] dpF = new int[nums.length];
        dpF[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            int temp = (dpF[i + 1] == 0) ? 1 : dpF[i + 1];
            dpF[i] = nums[i] * temp;
        }
        int maxZ = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            maxZ = Math.max(dpZ[i], maxZ);
        }
        int maxF = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            maxF = Math.max(dpF[i], maxF);
        }
        return Math.max(maxZ, maxF);
    }
}
