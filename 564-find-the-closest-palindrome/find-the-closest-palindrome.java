class Solution {
    public String nearestPalindromic(String n) {
        long num = Long.parseLong(n);
        int len = n.length();
        Set<Long> candidates = new HashSet<>();

        // Edge cases: 100...0 (like 1000) and 9...9 (like 999)
        candidates.add((long)Math.pow(10, len) + 1);
        candidates.add((long)Math.pow(10, len - 1) - 1);

        long prefix = Long.parseLong(n.substring(0, (len + 1) / 2));
        for (long i = -1; i <= 1; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(prefix + i);
            StringBuilder rev = new StringBuilder(sb);
            if (len % 2 == 1) rev.deleteCharAt(rev.length() - 1);
            String pal = sb.append(rev.reverse()).toString();
            try {
                candidates.add(Long.parseLong(pal));
            } catch (Exception e) {}
        }

        candidates.remove(num);

        long minDiff = Long.MAX_VALUE, ans = -1;
        for (long cand : candidates) {
            long diff = Math.abs(cand - num);
            if (diff < minDiff || (diff == minDiff && cand < ans)) {
                minDiff = diff;
                ans = cand;
            }
        }
        return String.valueOf(ans);
    }
}
