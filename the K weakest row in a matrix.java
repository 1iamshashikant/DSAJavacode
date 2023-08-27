class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
         int[][] soldierCounts = new int[mat.length][2];
        
        // Calculate the number of soldiers in each row and store with indices
        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    count++;
                } else {
                    break;
                }
            }
            soldierCounts[i] = new int[] { count, i };
        }
        
        // Sort the array based on soldier counts and row indices
        Arrays.sort(soldierCounts, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);
                } else {
                    return Integer.compare(a[1], b[1]);
                }
            }
        });
        
        // Get the first k indices
        int[] weakestIndices = new int[k];
        for (int i = 0; i < k; i++) {
            weakestIndices[i] = soldierCounts[i][1];
        }
        
        return weakestIndices;
        
    }
}