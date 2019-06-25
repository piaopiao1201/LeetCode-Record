public class Main {
    public static void main(String[] args) {
        System.out.println(1);
    }
    public boolean isOneBitCharacter(int[] bits) {
        int start=0;
        while(start<bits.length){
            if(start==bits.length-1){
                return true;
            }
            if(bits[start]==0){
                start++;
                continue;
            }
            if(bits[start]==1){
                start+=2;
                continue;
            }
        }
        return false;
    }
}
