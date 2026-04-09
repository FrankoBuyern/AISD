public class Main {
    public static void main(String[] args) {

        class ListNode {
            int val;
            ListNode next;
            ListNode(int v) { val = v; }
        }

        java.util.function.Function<ListNode, ListNode> deleteDuplicates = (head) -> {
            ListNode cur = head;
            while (cur != null && cur.next != null) {
                if (cur.val == cur.next.val) cur.next = cur.next.next;
                else cur = cur.next;
            }
            return head;
        };

        java.util.function.Function<ListNode, ListNode> swapPairs = (head) -> {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode prev = dummy;

            while (prev.next != null && prev.next.next != null) {
                ListNode a = prev.next;
                ListNode b = a.next;

                a.next = b.next;
                b.next = a;
                prev.next = b;

                prev = a;
            }
            return dummy.next;
        };

        java.util.function.Function<ListNode, ListNode> detectCycle = (head) -> {
            ListNode slow = head, fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;

                if (slow == fast) {
                    ListNode start = head;
                    while (start != slow) {
                        start = start.next;
                        slow = slow.next;
                    }
                    return start;
                }
            }
            return null;
        };

        java.util.function.Function<int[], int[]> nearestSmaller = (A) -> {
            int n = A.length;
            int[] res = new int[n];
            java.util.Stack<Integer> stack = new java.util.Stack<>();

            for (int i = 0; i < n; i++) {
                while (!stack.isEmpty() && stack.peek() >= A[i]) {
                    stack.pop();
                }
                res[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(A[i]);
            }
            return res;
        };

        ListNode a = new ListNode(1);
        a.next = new ListNode(1);
        a.next.next = new ListNode(2);
        a = deleteDuplicates.apply(a);

        ListNode b = new ListNode(1);
        b.next = new ListNode(2);
        b.next.next = new ListNode(3);
        b.next.next.next = new ListNode(4);
        b = swapPairs.apply(b);

        ListNode c = new ListNode(1);
        c.next = new ListNode(2);
        c.next.next = new ListNode(3);
        c.next.next.next = new ListNode(4);
        c.next.next.next.next = c.next.next;
        ListNode cycle = detectCycle.apply(c);

        int[] arr = {4, 5, 2, 10, 8};
        int[] res = nearestSmaller.apply(arr);

        ListNode t = a;
        while (t != null) {
            System.out.print(t.val + " ");
            t = t.next;
        }
        System.out.println();

        t = b;
        while (t != null) {
            System.out.print(t.val + " ");
            t = t.next;
        }
        System.out.println();

        System.out.println(cycle != null ? cycle.val : "null");

        for (int x : res) System.out.print(x + " ");
    }
}