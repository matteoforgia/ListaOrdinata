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

    public void swap(int i, int j){
        T temp = this.get(i);
        super.insert(this.get(j), i);
        super.insert(temp, j);

    }
    
    public void sort(){
        for(int i = 0; i<length()-1; i++){
            for (int j = 0; j < length()-1; j++) {
                if(get(i).compareTo(get(j)) > 0){
                    swap(i, j);
                }
            }
        }
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