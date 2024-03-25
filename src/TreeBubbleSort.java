import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TreeBubbleSort {
    public static TreeNode insertIntoTree(TreeNode root, int value) {
        if (root == null) {
            return new TreeNode(value);
        }

        if (value == root.value) {
            root.count++;
        } else if (value < root.value) {
            root.left = insertIntoTree(root.left, value);
        } else {
            root.right = insertIntoTree(root.right, value);
        }

        return root;
    }

    public static List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            result.addAll(inOrderTraversal(root.left));
            for (int i = 0; i < root.count; i++) {
                result.add(root.value);
            }
            result.addAll(inOrderTraversal(root.right));
        }
        return result;
    }

    public static List<Integer> treeSort(List<Integer> numbers) {
        TreeNode root = null;
        for (int number : numbers) {
            root = insertIntoTree(root, number);
        }

        return inOrderTraversal(root);
    }

    public static List<Integer> bubbleSort(List<Integer> numbers) {
        int n = numbers.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (numbers.get(j) > numbers.get(j + 1)) {
                    Collections.swap(numbers, j, j + 1);
                }
            }
        }
        return numbers;
    }
}
