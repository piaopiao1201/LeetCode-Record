public class Main {
    public static void main(String[] args) {

    }
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n==0){
            return true;
        }
        if(flowerbed.length==1){
            if(flowerbed[0]==0){
                return n<=1?true:false;
            }else{
                return false;
            }
        }
        int origin1=0;
        int sum=0;
        for(int i=0;i<flowerbed.length;i++){
            if(flowerbed[i]==1){
                origin1++;
                continue;
            }
            if(i==0){
                if(flowerbed[i+1]!=1){
                    sum++;
                    flowerbed[i]=1;
                }
                continue;
            }
            if(i==flowerbed.length-1){
                if(flowerbed[i-1]!=1){
                    sum++;
                    flowerbed[i]=1;
                }
                continue;
            }
            if(flowerbed[i+1]!=1&&flowerbed[i-1]!=1){
                sum++;
                flowerbed[i]=1;
            }
        }
        return sum>=n?true:false;
    }
}
