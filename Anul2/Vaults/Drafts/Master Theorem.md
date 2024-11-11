Master Theorem: 
	T(n) = ( T0,   if n < n0  
		    a * T( n/b ) + f (n), otherwise

a = number of recursive calls 
b = division factor (of the input) 
c = degree of the polynomial describing the running time of the sequence excepting the recursive calls


T(n) = n^c (1 + a^b /c + ( a ^b /c )^2 + ... + (a ^b /c )^logbn−1)

Geometric progression: term0 = 1, q = a/b^c , #terms = logbn


q < 1; a < b^c => O(n^c ) 
2. q = 1; a = b^c => O(n^c ∗ logbn) 
3. q > 1; a > b^c => O(?)