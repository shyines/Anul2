clear
clc
close all

x=linspace(0,6,13);% nodurile de interpolare
f=exp(sin(x)); % valorile functiei pentru noduri
fd=exp(sin(x)).*cos(x);% valorile derivatei pentru noduri
Al=DiferenteDivizate(x,f);% se calculeaza diferentele divizate
[zh,Ah]=DifDivDuble(x,f,fd);% se calculeaza diferentele divizate pentru noduri duble

u=0:0.05:6;%punctele pentru polinomul Hermite si Lagrange-Newton
Exact=exp(sin(u)); % valoarea exacta a functiei pentru aceste puncte
Herm=zeros(1,length(u));
Lagr=zeros(1,length(u));
for k=1:length(u)
     Herm(k)=Newton_Polinom(Ah,zh,u(k));
     Lagr(k)=Newton_Polinom(Al,x,u(k));
end
 
Erh=abs(Exact-Herm);
Erl=abs(Exact-Lagr); 

figure(1)
hold on
box on
title('Interpolare Hermite cu noduri duble')
plot(u,exp(sin(u)),'r')
plot(u,Herm,'b*')

figure(2)
hold on
box on
title('Eroarea pentru interpolarea Hermite')
plot(u,log10(abs(Erh)),'b*')

figure(3)
hold on
box on
title('Interpolare Lagrange cu diferente divizate')
plot(u,exp(sin(u)),'r')
plot(u,Lagr,'b*')

figure(4)
hold on
box on
title('Eroarea pentru interpolarea Lagrange')
plot(u,log10(abs(Erl)),'b*')


%% - exemplu pentru sin 3x 

clear
clc
close all

x=linspace(12,30,32);% nodurile de interpolare
f=sin(3.*x); % valorile functiei pentru noduri
fd=3.*(sin(3.*x)).*cos(3.*x);% valorile derivatei pentru noduri
Al=DiferenteDivizate(x,f);% se calculeaza diferentele divizate
[zh,Ah]=DifDivDuble(x,f,fd);% se calculeaza diferentele divizate pentru noduri duble

u=12:0.05:30;%punctele pentru polinomul Hermite si Lagrange-Newton
Exact=sin(2.*u); % valoarea exacta a functiei pentru aceste puncte
Herm=zeros(1,length(u));
Lagr=zeros(1,length(u));
for k=1:length(u)
     Herm(k)=Newton_Polinom(Ah,zh,u(k));
     Lagr(k)=Newton_Polinom(Al,x,u(k));
end
 
Erh=abs(Exact-Herm);
Erl=abs(Exact-Lagr); 

figure(1)
hold on
box on
title('Interpolare Hermite cu noduri duble')
plot(u,sin(2.*u),'r')
plot(u,Herm,'b*')

figure(2)
hold on
box on
title('Eroarea pentru interpolarea Hermite')
plot(u,log10(abs(Erh)),'b*')

figure(3)
hold on
box on
title('Interpolare Lagrange cu diferente divizate')
plot(u,sin(2.*u),'r')
plot(u,Lagr,'b*')

figure(4)
hold on
box on
title('Eroarea pentru interpolarea Lagrange')
plot(u,log10(abs(Erl)),'b*')

%ce se observa - functia din nou afiseaza corect. din cauza
%intervalului ales valorile sunt doar de 0

%%

clear
clc
close all

x=linspace(0,6,6);% nodurile de interpolare
f=3.*x; % valorile functiei pentru noduri
fd=3;% valorile derivatei pentru noduri
Al=DiferenteDivizate(x,f);% se calculeaza diferentele divizate
[zh,Ah]=DifDivDuble(x,f,fd);% se calculeaza diferentele divizate pentru noduri duble

u=0:1:6;%punctele pentru polinomul Hermite si Lagrange-Newton
Exact=3.*u; % valoarea exacta a functiei pentru aceste puncte
Herm=zeros(1,length(u));
Lagr=zeros(1,length(u));
for k=1:length(u)
     Herm(k)=Newton_Polinom(Ah,zh,u(k));
     Lagr(k)=Newton_Polinom(Al,x,u(k));
end
 
Erh=abs(Exact-Herm);
Erl=abs(Exact-Lagr); 

figure(1)
hold on
box on
title('Interpolare Hermite cu noduri duble')
plot(u,3.*u,'r')
plot(u,Herm,'b*')

figure(2)
hold on
box on
title('Eroarea pentru interpolarea Hermite')
plot(u,log10(abs(Erh)),'b*')

figure(3)
hold on
box on
title('Interpolare Lagrange cu diferente divizate')
plot(u,3.*u,'r')
plot(u,Lagr,'b*')

figure(4)
hold on
box on
title('Eroarea pentru interpolarea Lagrange')
plot(u,log10(abs(Erl)),'b*')
