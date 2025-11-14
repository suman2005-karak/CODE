class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] week = {"Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday"};

        int[] monthDays = {31,28,31,30,31,30,31,31,30,31,30,31};

        int days = 0;

        // Add days for full years from 1971 to year-1
        for (int y = 1971; y < year; y++) {
            days += isLeap(y) ? 366 : 365;
        }

        // Add days for months in current year
        for (int m = 1; m < month; m++) {
            if (m == 2 && isLeap(year)) {
                days += 29;
            } else {
                days += monthDays[m - 1];
            }
        }

        // Add days of current month
        days += day - 1;

        return week[days % 7];
    }

    private boolean isLeap(int y) {
        return (y % 400 == 0) || (y % 4 == 0 && y % 100 != 0);
    }
}
