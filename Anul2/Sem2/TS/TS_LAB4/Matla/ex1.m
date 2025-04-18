Gc = 2;
G = tf(10, [1, 10]);

G0 = feedback(Gc * G, +1);

Gc2 = tf([2 20], [1 0]);

G02 = feedback (Gc2 * G, +1);

step(G0,G02);


