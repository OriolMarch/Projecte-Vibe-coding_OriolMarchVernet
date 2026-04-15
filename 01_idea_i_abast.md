## 1. Títol provisional del joc

**Bug Hunter: The Last Commit**

---

## 2. Tipus de microvideojoc escollit

El microvideojoc escollit és un **joc de combats per torns en format textual**, desenvolupat en consola.

Aquesta tipologia s’ajusta bé als requisits del projecte perquè permet definir amb claredat un bucle de joc, gestionar estats interns del sistema i estructurar la solució mitjançant classes i responsabilitats diferenciades. A més, és una proposta assumible dins del límit temporal establert i evita dependències innecessàries relacionades amb gràfics, animacions o interfícies complexes.

---

## 3. Objectiu del joc

L’objectiu del joc és derrotar una seqüència d’enemics, representats com a bugs crítics del sistema, abans que la vida del jugador arribi a zero.

La idea general és que el jugador assumeixi el paper d’un desenvolupador que ha de restaurar un projecte afectat per errors greus. Cada combat superat representa una fase de recuperació del sistema fins a arribar a la resolució final de la partida.

---

## 4. Rol del jugador

El jugador controla un **desenvolupador** dins d’un sistema de combats per torns.

Durant cada torn, podrà escollir una de les accions següents:

- **Atacar**: infligeix dany directe a l’enemic.
- **Defensar-se**: redueix el dany rebut durant el següent atac enemic.
- **Recuperar vida**: restaura una quantitat de vida limitada, amb un nombre màxim d’usos.
- **Depuració arriscada**: acció especial amb resultat variable, que pot tenir gran efectivitat o bé fallar.

El jugador no controla moviment ni exploració, ja que el focus del joc se centra exclusivament en la presa de decisions dins del combat.

---

## 5. Regles bàsiques

Les regles principals del joc són les següents:

- La partida es divideix en una successió de combats individuals.
- Cada combat es resol mitjançant un sistema de torns.
- En cada torn, el jugador només pot executar una acció.
- Després de l’acció del jugador, l’enemic actua automàticament si encara no ha estat derrotat.
- El jugador disposa d’una quantitat limitada de vida i d’usos de recuperació.
- L’acció de defensa només s’aplica al següent atac rebut.
- Quan l’enemic és derrotat, es passa al següent combat.
- Quan la vida del jugador arriba a zero o menys, la partida finalitza immediatament.

Aquestes regles defineixen un sistema senzill però suficientment estructurat per demostrar control del flux, gestió d’estat i validació del comportament del programa.

---

## 6. Condicions de victòria i derrota

### Condició de victòria
La partida es considera superada quan el jugador derrota tots els enemics definits en la seqüència de combats.

### Condició de derrota
La partida es considera perduda quan la vida del jugador arriba a **0 o menys** abans d’haver superat tots els combats.

---

## 7. Bucle principal del joc

El bucle principal del joc serà el següent:

1. Mostrar l’estat actual del combat.
2. Mostrar les accions disponibles.
3. Llegir l’entrada de l’usuari.
4. Validar que l’opció introduïda sigui correcta.
5. Aplicar l’acció escollida pel jugador.
6. Comprovar si l’enemic ha estat derrotat.
7. Si l’enemic continua viu, executar la seva acció.
8. Actualitzar els estats interns del joc.
9. Comprovar si s’ha assolit una condició de victòria o derrota.
10. Repetir el procés mentre la partida estigui en curs.

Aquest bucle constitueix el nucli funcional del joc i serà la base per a la seva implementació, modelatge i posterior verificació.

---

## 8. Repte principal i dificultat

### Repte principal
El repte principal del joc consisteix a gestionar correctament els recursos disponibles i decidir l’acció més adequada en cada torn.

El jugador haurà d’escollir quan convé atacar, quan és preferible defensar-se i en quin moment cal utilitzar la recuperació de vida. Per tant, el valor del joc no rau en la rapidesa d’execució, sinó en la presa de decisions dins d’un sistema limitat però coherent.

### Nivell de dificultat
La dificultat prevista és **baixa-mitjana**.

Aquesta dificultat s’ha escollit expressament per mantenir l’abast del projecte dins d’un nivell realista. L’objectiu no és desenvolupar un joc especialment difícil, sinó un sistema funcional, equilibrat i demostrable dins del temps disponible.

