class Solution {
    public int dayOfYear(String date) {
        // Split the date into components
        String[] parts = date.split("-");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);

        // Days in each month (non-leap year)
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // Check for leap year
        if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
            days[1] = 29; // February = 29 days
        }

        int result = day;
        for (int i = 0; i < month - 1; i++) {
            result += days[i];
        }

        return result;
    }
}
