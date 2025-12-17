class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice,
                                 String arriveBob, String leaveBob) {

        int aliceStart = toDay(arriveAlice);
        int aliceEnd   = toDay(leaveAlice);
        int bobStart   = toDay(arriveBob);
        int bobEnd     = toDay(leaveBob);

        int start = Math.max(aliceStart, bobStart);
        int end   = Math.min(aliceEnd, bobEnd);

        return Math.max(0, end - start + 1);
    }

    private int toDay(String date) {
        int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};

        int month = Integer.parseInt(date.substring(0, 2));
        int day   = Integer.parseInt(date.substring(3));

        int total = 0;
        for (int i = 0; i < month - 1; i++) {
            total += days[i];
        }
        return total + day;
    }
}