---

## 9. Limitacions explícites

Per delimitar correctament l’abast del projecte, s’estableixen les limitacions següents:

- no s’inclourà interfície gràfica avançada;
- no s’afegiran animacions;
- no s’inclourà música ni efectes de so;
- no hi haurà sistema de nivells complex;
- no es desenvoluparà un inventari elaborat;
- no s’inclouran mapes, exploració ni moviment espacial;
- no hi haurà història ramificada amb múltiples finals;
- no s’implementarà guardat de partida;
- no s’afegirà funcionalitat multijugador;
- no s’utilitzaran bases de dades ni fitxers externs;
- no es programarà una IA enemiga avançada.

Aquestes limitacions responen a una decisió de disseny conscient: prioritzar una estructura clara i un desenvolupament complet abans que una complexitat superficial.

---

## 10. Riscos tècnics

### Risc 1. Validació incorrecta de l’entrada de l’usuari
En un entorn de consola, l’usuari pot introduir valors no previstos o opcions fora del rang esperat.

**Impacte possible:**  
El joc pot generar errors d’execució o comportaments no controlats.

**Mesura prevista:**  
Validar totes les entrades abans de processar-les i repetir la petició en cas de dada invàlida.

---

### Risc 2. Gestió incorrecta dels estats del combat
Els valors del joc, com ara la vida, la defensa activa o els usos de recuperació, poden quedar desactualitzats o modificar-se en un ordre incorrecte.

**Impacte possible:**  
Poden aparèixer errors lògics, com aplicar efectes dues vegades o permetre accions no permeses.

**Mesura prevista:**  
Organitzar les actualitzacions d’estat en mètodes específics i controlar amb precisió l’ordre d’execució de cada torn.

---

### Risc 3. Desequilibri del sistema de combat
Si els valors de vida, atac o recuperació no estan ben ajustats, la partida pot resultar trivial o excessivament difícil.

**Impacte possible:**  
El joc perd interès, consistència i valor com a prototip funcional.

**Mesura prevista:**  
Fer proves amb valors inicials simples i ajustar progressivament el balanç segons els resultats observats.

---

## 11. Exploració amb IA (mínim 2 prompts + resposta resumida)

### Prompt 1
**Prompt utilitzat:**  
`Proposa 3 idees de microvideojoc per fer en Java en menys de 10 hores. Han de tenir un bucle de joc clar, estats interns i ser fàcils de modelar amb UML.`

**Resposta resumida:**  
La IA va suggerir tres alternatives principals:
- joc textual d’aventura;
- joc de combats per torns;
- joc de supervivència o gestió de recursos.

**Valoració crítica:**  
El joc textual d’aventura resultava interessant, però implicava generar massa contingut narratiu i diverses branques de decisió.  
El joc de supervivència era viable, però afegia més complexitat en la gestió simultània de variables.  
El joc de combats per torns destacava per la seva simplicitat estructural, per la facilitat d’identificar-ne el bucle principal i per la seva bona adaptació al modelatge amb UML.

---

### Prompt 2
**Prompt utilitzat:**  
`Compara un joc de combats per torns i un quiz gamificat per a un projecte acadèmic curt. Indica quin és més viable de programar, provar, documentar i explicar.`

**Resposta resumida:**  
La IA va concloure que:
- el **quiz gamificat** requeria preparar més contingut, preguntes i opcions;
- el **joc de combats per torns** era més directe de programar, més senzill de provar i més fàcil de documentar.

**Valoració crítica:**  
Aquest resultat va confirmar la decisió inicial. Tot i que el quiz també era factible, el temps invertit en preparar contingut no aportava tant valor tècnic com una estructura de combat per torns, que permet treballar millor la lògica, l’estat i la validació.

---

### Conclusió de l’exploració amb IA
La IA s’ha utilitzat com a eina de suport per explorar alternatives, comparar opcions i delimitar l’abast del projecte. No s’ha fet servir per generar una solució final tancada, sinó per facilitar la presa de decisions amb criteri tècnic.

---

## 12. Proposta final escollida

La proposta final consisteix en el desenvolupament d’un **microvideojoc textual de combats per torns en Java**, executat en consola, amb una estructura modular i estats interns clarament definits.

El sistema inclourà:

