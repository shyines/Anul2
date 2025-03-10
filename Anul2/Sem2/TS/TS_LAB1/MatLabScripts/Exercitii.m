grid on

polinom1 = [1, 2, 0];

figure(1)
plot(real(roots(polinom1)), imag(roots(polinom1)), "*"); 
grid on

figure(2)
polinom2 = [1, 6, -7];
plot(roots(polinom2), imag(roots(polinom2)), "*");
grid on

figure(3)
polinom3 = [1, 0, 4];
plot(roots(polinom3), imag(roots(polinom3)), "*");
grid on

figure(4)
polinom4 = [1, 3, 2];
plot(roots(polinom4), imag(roots(polinom4)), "*");
grid on

figure(5)
polinom5 = [1, 2, 2];
plot(roots(polinom5), imag(roots(polinom5)), "*");
grid on

figure(6)
polinom6 = [1, 0, 0, -16];
plot(roots(polinom6), imag(roots(polinom6)), "*");
grid on

%%
close all
clear all

for k = 0:0.5:10,
    polinom = [1, 2, 3, k];
    res = roots(polinom);
    plot(real(res), imag(res), "*"), hold on;
    grid on
end
%%
t = 0:0.1:10;

f = exp(-t);
subplot(2, 3, 1);
plot(t, f);

f2 = exp(t);
subplot(2, 3, 2);
plot(t, f2);

f3 = sin(2*t);
subplot(2, 3, 3);
plot(t, f3);

f4 = 1/2j * sin(2j .* t);
subplot(2, 3, 4);
plot(t, f4);

f5 = exp(-2 * t) .* sin(2 * t);
subplot(2, 3, 5);
plot(t, f5);

f6 = exp(2 * t) .* sin(2 * t);
subplot(2, 3, 6);
plot(t, f6);

%%
for n = 0.5:0.5:5
    plotfreq(n);
end

%%

numar_de_iteratii = 10000;
A1 = [0, 0;
      0, 0.16];

A2 = [0.85, 0.04;
     -0.04, 0.85];

A3 = [0.2 -0.26;
      0.23 0.22];

A4 = [-0.15 0.28;
      0.26 0.24];

t1 = [0;0];
t2 = [0;1.6];
t3 = [0;1.6];
t4 = [0; 0.44];

X = [0;0];
v = X;

for i = 1:numar_de_iteratii
    n = rand();
    if n < 0.8 
         v = A1 * v + t1;
    elseif n < 0.9
            v = A3 * v + t3;
    else
            v = A4 * v + t4;

    end

    X = [X v];


end
plot(X(1:2), X(1:2), ".g");