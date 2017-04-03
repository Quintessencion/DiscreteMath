import java.util.*;

class Model {
    //Fields
    private List<Set<Integer>> setOfSets;
    private Set<Integer> setResult;

    //Constructor
    Model() {
        setOfSets = new ArrayList<>();
        setResult = new TreeSet<>();
    }

    //Functions
    void addSet(String... split) throws NumberFormatException {
        Set<Integer> listSet = new TreeSet<>();
        for (String s : split) {
            listSet.add(Integer.parseInt(s));
        }
        setOfSets.add(listSet);
    }

    String crossSets() {
        setResult.clear();

        if (setOfSets.size() != 0) {
            setResult.addAll(setOfSets.get(0));
            for (int i = 1; i < setOfSets.size(); i++) {
                setResult.retainAll(setOfSets.get(i));
            }
        }

        setOfSets.clear();
        String result = setResult.toString().substring(1, setResult.toString().length() - 1);
        return result.length() == 0 ? "Пустое множество" : result;
    }

    void clearSets() {
        setResult.clear();
        setOfSets.clear();
    }

    String findX(int x) {
        if (setResult.size() == 0) return "";
        if (setResult.contains(x)) return String.valueOf(x);

        List<Integer> list = new ArrayList<>(setResult);
        if (x < list.get(0)) return String.valueOf(list.get(0));
        int pre;
        int next;

        for (int i = 0; i < list.size(); i++) {
            pre = list.get(i);

            try {
                next = list.get(i + 1);
            } catch (IndexOutOfBoundsException e) {
                return String.valueOf(list.get(i));
            }

            if (x > pre && x < next) {
                return String.valueOf((x - pre) > (next - x) ? next : pre);
            }
        }
        return "";
    }
}


