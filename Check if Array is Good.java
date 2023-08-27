class Solution {
    public boolean isGood(int[] nums) {
            int pos = 0,max = 0;
        boolean x = false;
        for(int i = 0;i < nums.length; i++){
            if(nums[i]>max){
                max = nums[i];
                pos = i;
            }
        }
        if(max+1 != nums.length) return false;

        boolean case1 = Maxcount(max , nums, pos);
        if(case1 == false) return false;
         boolean case2 = Others(max , nums);
        if(case2 == false) return false;
        return true;
    }
    static boolean Others(int max , int[] arr){
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!= max){
                for (int j = 0; j < arr.length; j++) {
                    if (i!=j&&arr[i] == arr[j]) return false;
                }
            }
        }
        return true;
    }
    static boolean Maxcount(int max , int[] arr , int pos){
        int count = 1;
        for (int i = 0; i < arr.length; i++) {
            if(i!= pos && arr[i] == max){
                count++;
            }
        }
        return count == 2;

    }
    }
        