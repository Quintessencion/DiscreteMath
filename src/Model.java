import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Model {
    //Fields
    private List<Set<Integer>> setOfSets;
    private Set<Integer> setResult;

    //Constructor
    public Model() {
        setOfSets = new ArrayList<>();
        setResult = new TreeSet<>();
    }

    //Functions
    public void addSet(String... split) throws NumberFormatException {
        Set<Integer> listSet = new TreeSet<>();
        for (String s : split) {
            listSet.add(Integer.parseInt(s));
        }
        setOfSets.add(listSet);
    }

    public String crossSets() {
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


    public void printSets() {
        for (Set<Integer> s : setOfSets) {
            for (Integer i : s) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void clearSets() {
        setResult.clear();
        setOfSets.clear();
    }
}


