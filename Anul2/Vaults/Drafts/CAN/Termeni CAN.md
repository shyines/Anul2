## Diode
**Echilibru termic** - nu se produce nimic prin semi-conductor

**n** - electronii - impuritati, sunt negativi
**p** - purtatori de sarcina, pozitivi, goluri

**PROCES DE DIFUZIE** - electronii merg la purtatorii de sarcina
**Camp electric de difuzie sau Potential de Difuzie** - Se opune procesului de difuzie
**Tensiune de polaritate inversa** - mareste bariera de potential
**Tensiune directa, polaritate opusa** - micsoreaza bariera de potential
**Tensiune de prag** - tensiunea necesara pentru miscorarea campului electric de difuzie in totalitate
**Regiune Zener** - Dioda conduce curentul in sens invers

## Tranzistorul bipolar

**E**- emitator, sursa de purtatori (electroni sau goluri)
**B** - baza, controleaza fluxul de purtatori ce merg la C
**C** - colector, colecteaza purtatorii
**NPN** - emitatorul emite purtatori electroni
**PNP** - emitatorul emite purtatori goluri


## Tranzistorul MOS

**Drena** - 
**Gate** -
**Source** - 

**Regiunea de blocare** - curentul de iesire, curentul drena-sursa Ids este aproximativ nul si tensiunea de intrare Vgs este mai mica decat tensiunea de prag

**Regiunea liniara** - cand Vds = Vgs - Vt, curentul Ids creste rapid ca o functie de potential drena sursa Vds

**Regiunea de saturare** - regiunea situata la dreapta caracteristicii de curent, cand Vgs - Vt = Vds


## Circuite

**Puterea medie consumata in curent continuu** - $${Pcc = \frac{P_{{H}} + P_{L}}{2}} = \frac{I_{HCC} +I_{CCL}}{2} * V_{CC}$$
Iccl = curentul absorbit cand iesirea este 0
Ihcc = curentul absorbit cand iesirea este 1
Ios = curentul la scurt circuit
Pm = puterea medie consumata
Vcc = tensiunea de alimentare

**Puterea consumata in regim de comutatie** - $$P_{C} = fC{p} * V_{CC} ^ 2$$
**Puterea totala consumata** - $$P_{m} = P_{CC} + P_{C}$$


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