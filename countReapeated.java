package geeks.searching;
// time complexity :O(N)
class countReapeated {
    // Pair Class
    static class Pair {
        long x;
        long y;

        Pair(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
    // Function to find repeated element and its frequency.
    public static Pair findRepeating(long arr[], int n) {
        int low = 0, high = n - 1;
        long repeatedElement = -1;
        // Binary search to find the repeated element
        while (low <= high) {
            int mid = low + (high - low) / 2;
            // Check if the element at mid does not follow the consecutive pattern
            if (arr[mid] != arr[0] + mid) {
                repeatedElement = arr[mid];
                high = mid - 1;  // Move to the left side to find the first occurrence
            } else {
                low = mid + 1;  // Move to the right side
            }
        }

        // If no repeated element is found, return (-1, -1)
        if (repeatedElement == -1) {
            return new Pair(-1, -1);
        }

        // Count the frequency of the repeated element
        long count = 0;
        for (long num : arr) {
            if (num == repeatedElement) {
                count++;
            }
        }

        return new Pair(repeatedElement, count);
    }
}