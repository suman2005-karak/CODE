import java.util.*;

class MovieRentingSystem {
    private static class MovieEntry {
        int shop, movie, price;
        MovieEntry(int shop, int movie, int price) {
            this.shop = shop;
            this.movie = movie;
            this.price = price;
        }
    }

    // Comparator for unrented (per movie)
    private Comparator<MovieEntry> movieComparator = (a, b) -> {
        if (a.price != b.price) return a.price - b.price;
        return a.shop - b.shop;
    };

    // Comparator for rented (global)
    private Comparator<MovieEntry> rentedComparator = (a, b) -> {
        if (a.price != b.price) return a.price - b.price;
        if (a.shop != b.shop) return a.shop - b.shop;
        return a.movie - b.movie;
    };

    private Map<Integer, TreeSet<MovieEntry>> available; // movie -> available shops
    private TreeSet<MovieEntry> rented;                  // all rented movies
    private Map<String, MovieEntry> entryMap;            // (shop,movie) -> entry

    public MovieRentingSystem(int n, int[][] entries) {
        available = new HashMap<>();
        rented = new TreeSet<>(rentedComparator);
        entryMap = new HashMap<>();

        for (int[] e : entries) {
            int shop = e[0], movie = e[1], price = e[2];
            MovieEntry entry = new MovieEntry(shop, movie, price);

            available.putIfAbsent(movie, new TreeSet<>(movieComparator));
            available.get(movie).add(entry);

            entryMap.put(shop + "," + movie, entry);
        }
    }

    public List<Integer> search(int movie) {
        List<Integer> result = new ArrayList<>();
        if (!available.containsKey(movie)) return result;

        Iterator<MovieEntry> it = available.get(movie).iterator();
        int count = 0;
        while (it.hasNext() && count < 5) {
            result.add(it.next().shop);
            count++;
        }
        return result;
    }

    public void rent(int shop, int movie) {
        String key = shop + "," + movie;
        MovieEntry entry = entryMap.get(key);

        available.get(movie).remove(entry);
        rented.add(entry);
    }

    public void drop(int shop, int movie) {
        String key = shop + "," + movie;
        MovieEntry entry = entryMap.get(key);

        rented.remove(entry);
        available.get(movie).add(entry);
    }

    public List<List<Integer>> report() {
        List<List<Integer>> result = new ArrayList<>();
        Iterator<MovieEntry> it = rented.iterator();
        int count = 0;
        while (it.hasNext() && count < 5) {
            MovieEntry e = it.next();
            result.add(Arrays.asList(e.shop, e.movie));
            count++;
        }
        return result;
    }
}
