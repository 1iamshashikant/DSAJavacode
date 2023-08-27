class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
          int totalAlice = 0;
        int totalBob = 0;
        
        for (int size : aliceSizes) {
            totalAlice += size;
        }
        
        for (int size : bobSizes) {
            totalBob += size;
        }
        
        int targetDifference = (totalAlice - totalBob) / 2;
        
        Arrays.sort(bobSizes);
        
        for (int aliceCandies : aliceSizes) {
            int searchValue = aliceCandies - targetDifference;
            int bobCandiesIndex = binarySearch(bobSizes, searchValue);
            if (bobCandiesIndex != -1) {
                return new int[]{aliceCandies, bobSizes[bobCandiesIndex]};
            }
        }
        
        return null; // No valid solution found
    }
    
    private int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1; // Target not fou
        
    }
}