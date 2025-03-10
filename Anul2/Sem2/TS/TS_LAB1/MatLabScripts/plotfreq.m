function plotfreq(n)

figure
    t = 0:0.1:1;
        f1 = exp(-t);
        f2 = sin(2 * pi * n * t);
        f3 = f1 .* f2;

        plot(t, f1, 'b'), hold on
        plot(t, f2, 'r')
        plot(t, f3, 'g')
    
end

