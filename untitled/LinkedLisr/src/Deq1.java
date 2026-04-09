public class Deq1 {

        private class Node {
            String data;
            Node next;
            Node(String data) { this.data = data; }
        }

        private Node head, tail;

        public void push_front(String value) {
            Node n = new Node(value);
            if (head == null) head = tail = n;
            else {
                n.next = head;
                head = n;
            }
        }

        public void push_back(String value) {
            Node n = new Node(value);
            if (head == null) head = tail = n;
            else {
                tail.next = n;
                tail = n;
            }
        }

        public void pop_front() {
            if (head == null) return;
            head = head.next;
            if (head == null) tail = null;
        }

        public void pop_back() {
            if (head == null) return;
            if (head == tail) { head = tail = null; return; }
            Node cur = head;
            while (cur.next != tail) cur = cur.next;
            cur.next = null;
            tail = cur;
        }

        public String front() { return head == null ? null : head.data; }
        public String back() { return tail == null ? null : tail.data; }

        public void insert(int index, String value) {
            if (index == 0) { push_front(value); return; }
            Node cur = head;
            for (int i = 0; cur != null && i < index - 1; i++) cur = cur.next;
            if (cur == null) return;
            Node n = new Node(value);
            n.next = cur.next;
            cur.next = n;
            if (n.next == null) tail = n;
        }

        public void remove(int index) {
            if (head == null) return;
            if (index == 0) { pop_front(); return; }
            Node cur = head;
            for (int i = 0; cur.next != null && i < index - 1; i++) cur = cur.next;
            if (cur.next == null) return;
            if (cur.next == tail) tail = cur;
            cur.next = cur.next.next;
        }

        public void print() {
            Node cur = head;
            while (cur != null) {
                System.out.print(cur.data + " ");
                cur = cur.next;
            }
            System.out.println();
        }

        public void longWords() {
            Node cur = head;
            while (cur != null) {
                if (cur.data.length() >= 4)
                    System.out.print(cur.data + " ");
                cur = cur.next;
            }
            System.out.println();
        }
    }
