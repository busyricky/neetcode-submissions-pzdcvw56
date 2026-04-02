class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int[] firstVals = new int[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            firstVals[i] = matrix[i][0];
        }

        int desiredRow = firstBinarySearch(firstVals, target);

        return secondBinarySearch(matrix, desiredRow, target);
    }

    private int firstBinarySearch(int[] firstVals, int target) {
        int left = 0, right = firstVals.length - 1;

        if (firstVals[left] == target) { return left; }
        if (firstVals[right] == target) { return right; }

        while (right - left > 1) {
            int mid = left + ((right - left) / 2);

            if (firstVals[mid] == target) {
                return mid;
            } else if (firstVals[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }

        // if (right - left == 1) {
        if (firstVals[right] <= target) {
            return right;
        } else {
            return left;
        }
    }

    private boolean secondBinarySearch(int[][] matrix, int desiredRow, int target) {
        int left = 0, right = matrix[desiredRow].length - 1;

        while (left <= right) {
            int mid = left + ((right - left) / 2);

            if (matrix[desiredRow][mid] == target) {
                return true;
            } else if (matrix[desiredRow][mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}
