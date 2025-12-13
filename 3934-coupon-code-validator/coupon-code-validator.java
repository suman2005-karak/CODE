import java.util.*;

class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {

        // Required business line order
        List<String> order = Arrays.asList(
                "electronics", "grocery", "pharmacy", "restaurant"
        );

        // Map to store valid coupons by business line
        Map<String, List<String>> map = new HashMap<>();
        for (String b : order) {
            map.put(b, new ArrayList<>());
        }

        for (int i = 0; i < code.length; i++) {

            // Condition 1: coupon must be active
            if (!isActive[i]) continue;

            // Condition 2: valid business line
            if (!map.containsKey(businessLine[i])) continue;

            // Condition 3: valid code
            if (code[i].isEmpty()) continue;
            if (!code[i].matches("[a-zA-Z0-9_]+")) continue;

            map.get(businessLine[i]).add(code[i]);
        }

        // Prepare result
        List<String> result = new ArrayList<>();

        // Sort and add in required business line order
        for (String b : order) {
            List<String> list = map.get(b);
            Collections.sort(list);
            result.addAll(list);
        }

        return result;
    }
}
