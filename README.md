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



