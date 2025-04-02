close all
clear all
clc 

K = 1; T = 1; sys1 = tf(K, [T 1]);
K = 3; T = 1; sys2 = tf(K, [T 1]);
K = 1; T = 3; sys3 = tf(K, [T 1]);
K = 1; T = 4; sys4 = tf(K, [T 1]);

step(sys1, sys2, sys3, sys4, 25), grid on
legend('H1: K = 1; T = 1', 'H2: K = 3; T = 1', 'H3: K = 1; T = 3', 'H4: K = 1; T = 6');

%timpul pentru un sistem sa ajunga sa fie stabil este ts si sn timp de
%stabilizare ts = 4 * T


%%
clear all
close all
clc

K = 4; H1 = tf(K, [1 5 4]);
disp('Polii pentru H1');
roots([1 5 4])
figure

subplot(211), step(H1), grid on
subplot(212), impulse(H1), grid on

%H7: 
num = 4; den = conv([1 0 4], [1 0 4]);
H7 = tf(num, den);
disp ('Polii pentru sys7')
r = roots(den)
figure

subplot(211), step(H7, 30), grid on
subplot(212), impulse(H7, 30), grid on

%%

figure, hold on, grid on

for k = 0: 0.1: 100
    Pc = [1, 3 , 4, 2 + k];
    r = roots(Pc);
    plot(real(r), imag(r), '*');
    pause(0.01);
end
