G = tf(1, conv([1 1], [1 2 2]));

rlocus(G)
shg

%%
G = tf([1 1], [conv([1 -1 0], [1 6])]);
rltool(G)
shg