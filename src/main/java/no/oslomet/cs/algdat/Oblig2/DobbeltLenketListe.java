package no.oslomet.cs.algdat.Oblig2;


////////////////// class DobbeltLenketListe //////////////////////////////


import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;


public class DobbeltLenketListe<T> implements Liste<T> {

    /**
     * Node class
     *
     * @param <T>
     */
    private static final class Node<T> {
        private T verdi;                   // nodens verdi
        private Node<T> forrige, neste;    // pekere

        private Node(T verdi, Node<T> forrige, Node<T> neste) {
            this.verdi = verdi;
            this.forrige = forrige;
            this.neste = neste;
        }

        private Node(T verdi) {
            this(verdi, null, null);
        }
    }

    // instansvariabler
    private Node<T> hode;          // peker til den første i listen
    private Node<T> hale;          // peker til den siste i listen
    private int antall;            // antall noder i listen
    private int endringer;         // antall endringer i listen

    public DobbeltLenketListe() {
        // Setter hode og hale til null. Antall og endringer settes til 0.
        hode = null;
        hale = null;
        antall = 0;
        endringer = 0;
        //throw new UnsupportedOperationException();
    }

    public DobbeltLenketListe(T[] a) {
        //Sjekker om tabellen er null og gir i såfall feilmelding
        Objects.requireNonNull(a, "Tabellen a er null");

        //Finner posisjon til første verdi i tabell "a" som ikke er "null"
        int i = 0;
        if (a.length != 0) {
            for (; i < a.length; i++) {
                if (a[i] != null) {
                    Node<T> nyNode = new Node<>(a[i], null, null);
                    hode = nyNode;
                    nyNode.forrige = hode;
                    hode.neste = nyNode;
                    hode.forrige = null;
                    hale = nyNode;
                    hale.neste = null;
                    antall++;
                    endringer++;
                    i++;
                    break;
                }
            }

            for (; i < a.length; i++) {
                if (a[i] != null) {
                    Node<T> nyNode = new Node<>(a[i], hale, null);
                    hale = nyNode;
                    hale.neste = null;
                    antall++;
                    endringer++;
                }
            }
        }
        // throw new UnsupportedOperationException();
    }

    public Liste<T> subliste(int fra, int til) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int antall() {
        return antall;
        //throw new UnsupportedOperationException();
    }

    @Override
    public boolean tom() {
        if (antall == 0) {
            return true;
        } else {
            return false;
        }
        //throw new UnsupportedOperationException();
    }

    @Override
    public boolean leggInn(T verdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void leggInn(int indeks, T verdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean inneholder(T verdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T hent(int indeks) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indeksTil(T verdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T oppdater(int indeks, T nyverdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean fjern(T verdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T fjern(int indeks) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void nullstill() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException();
    }

    public String omvendtString() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    public Iterator<T> iterator(int indeks) {
        throw new UnsupportedOperationException();
    }

    private class DobbeltLenketListeIterator implements Iterator<T> {
        private Node<T> denne;
        private boolean fjernOK;
        private int iteratorendringer;

        private DobbeltLenketListeIterator() {
            denne = hode;     // p starter på den første i listen
            fjernOK = false;  // blir sann når next() kalles
            iteratorendringer = endringer;  // teller endringer
        }

        private DobbeltLenketListeIterator(int indeks) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean hasNext() {
            return denne != null;
        }

        @Override
        public T next() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    } // class DobbeltLenketListeIterator

    public static <T> void sorter(Liste<T> liste, Comparator<? super T> c) {
        throw new UnsupportedOperationException();
    }

    //Test oppg 1
    public static void main(String[] args) {
        Integer[] a = {null, null, null, 1,2,3,4,5,6,7,8};
        Liste<Integer> liste = new DobbeltLenketListe<>(a);
        System.out.println(liste.antall() + " " + liste.tom());
    }

} // class DobbeltLenketListe




