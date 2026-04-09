import java.util.*;

public class BinarySearchTree {

    Node root;

    // ================= INSERT =================
    public void insert(int key, String value) {
        root = insertRec(root, key, value);
    }

    private Node insertRec(Node node, int key, String value) {
        if (node == null) {
            return new Node(key, value);
        }

        if (key < node.key) {
            node.left = insertRec(node.left, key, value);
        } else if (key > node.key) {
            node.right = insertRec(node.right, key, value);
        } else {
            node.value = value; // замена
        }

        return node;
    }

    // ================= FIND =================
    public Node find(int key) {
        return findRec(root, key);
    }

    private Node findRec(Node node, int key) {
        if (node == null) return null;

        if (key == node.key) return node;

        if (key < node.key)
            return findRec(node.left, key);
        else
            return findRec(node.right, key);
    }

    // ================= REMOVE =================
    public void remove(int key) {
        root = removeRec(root, key);
    }

    private Node removeRec(Node node, int key) {
        if (node == null) return null;

        if (key < node.key) {
            node.left = removeRec(node.left, key);
        } else if (key > node.key) {
            node.right = removeRec(node.right, key);
        } else {
            // найден узел

            // 1. нет детей
            if (node.left == null && node.right == null) {
                return null;
            }

            // 2. один ребёнок
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            // 3. два ребёнка
            Node min = findMin(node.right);

            node.key = min.key;
            node.value = min.value;

            node.right = removeRec(node.right, min.key);
        }

        return node;
    }

    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // ================= BFS (без рекурсии) =================
    public void bfs() {
        if (root == null) return;

        List<Node> list = new ArrayList<>();
        list.add(root);

        int i = 0;

        while (i < list.size()) {
            Node current = list.get(i);
            System.out.print(current.key + " ");

            if (current.left != null) list.add(current.left);
            if (current.right != null) list.add(current.right);

            i++;
        }
        System.out.println();
    }

    // ================= DFS =================

    // inorder (INFIX)
    public void inorder() {
        inorderRec(root);
        System.out.println();
    }

    private void inorderRec(Node node) {
        if (node == null) return;

        inorderRec(node.left);
        System.out.print(node.key + " ");
        inorderRec(node.right);
    }

    // preorder (PREFIX)
    public void preorder() {
        preorderRec(root);
        System.out.println();
    }

    private void preorderRec(Node node) {
        if (node == null) return;

        System.out.print(node.key + " ");
        preorderRec(node.left);
        preorderRec(node.right);
    }

    // postorder (POSTFIX)
    public void postorder() {
        postorderRec(root);
        System.out.println();
    }

    private void postorderRec(Node node) {
        if (node == null) return;

        postorderRec(node.left);
        postorderRec(node.right);
        System.out.print(node.key + " ");
    }

    // ================= 6. Кол-во потомков =================
    public int countDescendants(Node node) {
        if (node == null) return 0;

        int left = countDescendants(node.left);
        int right = countDescendants(node.right);

        node.descendantsCount = left + right;
        return node.descendantsCount + 1;
    }

    // ================= 7. Сумма ключей =================
    public int computeSum(Node node) {
        if (node == null) return 0;

        int left = computeSum(node.left);
        int right = computeSum(node.right);

        node.subtreeSum = node.key + left + right;
        return node.subtreeSum;
    }

    // ================= 8. Высота =================
    public int computeHeight(Node node) {
        if (node == null) return -1;

        int left = computeHeight(node.left);
        int right = computeHeight(node.right);

        node.height = Math.max(left, right) + 1;
        return node.height;
    }
}