- un jugador amb atributs bàsics de combat;
- diversos enemics consecutius;
- un conjunt reduït però suficient d’accions;
- condicions clares de victòria i derrota;
- un bucle principal fàcilment identificable;
- una estructura apta per ser modelada amb diagrames de classes i de comportament.

---

## 13. Justificació de viabilitat

La proposta escollida es considera viable pels motius següents:

- s’ajusta al límit temporal de **10 hores**;
- no requereix tecnologies gràfiques ni eines externes complexes;
- defineix un **bucle de joc clar i repetible**;
- incorpora **estats interns reals**;
- facilita el disseny de casos de prova concrets;
- permet estructurar el codi en classes o mòduls diferenciats;
- és fàcil d’explicar i justificar en el vídeo final;
- manté un equilibri adequat entre simplicitat i valor tècnic.

En conseqüència, és una proposta coherent amb l’objectiu del projecte: demostrar capacitat d’anàlisi, disseny, implementació, verificació i millora d’un sistema funcional.

---

## 14. Mini pla de treball

### Fase 1. Idea i delimitació de l’abast
- seleccionar el tipus de joc;
- definir objectiu, rol, regles, bucle, limitacions i riscos;
- justificar la viabilitat de la proposta.

**Temps estimat:** 1,5 hores

### Fase 2. Modelatge del sistema
- identificar les entitats principals del joc;
- definir atributs i responsabilitats;
- elaborar el diagrama de classes;
- elaborar el diagrama de comportament.

**Temps estimat:** 2 hores

### Fase 3. Desenvolupament del prototip funcional
- configurar el projecte en l’IDE;
- implementar el bucle principal;
- permetre la interacció amb l’usuari;
- generar un resultat final de victòria o derrota.

**Temps estimat:** 2 hores

### Fase 4. Verificació i depuració
- definir casos de prova;
- executar les proves;
- detectar errors o comportaments inesperats;
- aplicar correccions.

**Temps estimat:** 2 hores

### Fase 5. Millora i tancament
- refactoritzar parts del codi;
- millorar noms, estructura i claredat;
- revisar la documentació;
- preparar el lliurament final.

**Temps estimat:** 2 hores

### Marge de revisió
- revisar coherència global;
- fer ajustos finals;
- comprovar que la documentació i el codi coincideixen.

**Temps estimat:** 0,5 hores

---

## 15. Eines previstes i justificació

### Llenguatge de programació principal
**Java**

**Justificació:**  
És el llenguatge corresponent a l’itinerari DAM i resulta adequat per desenvolupar un joc textual amb una estructura clara basada en classes, mètodes i control del flux.

---

### Alternatives possibles
- **Python**: molt viable des del punt de vista tècnic, però no és el llenguatge assignat a l’itinerari DAM.
- **Roblox Studio amb scripts**: opció possible, però menys adequada per a aquest projecte perquè introdueix una complexitat visual i d’entorn innecessària.

---

### Entorn de desenvolupament
**IntelliJ IDEA Community Edition**

**Justificació:**  
És un IDE robust, estable i especialment adequat per a projectes en Java. Facilita l’organització del codi, l’execució del programa i la detecció d’errors.

---

### Control de versions
**Git i GitHub**

**Justificació:**  
Permeten registrar de forma progressiva l’evolució del projecte, mantenir un historial de canvis i aportar evidències reals del procés de desenvolupament.

---

### Suport amb IA
**ChatGPT**

**Justificació:**  
Es farà servir per:
- explorar idees inicials;
- comparar alternatives de disseny;
- revisar l’estructura de la documentació;
- detectar punts febles en la proposta.

La IA s’utilitzarà com a suport analític i de revisió, no com a substitució del disseny ni de la implementació pròpia.

---

### Altres eines
- **draw.io** o **PlantUML** per elaborar diagrames en fases posteriors;
- **JDK estàndard** per compilar i executar el projecte;
- **llibreria estàndard de Java**, especialment `Scanner` i `Random`, per gestionar l’entrada de l’usuari i el comportament del combat.

---

## Conclusió

La proposta definida és un microvideojoc petit, viable i tècnicament coherent amb els requisits del projecte. Presenta un bucle de joc clar, estats interns definits, limitacions explícites, riscos tècnics identificats i una planificació ajustada al temps disponible. Per tant, constitueix una base sòlida per passar a la fase de modelatge i desenvolupament.