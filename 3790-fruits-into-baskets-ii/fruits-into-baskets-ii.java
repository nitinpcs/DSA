class Solution {
    public int numOfUnplacedFruits(int[] arr, int[] nums) {
        int c=arr.length;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<nums.length;j++){
                if(arr[i]<=nums[j]){
                    nums[j]=-1;
                    c--;
                    break;
                }
            }
        }
        return c;
    }
}