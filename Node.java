public class Node {
    int key;
    String value;

    Node left;
    Node right;

    // дополнительные поля
    int descendantsCount; // количество потомков
    int subtreeSum;       // сумма ключей
    int height;           // высота

    public Node(int key, String value) {
        this.key = key;
        this.value = value;
    }
}