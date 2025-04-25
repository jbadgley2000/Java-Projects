import java.util.*;
public class Subset {
    static void generateSubsets(int[] num, int position, List<Integer> current, List<List<Integer>> subsets) {
        subsets.add(new ArrayList<>(current));
        if(position == num.length){
            return;
        }
        for(int i = position; i < num.length; i++) {
            current.add(num[i]);
            generateSubsets(num, i + 1, current, subsets);
            current.remove(current.size() - 1);
        }
    }
    public static void main(String[] args) {
        int[] set = {1, 2, 3};
        List<List<Integer>> subsets = new ArrayList<>();
        generateSubsets(set, 0, new ArrayList<>(), subsets);
        System.out.println(subsets);
    }
}