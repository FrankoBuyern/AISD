public class Deq2withouttail {

        private class Node {
            String data;
            Node next, prev;
            Node(String data) { this.data = data; }
        }

        private Node head;

        public void push_front(String value) {
            Node n = new Node(value);
            if (head != null) {
                n.next = head;
                head.prev = n;
            }
            head = n;
        }

        public void push_back(String value) {
            Node n = new Node(value);
            if (head == null) { head = n; return; }
            Node cur = head;
            while (cur.next != null) cur = cur.next;
            cur.next = n;
            n.prev = cur;
        }

        public void pop_front() {
            if (head == null) return;
            head = head.next;
            if (head != null) head.prev = null;
        }

        public void pop_back() {
            if (head == null) return;
            if (head.next == null) { head = null; return; }
            Node cur = head;
            while (cur.next != null) cur = cur.next;
            cur.prev.next = null;
        }

        public String front() { return head == null ? null : head.data; }

        public String back() {
            if (head == null) return null;
            Node cur = head;
            while (cur.next != null) cur = cur.next;
            return cur.data;
        }

        public void insert(int index, String value) {
            if (index == 0) { push_front(value); return; }
            Node cur = head;
            for (int i = 0; cur != null && i < index; i++) cur = cur.next;
            if (cur == null) { push_back(value); return; }
            Node n = new Node(value);
            Node p = cur.prev;
            p.next = n;
            n.prev = p;
            n.next = cur;
            cur.prev = n;
        }

        public void remove(int index) {
            if (head == null) return;
            if (index == 0) { pop_front(); return; }
            Node cur = head;
            for (int i = 0; cur != null && i < index; i++) cur = cur.next;
            if (cur == null) return;
            if (cur.next == null) { pop_back(); return; }
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
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
