# ZADACA_S12
Zadaca Sedmica 12

Text zadatak1 (Benjo )

Program treba da se sastoji iz dvije klase: 1)Article predstavlja novinski clanak 2)ArticleReader predstavlja klasu uz pomoc koje citamo XML file sa odredjenog mjesta(web adresa). Napraviti program uz pomoc kojeg se ucitava rss feed sa portala klix.ba. Treba koristiti samo odredjene XML tagove("title" i "clanak") kako bi se pomocu njih instancirali objekti tipa Article. Zatim User treba da u konzoli unese broj clanka koji zeli vidjeti, a program treba da ispise naslov i sadrzaj clanka pod tim brojem.

Text Zadatak2 ( Vedad xml )


Kreirati neki mini projekat
(videoteka, prodavnica, autobuska stanica ili nesto slicno) 
te kreirati Java klase za taj projekat. Nakon toga napraviti klasu koja ce te podatke snimiti u xml file. 
Nakon toga kreirati jos jednu klasu koja ce podatke iz kreiranog xml filea procitati, 
te napraviti strukturu sa pocetka projekta 
(kao sto bi rekli gamerskim rijecnikom, napraviti save i load podataka)

Text Zadatak3 ( Tarik threads ) 
*Napomena ovu zadacu nisam uradila samo sam prevejzbala sto smo radili na nastavi.

Threads in Java zadatak za samostalni rad

Napisati aplikaciju koja će da iz liste urls (String[], ArrayList<String>, … ili iz fajla) da čita adrese stranica (url) i šalje ih na crawling mehanizam (pojašnjen na predavanjima).

Crawling mehanizam treba da dobavi sardžaj stranice i snimi ga u file sa random generisanim imenom.

Sam proces crawlinga se izvršava u threadovima, a broj threadova je jednak broju url-ova u listi.

Svi threadovi, nakon završenog upisivanja u fajl, otvaraju zajednički fajl crawling_diaries.txt, koji je definisan kao File(putanja/do/crawling_diaries.txt) i u novu liniju pišu koju adresu su i kada crawlali.

Potrebno je imati na umu činjenicu da je crawling_diaries.txt dijeljeni resurs i potrebno je da mehanizam upisa u taj fajl bude thread safe. (synchronise)

Pored upisa u crawling_diaries, potrebno je i da svaki thread ispiše “globalnu” varijablu int pagesCrawled, koju svaki thread povećava za 1.

int pagesCrawled se nalazi u Crawler klasi, kao i File crawlingDiaries.


PARAMETRI:
outputDirectory: /tmp/crawled/
outputFileName: random_generisano_ime.txt
5 < urls < 10

NAPOMENA:
outputDirectory nije prethodno kreiran i potrebno je izvršiti provjeru, da li postoji.Ako ne postoji, potrebno ga je kreirati (kroz kod). 
