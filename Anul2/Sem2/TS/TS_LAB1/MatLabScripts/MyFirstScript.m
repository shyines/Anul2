a = 8;
A = 10;
vec = [2, 3, 4];
W = [2; 3; 4];
%% - bloc de program gen
b = 1;
%%
A = [2, 5, 8;
    6, 9, 12];
rng(5)
B = rand(3,2);

C = A + B';

D = rand(30, 45);

E = A * B;

2 * A
P = 5 * eye(6)
Q = diag([1, 2, 3, 4, 5, 6])

A .* A
A.^3


%%
A = rand(3);
b = [-sqrt(7);pi;exp(1)]

det(A)
x = A\b

A * x - b

%%
A = rand(3, 5)
A(2, 4)
A(2:3, 4:5)
A(2:end, 4:end)
B = [A, A]
C = [A;
    2 * A;
    -A]

t = 0:-0.2:10

%%
z = 5 + 6j % 6 * j, 6 * 1j

real(z)
imag(z)

conj(z)

abs(z)
%%
p = [1, -5, 0, 1, 8];
q = [0, 1, 7, 5, 0];

r = conv(p, q);

%%

x = 0:0.2:10;
y = test(x);

plot(x, y,'*b'), hold on
plot(x, y + 2, '>g');