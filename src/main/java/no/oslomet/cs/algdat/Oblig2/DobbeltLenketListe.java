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
        private final T verdi;                   // nodens verdi
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
        Objects.requireNonNull(a, "Tabellen a er null"); //Sjekker om tabellen er null og gir i såfall feilmelding

        if (a.length != 0) { //Sjekker om tabell har lengde 0
            int i = 0;  //Finner posisjon til første verdi i tabell "a" som ikke er "null"
            for (; i < a.length && a[i] == null; i++) ; //Finner første indeks i tabell som ikke er "null"

            if (i < a.length) {
                Node<T> nyNode = new Node<>(a[i], null, null);
                hode = nyNode;
                hode.neste = nyNode;
                hode.forrige = null;
                nyNode.forrige = hode;
                hale = nyNode;
                hale.neste = null;
                antall++;
                endringer++;
                i++;

                for (; i < a.length; i++) {
                    if (a[i] != null) {
                        nyNode.neste = new Node<>(a[i], hale, null);
                        nyNode = nyNode.neste;
                        hale = nyNode;
                        hale.neste = null;
                        antall++;
                        endringer++;
                    }
                }
            }
        }
    }
// throw new UnsupportedOperationException();

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
        return antall == 0;
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
        StringBuilder s = new StringBuilder(); //Bruker Stringbuilder-klassen for å opprette en streng
        s.append('['); //Starter strengen med "["

        if (!tom()) { //Sjekk om listen er tom
        Node<T> node = hode; //Hent verdien til noden som hodet peker på
        s.append(node.verdi); //Legg verdien inn i strengen
        node = node.neste; //Pek mot neste node i listen

        while (node != null) { //Kjør gjennom listen inntil vi kommer til "null" som er siste node sin "neste"
            s.append(',');
            s.append(' ');
            s.append(node.verdi);
            node = node.neste;
             }
        }
        s.append(']'); //Avslutt strengen med "["
        return s.toString(); //Returner strengen
        //throw new UnsupportedOperationException();
    }

    public String omvendtString() {
        StringBuilder s = new StringBuilder(); //Bruker Stringbuilder-klassen for å opprette en streng
        s.append('['); //Starter strengen med "["

        if (!tom()) { //Sjekk om listen er tom
            Node<T> node = hale; //Hent verdien til noden som hodet peker på
            s.append(node.verdi); //Legg verdien inn i strengen
            node = node.forrige; //Pek mot neste node i listen

            while (node != null) { //Kjør gjennom listen inntil vi kommer til "null" som er siste node sin "neste"
                s.append(',');
                s.append(' ');
                s.append(node.verdi);
                node = node.forrige;
            }
        }
        s.append(']'); //Avslutt strengen med "["
        return s.toString(); //Returner strengen
        //throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    public Iterator<T> iterator(int indeks) {
        throw new UnsupportedOperationException();
    }

    private class DobbeltLenketListeIterator implements Iterator<T> {
        private final Node<T> denne;
        private final boolean fjernOK;
        private final int iteratorendringer;

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
        String[] s1 = {}, s2 = {"A"}, s3 = {null,"A",null,"B",null};
        DobbeltLenketListe<String> l1 = new DobbeltLenketListe<>(s1);
        DobbeltLenketListe<String> l2 = new DobbeltLenketListe<>(s2);
        DobbeltLenketListe<String> l3 = new DobbeltLenketListe<>(s3);
        System.out.println(l1.toString() + " " + l2.toString()
                + " " + l3.toString() + " " + l1.omvendtString() + " "
                + l2.omvendtString() + " " + l3.omvendtString());
// Utskrift: [] [A] [A, B] [] [A] [B, A]
    }

} // class DobbeltLenketListe




