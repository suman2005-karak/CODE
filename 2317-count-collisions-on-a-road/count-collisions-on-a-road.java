class Solution {
    public int countCollisions(String directions) {
        int n = directions.length();
        char[] arr = directions.toCharArray();

        int left = 0, right = n - 1;

        // Remove leading L cars (they move away forever)
        while (left < n && arr[left] == 'L') left++;

        // Remove trailing R cars (they also move away)
        while (right >= 0 && arr[right] == 'R') right--;

        int collisions = 0;

        // In the remaining middle segment, every R or L causes a collision
        for (int i = left; i <= right; i++) {
            if (arr[i] != 'S') collisions++;
        }
        
        return collisions;
    }
}
