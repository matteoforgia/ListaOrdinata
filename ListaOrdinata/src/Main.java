public class Main {
    public static void main(String[] args) {
        ListaOrdinabile<Integer> lista = new ListaOrdinabile<>();
        lista.add(5);
        lista.add(6);
        lista.add(7);
        lista.add(8);
        lista.add(9);
        lista.stampa();
        lista.add(2);
        lista.stampa();
        lista.sort();
        lista.stampa();
    }
}