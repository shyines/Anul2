# Rezistenta, condensator
RXXXXXXX N1 N2 VALUE
ex. r1 in out 10k
CXXXXXXX N+ N- VALUE <IC=Initial values>
ex. c1 out 0 470n
# Sursa de tensiune
VXXXXXXX N+ N- DC value sau SIN sau PULSE
## DC
Vin in 0 dc 5
## Pulse

| PULSE(V1 V2 TD TR TF PW PER)          |
| ------------------------------------- |
| vin in 0 pulse(0 5 0 0 0.1e-3 0.2e-3) |
| V1 (initial value)                    |
| V2 (final value - pulsed value)       |
| TD (delay time – initial delay)       |
| TR (rise time)                        |
| TF (fall time)                        |
| PW (pulse width)                      |
| PER (period) > PW                     |

## Sin
| SIN(V0 VA FREQ TD THETA) |
| ------------------------ |
| vin in 0 sin(0 5 1k 0 0) |
| V0 (offset)              |
| VA (amplitude)           |
| FREQ (frequency)         |
| TD (delay)               |
| THETA(damping factor)    |
# Diode, tranzistori

## Diode
.model numeModel D tt/bv
tt = valoare (transit time)
bv = valoare (breakdown voltage, la zener probabil)
ex .Model DiodaS D tt=1e-9

## Tranzistori

Bipolar:
.model numeModel npn/pnp 
tf = forward transit time
tr = reverse transit time