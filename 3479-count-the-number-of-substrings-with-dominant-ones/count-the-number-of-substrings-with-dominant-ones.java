class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int[] pref0 = new int[n];
        int[] pref1 = new int[n];

        pref0[0] = s.charAt(0) == '0' ? 1 : 0;
        pref1[0] = s.charAt(0) == '1' ? 1 : 0;

        for (int i = 1; i < n; i++) {
            pref0[i] = pref0[i - 1] + (s.charAt(i) == '0' ? 1 : 0);
            pref1[i] = pref1[i - 1] + (s.charAt(i) == '1' ? 1 : 0);
        }

        long ans = 0;

        for (int left = 0; left < n; left++) {
            int j = left;

            while (j < n) {
                int zeros = pref0[j] - (left > 0 ? pref0[left - 1] : 0);
                int ones  = pref1[j] - (left > 0 ? pref1[left - 1] : 0);

                if (ones >= zeros * zeros) {
                    // count how many further j positions are valid
                    int step = Math.max((int)Math.sqrt(ones) - zeros, 1);
                    ans += Math.min(step, n - j);
                    j += step;
                } else {
                    // increase j faster to avoid TLE
                    int need = zeros * zeros - ones;
                    j += Math.max(1, need);
                }
            }
        }
        return (int) ans;
    }
}
