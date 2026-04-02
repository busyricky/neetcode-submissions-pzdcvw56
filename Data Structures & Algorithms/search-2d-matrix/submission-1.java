class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int desiredRow = firstBinarySearch(matrix, target);

        return secondBinarySearch(matrix, desiredRow, target);
    }

    private int firstBinarySearch(int[][] matrix, int target) {
        int left = 0, right = matrix.length - 1;

        if (matrix[left][0] == target) { return left; }
        if (matrix[right][0] == target) { return right; }

        while (right - left > 1) {
            int mid = left + ((right - left) / 2);

            if (matrix[mid][0] == target) {
                return mid;
            } else if (matrix[mid][0] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }

        // if (right - left == 1) {
        if (matrix[right][0] <= target) {
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
