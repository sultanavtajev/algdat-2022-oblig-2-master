# Obligatorisk oppgave 2 i Algoritmer og Datastrukturer

Denne oppgaven er en innlevering i Algoritmer og Datastrukturer. 
Oppgaven er levert av følgende studenter:
* Sultan Avtajev, S199219, s199219@oslomet.no

# Arbeidsfordeling

I oppgaven har vi hatt følgende arbeidsfordeling:
* Sultan har hatt ansvar for oppgave 1-8

# Oppgavebeskrivelse
Oppgave 1: 
Her lagde jeg først metodene antall() og boolean tom (). Antallet returnerer antallet noder i listen vår. Deretter 
kodet jeg og boolean tom() returnerer "true" hvis vi ikke har noen noder i listen. Tabell "a" blir sendt inn i 
konstruktøren. Det blir gjort en sjekk på nullverdier. Deretter legges hver verdi fra tabellen inn som noder i 
listen vår. Med både pekere på neste node og forrige node. Vedlagt programbit er testet ut og gir forventet resultat. 

Oppgave 2: 
Kodet først metoden String toString(). Her bygger vi opp en streng med StringBuilder-klassen. Her itererer vi 
gjennom alle noden vi har og lager en streng av dem. 

Koder deretter metoden boolean leggInn(). Metoden legger en ny node bakerst i lista og returnerer true. En sjekk 
blir gjort om lista er tom. I såfall settes hode og hale pekeren til noden som skal legges til. Hvis listen ikke er 
tom, settes nodens pekere etter halen, flytter halens pekere til noden og flytter halen. Vedlagt programbit er 
testet ut og gir forventet resultat.

Oppgave 3: 
Her lager vi en metode som returnerer verdien til en node basert på indeks/posisjon. En indeks blir sendt inn. Hvis 
indeksen er mindre enn antall/2, så starter letingen fra hode og går måt høyre. Hvis indeksen er høyere enn antall/2,
så starter letingen fra hale og går mot venstre. 

Kodet deretter metoden "hent" som enkelt og greit returnerer node fra indeksen vi sender inn til metoden. Her kaller
vi på metoden "finnNode". 

Videre koder vi metoden "oppdater". Denne metoden tar inn en indeks og en verdi vi vil oppdatere verdien på indeksen 
med. Samtidig returneres den gamle verdien på den oppgitte indeksen. 

Videre konfigureres metoden "subliste". Her tar vi inn et intervall (fra-til). Sjeker om intervallet er lovlig og 
itererer node-lista i forhold til dette intervalet. Returnerer en ny del-liste.
Vedlagt programbit er testet ut og gir forventet resultat.

Oppgave 4: 
Koder metoden "indeksTil" som tar inn en verdi og returnerer indeksen til denne verdien i lista. Metoden returnerer 
"-1" hvis verdien ikke finnes eller hvis verdien som er sendt inn er "null". 

Videre lager jeg metoden "inneholder". Denne metoden returnerer "true" hvis listen inneholder verdien vi ser etter, 
ellers skal det returneres med "false". 

Oppgave 5:
Koder metoden "leggInn" som skal ta inn en indeks og en verdi. Verdien skal plasseres på innsendt indeks. Før dette 
gjøres valideres indeksen mot null og antall allerede registrerte noder. Hvis validering ok, fortsetter programmet. 
Det gjøres sjekk mot om indeksen er den eneste, første, siste eller mellom to andre noder. Basert på dette 
oppdateres både den nye nodens og de tilhørende noder sine pekere. 

Oppgave 6: 
Metodene "fjern" og "boolean fjern" kodet. Den første fjerner verdien på innsendt indeks og returnerer den samtidig. 
Den andre leter gjennom listen etter innsendt verdi, fjerner hvis funnet og returnerer "true" hvis verdien ble 
funnet. Hvis verdien ikke er funnet returneres "false".
Det gjøres sjekk mot om indeksen/verdien er første, siste eller mellom to andre noder. Basert på dette oppdateres de tilhørende noder sine pekere. 

Oppgave 7: 
Utangspunktet ikke en del av leveringen, da jeg leverer alene. For å få oppgave 8 "bestått", ble jeg nødt til kode 
oppgave 7 også. Dermed kodet jeg metoden "nullstill". Den tømmer listen for hver node og eterlater alle verdier i 
"null". Java sin innebygde "søppeltømmer" rydder deretter opp. Jeg brukte den første fremgangsmåten. Metoden starter 
på hode og går mot hale med hjelpepekeren "neste". For hver node nulles nodeverdien og alle nodens pekere. Til slutt 
settes både hode og hale til null, antall til 0 og endringer økes. 

Oppgave 8: 
Koder metoden "next". Den sjekkes om iteratorendringer er lik endringer. Hvis ikke kastes en feilkode. Deretter 
kastes en feilkode hvis det ikke er flere igjen i listen. Altså hvis metoden "hasNext" ikke er "true". Deretter 
settes "fjernOK" til true, verdien til "denne" returneres og "denne" flyttes til den neste node. 

Deretter kodet jeg metoden "iterator". Den returnerer en instans av iteratorklassen. 

Videre kodet jeg konstruktøren "DobbeltLenketListeIterator" som setter pekeren "denne" til den noden som hører til 
den oppgitte indeksen. 

Til slutt kodet jeg metoden "iterator" som tar inn en indeks. Det valideres frøst om indeksen er lovlig med metoden 
"indekskontroll". Deretter returnerer metoden en instans av iteratorklassen.
Vedlagt programbit er testet ut og gir forventet resultat.



