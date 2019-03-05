import java.util.*;

import static java.util.Collections.sort;

public class Problems {

    private static void findMedian(BinarySearchTree<Integer> outputTree, List<Integer> values, Integer start, Integer end){
        if(end<=start) return;

        Integer medIndex = (end + start) / 2;

        outputTree.add(values.get(medIndex));

        findMedian(outputTree, values,start,medIndex);
        findMedian(outputTree, values,medIndex+1,end);
    }


    public static BinarySearchTree<Integer> minimalHeight(List<Integer> values) {
        BinarySearchTree<Integer> outputTree = new BinarySearchTree<>();
        if(values.size()==0) return outputTree;
        sort(values);
        Integer start = 0;
        Integer end = values.size();

        findMedian(outputTree, values,start, end);
        return outputTree;
    }

    public static boolean isIsomorphic(TreeNode n1, TreeNode n2) {
        // TODO
        return false;
    }
}
