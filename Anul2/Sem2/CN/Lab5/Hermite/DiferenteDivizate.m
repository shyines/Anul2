function A=DiferenteDivizate(x,f)
%functie care calculeaza diferentele divizate, varianta nevectorizata
%x nodurile, f - matrice cu val functiei in noduri
n=length(x);
A=zeros(n,n);
A(:,1)=f; %  f[x[i]] = f(x[i])
for j=2:n
   for i=1:n-j+1
       A(i,j)=(A(i+1,j-1)-A(i,j-1))/(x(i+j-1)-x(i));
   end
end
