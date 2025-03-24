H = tf(1, [1 3 2]);

impulse(H);
figure(2)
step(H);

[yi_sim, ti] = impulse(H, 10);
yi_calc = exp(-ti) - exp(-2 * ti);
plot(ti, yi_sim, ti, yi_calc, "*");

figure(3)
[yi_sim, ts] = step (H, 10);
yi_calc = 1/2 - exp(-ts) + 1/2 * exp(-2 * ts);
plot(ts, yi_sim, ts, yi_calc, "*");

%%

H = tf(1, [1 2 2]);

impulse(H);

figure(2);
step(H);

impulse

%%


%figure(1)
%impulse(H, 10); %e ^ (-t)
%figure(2)
%step(H ,10); % e ^ (t)

G1 = tf(1, [1 1]);
G2 = tf(1, [1 -1]);
G3 = tf(1, [1 0 -1]);
G4 = tf(1, [1 0 1]);
G5 = tf(1, [1 2 17]);
G6 = tf(1, [1 -2 17]);

figure(3)

subplot(2, 3, 1);
impulse(G1, 10);
subplot(2, 3, 2);
impulse(G2, 10);
subplot(2, 3, 3);
impulse(G3,10);
subplot(2, 3, 4);
impulse(G4, 10);
subplot(2, 3, 5);
impulse(G5, 10);
subplot(2, 3, 6);
impulse(G6, 10);

figure(4)

subplot(2, 3, 1);
step(G1, 10);
subplot(2, 3, 2);
step(G2, 10);
subplot(2, 3, 3);
step(G3,10);
subplot(2, 3, 4);
step(G4, 10);
subplot(2, 3, 5);
step(G5, 10);
subplot(2, 3, 6);
step(G6, 10);

%%
m = 0.5;
l = 1;
g = 9.8;
b = 0.5;

Pendul = tf(-1, [m * l * l b * l m * g]);
figure(1);
subplot(1, 2, 1);
impulse(Pendul, 10);
subplot(1, 2, 2);
step(Pendul, 10);