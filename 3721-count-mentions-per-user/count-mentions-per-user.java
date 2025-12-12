class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {

        int[] mentions = new int[numberOfUsers];
        int[] offlineUntil = new int[numberOfUsers];
        boolean[] online = new boolean[numberOfUsers];
        Arrays.fill(online, true);

        // group events by timestamp
        TreeMap<Integer, List<List<String>>> map = new TreeMap<>();

        for (List<String> e : events) {
            int t = Integer.parseInt(e.get(1));
            map.computeIfAbsent(t, k -> new ArrayList<>()).add(e);
        }

        for (int t : map.keySet()) {

            // restore users that should come online at time t
            for (int u = 0; u < numberOfUsers; u++) {
                if (!online[u] && offlineUntil[u] <= t) {
                    online[u] = true;
                }
            }

            List<List<String>> evs = map.get(t);

            // 1️⃣ Process all OFFLINE events first
            for (List<String> e : evs) {
                if (e.get(0).equals("OFFLINE")) {
                    int user = Integer.parseInt(e.get(2));
                    online[user] = false;
                    offlineUntil[user] = t + 60;
                }
            }

            // 2️⃣ Process all MESSAGE events next
            for (List<String> e : evs) {
                if (e.get(0).equals("MESSAGE")) {
                    String msg = e.get(2);

                    if (msg.equals("ALL")) {
                        for (int u = 0; u < numberOfUsers; u++) {
                            mentions[u]++;
                        }
                    } 
                    else if (msg.equals("HERE")) {
                        for (int u = 0; u < numberOfUsers; u++) {
                            if (online[u]) mentions[u]++;
                        }
                    } 
                    else {
                        String[] tokens = msg.split(" ");
                        for (String token : tokens) {
                            if (token.startsWith("id")) {
                                int user = Integer.parseInt(token.substring(2));
                                mentions[user]++;
                            }
                        }
                    }
                }
            }
        }

        return mentions;
    }
}
