public class Main {
    public static void main(String[] args) {

        class ListNode {
            int val;
            ListNode next;
            ListNode(int v) { val = v; }
        }

        java.util.function.IntUnaryOperator logN = new java.util.function.IntUnaryOperator() {
            public int applyAsInt(int n) {
                if (n <= 1) return 0;
                return 1 + this.applyAsInt(n / 2);
            }
        };

        java.util.function.Function<ListNode, ListNode> reverse = new java.util.function.Function<ListNode, ListNode>() {
            public ListNode apply(ListNode head) {
                if (head == null || head.next == null) return head;
                ListNode newHead = this.apply(head.next);
                head.next.next = head;
                head.next = null;
                return newHead;
            }
        };

        java.util.function.BiFunction<Integer, Integer, Integer> gcd =
                new java.util.function.BiFunction<Integer, Integer, Integer>() {
                    public Integer apply(Integer a, Integer b) {
                        if (b == 0) return a;
                        return this.apply(b, a % b);
                    }
                };

        int n = 16;
        System.out.println(logN.applyAsInt(n));

        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(3);
        a.next.next.next = new ListNode(4);

        a = reverse.apply(a);

        ListNode t = a;
        while (t != null) {
            System.out.print(t.val + " ");
            t = t.next;
        }
        System.out.println();

        int x = 48, y = 18;
        System.out.println(gcd.apply(x, y));
    }
}