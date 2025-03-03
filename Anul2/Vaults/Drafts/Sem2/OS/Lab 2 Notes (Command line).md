
**&** - Daca se doreste executia unei comenzi fara blocarea terminalului (terminalul este blocat atunci cand o comanda este executata)

**;** - daca vreau sa scriu mai multe comenzi pe aceeasi linie, comenzile se executa succesiv

**|(pipe)** - output prima comanda -> input-ul urmatoarei comenzi

**||(OR)** - a doua comanda se executa doar daca prima nu s-a executat cu succes

**&&(AND)** - a doua comanda se executa doar daca prima este adevarata

### Input output

**<** - input

**>** - output

**2>** - output error


## Comenzi

cp - copy files
mv - move files
less - arata un fisier text in terminal
grep - cauta ceva intr-un fisier ()
	grep root users_list.txt 
	grep -v root users_list.txt
-v - inversarea cautarii

wc - word count - linii, caractere, cuvinte
	-l - nr linii
	-w - nr cuv
	-m - nr caractere
	
cut - filtreaza informatia dintr-un ouput 
	ex - sa se afiseze/extraga/foloseasca doar anumite caractere


## Variabile

cum se declara: numele acesteia + "=" + o val pe care vrem sa o atribuim
	variabilele sunt doar string-uri

Var de mediu - variabile globale
	USER
	HOME
	PATH

**ls - l** - ne afiseaza detaliile unui fisier