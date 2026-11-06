public class ListaOrdinabile<T extends Comparable<T>> extends Lista<T> {
    private boolean isSorted;

    public ListaOrdinabile() {
        super();
        this.isSorted = true;
    }

    public void insertSorted(T element) {
        if (!this.isSorted) { throw new RuntimeException("La lista non è ordinata"); };
        int l = this.length();
        if (l == 0) { super.insert(element, 0); }
        else {
            int index = 0;
            while (index < l && this.get(index).compareTo(element) < 0) {
                index++;
            }
            super.insert(element, index);
        }
    }

    public void swap(int i, int j) {
        if (i == j) return;

        int min = Math.min(i, j);
        int max = Math.max(i, j);
        T first = get(i);
        T second = get(j);

        super.remove(max);
        super.remove(min);
        super.insert(second, min);
        super.insert(first, max);
    }
    
    public void sort(){
        int l = this.length();
        for (int i = 0; i < l - 1; i++) {
            for (int j = 0; j < l - i - 1; j++) {
                if (this.get(j).compareTo(this.get(j + 1)) > 0) {
                    this.swap(j, j + 1);
                }
            }
        }
        this.isSorted = true;
    }

    @Override
    public void insert(T element, int i) {
        this.isSorted = false;
        super.insert(element, i);
    }

    @Override
    public void add(T element) {
        this.isSorted = false;
        super.add(element);
    }
}