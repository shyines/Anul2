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


## [[Realizarea Magistralelor cu Circuite Logice]]

**Open drain/Open collector (Colector in gol/drena in gol)**- colectoarele/drenele tranzistoarelor legate impreuna, punctul comun fiind conectat la o sursa cu o rezistenta. UN CIORCHINE DE COLECTOARE VEREEEEEEEEE!!!11!!!!!1111

**Open emiter/Open Source (Emitator liber/Sursa libera)**- LA FEL CA MAI SUS LMAO!!!!!


## Stabilizator cu reactie cu amplificator de eroare

$$ V_{OUT} = V_{Z} - V_{BE}$$
V_be = ceva tensiune
Vz = tensiune de referinta
Vout = tensiunea la iesire


## Factorul de incarcare - 

Cate alte circuite pot fi incarcate cu voltajul pe care un circuit tata il scoate. Se calculeaza cu formula: 
$$
F_{OL} = \left[ \frac{I_{OL}}{I_{IL}} \right]
$$
aia e pentru 0 logic, iar

$$F_{IL} = \left[ \frac{I_{OH}}{I_{IH}} \right]$$

IAR PENTRU PORTI DIN ACEEASI FAMILIE SE IA FORMULA ASTA
$$
I_{OL} \geq \sum I_{IL}
$$
$$I_{OH} \geq \sum I_{IH}$$

