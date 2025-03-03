

## Magistrala I2C

**Open-drain/open-collector** cu un buffer de intrare pe aceeasi linie
**Pull-down FET** pentru transmiterea datelor
**Buffer** pentru citirea datelor de intrare

Un dizpozitiv poate sa traga linia de magistrala la un nivel coborat (scurtcircuit la masa prin deschiderea FET) sau sa elibereze linia de magistrala (inalta impedanta la masa prin blocarea FET) si sa permita rezistentei de ridicare sa creasca tensiunea

Niciun dizpozitiv nu poate tine linia de magistrala la un nivel ridicat

O singura linie de date folosita pentru flux de date bidirectional

Niciun dispozitiv nu poate forta un nivel ridicat pe o linie

Linia nu se va confrunta niciodată cu o problemă de comunicatie unde un dispozitiv poate incerca sa transmita un nivel ridicat si altul sa transmita un nivel coborat, provocând un scurtcircuit (alimentare la masă)

Daca un master transmite un nivel ridicat, dar vede ca linia este la un nivel coborat, opreste comunicatiile deoarece un alt dispozitiv foloseste magistrala
Daca dispozitivul doreste sa transmita un nivel coborat, va activa tranzistorul FET de coborare, care va furniza un scurtcircuit la masa, tragand linia la nivel coborat.

Daca dispozitivul doreste sa transmita un nivel ridicat, poate doar elibera linia de magistrala blocand tranzistorul FET de coborare. Acesta lasa linia de magistrala flotanta, iar rezistenta de ridicare va trage tensiunea in sus spre tensiunea de alimentare, care va fi interpretata ca un nivel ridicat.


## Magistrala I2C – Interfata I2C

**Masterul comunica cu sclavii**, sclavii nu vorbesc neintrebati.



## Procedura generala pentru un dispozitiv master sa acceseze un dispozitiv slave:

## 1. Dispozitivul master doreste sa transmita date unui dispozitiv slave:
- Master-transmitator trimite o conditie START si adreseaza slave-receptor
- Master-transmitator trimite date spre slave-receptor
- Master-transmitator termina transferul cu o conditie STOP
## 2. Dispozitivul master doreste sa receptioneze/citeasca date de la un dispozitiv slave:
- Master-receptor trimite o conditie START si adreseaza slave-transmitator
- Master-receptor trimite registrul cerut pentru citire la slave-transmitator
- Master-receptor primeste datele de la slave-transmitator
- Master-receptor termina transferul cu o conditie STOP


