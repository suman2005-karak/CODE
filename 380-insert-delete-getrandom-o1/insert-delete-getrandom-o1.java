import java.util.*;

class RandomizedSet {

    private ArrayList<Integer> list;
    private HashMap<Integer, Integer> map;
    private Random rand;

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }

        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        int index = map.get(val);
        int lastElement = list.get(list.size() - 1);

        // Move last element to removed position
        list.set(index, lastElement);
        map.put(lastElement, index);

        // Remove last element
        list.remove(list.size() - 1);
        map.remove(val);

        return true;
    }

    public int getRandom() {
        int randomIndex = rand.nextInt(list.size());
        return list.get(randomIndex);
    }
}
