package no.oslomet.cs.algdat.Oblig2;


////////////////// class DobbeltLenketListe //////////////////////////////


import java.util.*;


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
        Objects.requireNonNull(a, "Tabellen a er null"); //Sjekker om tabellen er null og gir i såfall feilmelding

        if (a.length != 0) { //Sjekker om tabell har lengde 0
            int i = 0;  //Finner posisjon til første verdi i tabell "a" som ikke er "null"
            for (; i < a.length && a[i] == null; i++) ; //Finner første indeks i tabell som ikke er "null"

            if (i < a.length) {
                Node<T> nyNode = new Node<>(a[i], null, null); //Oppretter første node
                hode = nyNode;
                hode.neste = nyNode;
                hode.forrige = null;
                nyNode.forrige = hode;
                hale = nyNode;
                hale.neste = null;
                antall++;
                endringer++;
                i++;

                for (; i < a.length; i++) { //Oppretter resterende noder
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
        fratilKontroll(antall, fra, til); //Kontroller interval

        Liste<T> liste = new DobbeltLenketListe<>(); //Lag ny liste
        int tablengde = til - fra; //Lengde av tabell

        if (tablengde < 1) { //Returner tom liste
        } else {
            Node<T> node = finnNode(fra);
            for (int i = fra; i <= til; i++) {
                if (tablengde > 0) {
                    liste.leggInn(node.verdi);
                    node = node.neste;
                    tablengde--;
                }
            }
        }
        return liste;
        //throw new UnsupportedOperationException();
    }

    private void fratilKontroll(int antall, int fra, int til) {
        if (fra < 0)                                  // fra er negativ
            throw new IndexOutOfBoundsException
                    ("fra(" + fra + ") er negativ!");

        if (til > antall)                          // til er utenfor tabellen
            throw new IndexOutOfBoundsException
                    ("til(" + til + ") > antall(" + antall + ")");

        if (fra > til)                                // fra er større enn til
            throw new IllegalArgumentException
                    ("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");
    }

    private Node<T> finnNode(int indeks) {
        indeksKontroll(indeks, false); //Kontroll av indeks

        Node<T> node;
        int i;//Hvis index er større eller lik antall/2 begynn fra halen. Gå bakover til noden er funnet
        if (indeks < antall / 2) { //Hvis index er mindre enn antall/2 begynn fra hodet
            node = hode;
            i = 0;
            while (i != indeks) { //Stop når riktig indeks er funnet
                node = node.neste;
                i++;
            }
        } else {
            node = hale;


            i = antall - 1;
            while (i != indeks) {
                node = node.forrige;
                i--;
            }
        }
        return node;
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
        Objects.requireNonNull(verdi, "Ikke tillatt med null verdier"); //Sjekk om verdi er "null"

        //Oppretter ny node
        Node<T> node = new Node<>(verdi); //Etabler ny node

        if (tom()) { //Sjekk om liste er tom
            hode = node; //Hode peker til første nye node
            //Hvis ikke, begynn på slutten, sett nodens pekere etter hale og flytt halens pekere til noden og
        } else { //Hvis liste ikke er tom.
            node.forrige = hale;
            hale.neste = node;
        }
        hale = node; //Hale peker til første nye noden
        antall++;
        endringer++;
        return true;
        //throw new UnsupportedOperationException();
    }

    @Override
    public void leggInn(int indeks, T verdi) {
        Objects.requireNonNull(verdi, "Verdi kan ikke være null!"); //Sjekker om verdi er null

        //Sjekker om indeks er innenfor grensene. Å bruke indeksKontroll ga feil i testing. Gjøres derfor slik.
        if (indeks > antall) throw new IndexOutOfBoundsException("Indeks kan ikke være større enn antall noder!");
        if (indeks < 0) throw new IndexOutOfBoundsException("Indeks kan ikke være mindre enn 0!");

        Node<T> node = new Node<>(verdi, null, null); //Opprett ny node med verdiene

        if (tom()) { //Tilfelle 1 - lista er tom
            hode = hale = node;
        } else if (indeks == 0) { //Tilfelle 2 - skal legges først
            hode.forrige = node;
            node.neste = hode;
            hode = node;
        } else if (indeks == antall) { //Tilfelle 3 - skal legges bakerst
            hale.neste = node;
            node.forrige = hale;
            hale = node;
        } else { //Tilfelle 4 - skal legges mellom to noder. Koden under er lånt og tilpasset fra kompendiet.
            //Begynner på begynnelsen av listen
            node = hode;
            //Går igjennom listen og finner noden før indeksen
            for (int i = 0; i < indeks; i++) node = node.neste;
            {
                //Setter noden som skal inn, mellom to noder underveis
                node = new Node<T>(verdi, node.forrige, node);
            }
            //Setter til slutt noden på indeks og setter korrekt pekere bak og frem
            node.neste.forrige = node.forrige.neste = node;
        }
        antall++;
        endringer++;
        //throw new UnsupportedOperationException();
    }

    @Override
    public boolean inneholder(T verdi) {
        if (indeksTil(verdi) == -1) {
            return false;
        } else {
            return true;
        }
        //throw new UnsupportedOperationException();
    }

    @Override
    public T hent(int indeks) {
        indeksKontroll(indeks, false);
        Node<T> node = finnNode(indeks);
        return node.verdi;
        //throw new UnsupportedOperationException();
    }

    @Override
    public int indeksTil(T verdi) {
        if (verdi == null) //Sjekk null-verdier
            return -1;

        Node<T> node = hode; //Initialiser node som skal lagre verdier undeveis
        for (int i = 0; i < antall; i++) { //Søk etter verdien
            if (node.verdi.equals(verdi))
                return i;
            node = node.neste;
        }

        return -1; //Returner -1 hvis verdien ikke er funnet
        //throw new UnsupportedOperationException();
    }

    @Override
    public T oppdater(int indeks, T nyverdi) {
        Objects.requireNonNull(nyverdi, "Kan ikke være null!");
        indeksKontroll(indeks, false);

        T gammel = hent(indeks); //Lagre nodens nåværende verdi
        finnNode(indeks).verdi = nyverdi; //Oppdater node med ny verdi
        endringer++;
        return gammel;
        //throw new UnsupportedOperationException();
    }

    @Override
    public boolean fjern(T verdi) {
        if (verdi == null) {
            return false; //Sjekk null-verdier
        }

        Node<T> node = hode; // Hjelpepeker

        while (node != null) { //Let til enden av listen
            if (node.verdi.equals(verdi)) break; //Hopp ut av loopen hvis samsvarende verdi er funnet
            node = node.neste; //Flytter peker til neste node hvis verdi ikke er funnet
        }

        if (node == null) return false; //Returner false hvis verdi ikke er funnet

        else if (antall == 1) { //Lengde lik 1
            hode = hale = null;
        } else if (node == hode) {//Den første fjernes
            hode = hode.neste;
            hode.forrige = null;

        } else if (node == hale) { //Den siste fjernes
            hale = hale.forrige;
            hale.neste = null;
        } else { //Fjernes mellom to noder
            node.forrige.neste = node.neste;
            node.neste.forrige = node.forrige;
        }

        node.verdi = null; //Setter pekerne til "null"
        node.forrige = node.neste = null;

        antall--; //Senker antallet noder i listen med 1
        endringer++;

        return true;
        //throw new UnsupportedOperationException();
    }

    @Override
    public T fjern(int indeks) {
        indeksKontroll(indeks, false); //Ikke tillatt indeks

        Node<T> node = hode; //Hjelpepeker

        if (antall == 1) { //Lengde lik 1
            hode = hale = null;
        } else if (indeks == 0) { //Den første fjernes
            hode = hode.neste;
            hode.forrige = null;
        } else if (indeks == antall - 1) { //Den siste fjernes
            node = hale;
            hale = hale.forrige;
            hale.neste = null;
        } else {
            node = finnNode(indeks); //Fjernes mellom to noder
            node.forrige.neste = node.neste;
            node.neste.forrige = node.forrige;
        }

        T verdi = node.verdi; //Setter pekerne til "null"
        node.verdi = null;
        node.forrige = node.neste = null;
        antall--; //Senker antallet noder i listen med 1
        endringer++;
        return verdi; //Returner slettet verdi
        //throw new UnsupportedOperationException();
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
        s.append(']'); //Avslutt strengen med "]"
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
        s.append(']'); //Avslutt strengen med "]"
        return s.toString(); //Returner strengen
        //throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<T> iterator() {
        //insperiasjon fra kompendiet programkode Programkode 3.3.4 e)
        //Lag metoden Iterator<T> iterator(). Den skal returnere en instans av iteratorklassen.
        return new DobbeltLenketListeIterator();

        //throw new UnsupportedOperationException();
    }

    public Iterator<T> iterator(int indeks) {
        indeksKontroll(indeks,false);//Det må først sjekkes at
        //indeksen er lovlig. Bruk metoden indeksKontroll().
        new DobbeltLenketListeIterator();
        DobbeltLenketListeIterator li = new DobbeltLenketListeIterator();
        li.denne = finnNode(indeks);
        //Deretter skal den ved hjelp av
        //konstruktøren i punkt c) returnere en instans av iteratorklassen.

        return li;
        //throw new UnsupportedOperationException();
    }

    private class DobbeltLenketListeIterator implements Iterator<T> {
        private Node<T> denne;
        private boolean fjernOK;
        private final int iteratorendringer;

        private DobbeltLenketListeIterator() {
            denne = hode;     // p starter på den første i listen
            fjernOK = false;  // blir sann når next() kalles
            iteratorendringer = endringer;  // teller endringer
        }

        private DobbeltLenketListeIterator(int indeks) {
            denne = finnNode(indeks); // Den skal sette pekeren denne til den noden som hører til den oppgitte indeksen.
            //. Resten skal være som i den konstruktøren som er ferdigkodet
            fjernOK = false;
            iteratorendringer = endringer;
            //throw new UnsupportedOperationException();
        }

        @Override
        public boolean hasNext() {
            return denne != null;
        }

        @Override
        public T next() {
            if(!hasNext()){
                throw new NoSuchElementException("Tomt eller ingen verider igjen"); // Så en NoSuchElementException hvis det ikke er flere igjen i listen (dvs. hvis hasNext() ikke er sann/true).
            }

            //Lag metoden T next(). Den skal først sjekke om iteratorendringer er lik endringer.
            if(iteratorendringer != endringer){
                throw new ConcurrentModificationException(); //Hvis ikke, kastes en ConcurrentModificationException.
            }
            //henter inspirasjon fra kompendiet programkode 3.2.4 c) public T next()

            // Deretter
            //settes fjernOK til sann/true, verdien til denne returneres og denne flyttes til den neste node.
            fjernOK = true;
            T denneVerdi = denne.verdi;
            denne = denne.neste;
            return denneVerdi;

            //throw new UnsupportedOperationException();
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
        String[] s1 = {}, s2 = {"A"}, s3 = {null, "A", null, "B", null};
        DobbeltLenketListe<String> l1 = new DobbeltLenketListe<>(s1);
        DobbeltLenketListe<String> l2 = new DobbeltLenketListe<>(s2);
        DobbeltLenketListe<String> l3 = new DobbeltLenketListe<>(s3);
        System.out.println(l1.toString() + " " + l2.toString()
                + " " + l3.toString() + " " + l1.omvendtString() + " "
                + l2.omvendtString() + " " + l3.omvendtString());
        // Utskrift: [] [A] [A, B] [] [A] [B, A]
    }

} // class DobbeltLenketListe




