import java.util.*;

class Sort {
    class Mini {
        int value;
        Mini left, right;

        public Mini(int items) {
            value = items;
            left = right = null;
        }
    }

    Mini root;

    Sort() {
        root = null;
    }

    void add(int value) {
        root = insertVal(root, value);
    }

    Mini insertVal(Mini root, int value) {
        if (root == null) {
            root = new Mini(value);
            return root;
        }
        if (value < root.value)
            root.left = insertVal(root.left, value);
        else if (value > root.value)
            root.right = insertVal(root.right, value);
        return root;
    }

    void sortedValue(Mini root) {
        if (root != null) {
            sortedValue(root.left);
            System.out.print(root.value + " ");
            sortedValue(root.right);
        }
    }

    void trees(int array[]) {
        for (int i = 0; i < array.length; i++) {
            add(array[i]);
        }
    }

    public static void main(String[] args) {
        Sort tree = new Sort();
        int array[] = { 5, 6, 4, 8, 10, 22, 35, 46, 15, 52 };
        tree.trees(array);
        tree.sortedValue(tree.root);
    }
}
