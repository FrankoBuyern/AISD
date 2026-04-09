public class Massive {

        private String[] data = new String[2];
        private int size = 0;

        private void resize() {
            String[] newArr = new String[data.length * 2];
            System.arraycopy(data, 0, newArr, 0, size);
            data = newArr;
        }

        public void push_front(String value) {
            if (size == data.length) resize();
            for (int i = size; i > 0; i--) data[i] = data[i - 1];
            data[0] = value;
            size++;
        }

        public void push_back(String value) {
            if (size == data.length) resize();
            data[size++] = value;
        }

        public void pop_front() {
            if (size == 0) return;
            for (int i = 0; i < size - 1; i++) data[i] = data[i + 1];
            size--;
        }

        public void pop_back() {
            if (size == 0) return;
            size--;
        }

        public String front() { return size == 0 ? null : data[0]; }
        public String back() { return size == 0 ? null : data[size - 1]; }

        public void insert(int index, String value) {
            if (index < 0 || index > size) return;
            if (size == data.length) resize();
            for (int i = size; i > index; i--) data[i] = data[i - 1];
            data[index] = value;
            size++;
        }

        public void remove(int index) {
            if (index < 0 || index >= size) return;
            for (int i = index; i < size - 1; i++) data[i] = data[i + 1];
            size--;
        }

        public void print() {
            for (int i = 0; i < size; i++)
                System.out.print(data[i] + " ");
            System.out.println();
        }

        public void longWords() {
            for (int i = 0; i < size; i++)
                if (data[i].length() >= 4)
                    System.out.print(data[i] + " ");
            System.out.println();
        }
    }
