# 03_entorn_i_prototip.md

## 1. Evidències del treball fet fins ara

En aquesta fase s’ha configurat l’entorn de desenvolupament i s’ha implementat un primer prototip funcional del microvideojoc **Bug Hunter: The Last Commit**.

Fins aquest moment, les evidències principals del treball realitzat són:

- creació del projecte en Java dins de l’IDE;
- configuració bàsica de l’entorn per compilar i executar el programa;
- definició de l’estructura inicial de classes;
- implementació d’un primer bucle de joc funcional;
- interacció bàsica amb l’usuari mitjançant consola;
- execució d’un combat mínim entre jugador i enemic;
- obtenció d’un resultat final de victòria o derrota;
- registre inicial del procés al repositori GitHub.

Aquest conjunt d’evidències demostra que el projecte ja no es troba només en fase de disseny, sinó que disposa d’una primera versió executable amb funcionalitat real.

---

## 2. IDE utilitzat i configuració bàsica

### IDE utilitzat
L’IDE utilitzat per desenvolupar el projecte ha estat **IntelliJ IDEA Community Edition**.

### Justificació
Aquest entorn s’ha escollit perquè és adequat per a projectes en Java, facilita l’organització per classes, permet executar el programa de forma simple i incorpora eines útils per a la depuració i la navegació pel codi.

### Configuració bàsica aplicada
La configuració inicial realitzada ha estat la següent:

- creació d’un projecte Java nou;
- configuració del **JDK** corresponent;
- creació de la carpeta `src/` per al codi font;
- creació de les classes principals del sistema;
- verificació que el fitxer `Main.java` s’executa correctament;
- estructura inicial del repositori preparada per separar codi, documentació i diagrames.

### Execució del projecte
El projecte es pot executar des de l’IDE obrint el fitxer `Main.java` i executant el mètode `main`.

---

## 3. Decisions inicials d’implementació

Per a aquest primer prototip s’han pres les decisions següents:

### 3.1. Implementació en consola
S’ha decidit treballar amb **entrada i sortida per consola** per evitar complexitat visual innecessària i centrar el desenvolupament en la lògica del joc.

### 3.2. Separació bàsica de responsabilitats
El codi s’ha començat a estructurar en diverses classes, amb una responsabilitat principal per a cadascuna:

- `Main` per iniciar el programa
- `Game` per controlar la partida
- `Player` per gestionar l’estat del jugador
- `Enemy` per representar els enemics
- `Combat` per controlar cada combat

### 3.3. Prototip mínim abans que versió completa
En lloc d’intentar implementar totes les funcionalitats des del principi, s’ha prioritzat obtenir un **vertical slice mínim**, és a dir, una versió petita però executable que ja permeti:

- iniciar la partida;
- mostrar opcions;
- llegir una acció de l’usuari;
- aplicar la lògica del torn;
- arribar a una victòria o derrota.

### 3.4. Validació bàsica d’entrada
Des del prototip inicial s’ha considerat necessari controlar mínimament l’entrada de l’usuari per evitar errors immediats en escollir opcions no vàlides.

---

## 4. Estat actual del prototip funcional

En aquest moment, el prototip permet:

- iniciar el joc des de `Main`;
- crear un jugador amb vida inicial;
- crear almenys un enemic;
- mostrar l’estat del combat;
- oferir opcions d’acció al jugador;
- llegir l’entrada de l’usuari;
- executar un torn de combat;
- actualitzar la vida del jugador i de l’enemic;
- comprovar si hi ha victòria o derrota;
- finalitzar el combat amb un resultat.

Això compleix el requisit mínim de tenir una cosa **mínimament funcional** i executable.

---

## 5. Funcionalitats implementades fins ara

Les funcionalitats implementades en aquest primer prototip són les següents:

### Funcionalitats disponibles
- inici de la partida;
- creació d’un combat simple;
- acció d’atac del jugador;
- atac de resposta de l’enemic;
- actualització d’estats bàsics;
- finalització del combat quan un dels participants es queda sense vida.

### Funcionalitats encara no completes o pendents
- defensa amb efecte temporal complet;
- acció de curació amb límit d’usos;
- acció especial de depuració arriscada;
- seqüència completa de diversos enemics;
- ajust del balanç del combat;
- millora dels missatges de sortida;
- validació més robusta de les entrades.

Aquest enfocament és intencionat: primer s’ha prioritzat tenir un nucli executable i després ampliar-lo progressivament.

---

## 6. Captures de pantalla

A continuació s’inclouran les captures de pantalla que evidencien el treball realitzat.

### Captura 1. Projecte obert a l’IDE
**Descripció:**  
Vista general del projecte a IntelliJ IDEA amb l’estructura inicial de carpetes i classes.

**Fitxer recomanat:**  
`captures/ide_projecte.png`

![Captura de l'IDE amb l'estructura del projecte](captures/ide_projecte.png)

---

### Captura 2. Execució del programa
**Descripció:**  
Execució del joc des de l’IDE mostrant el funcionament bàsic del prototip a la consola.

**Fitxer recomanat:**  
`captures/execucio_prototip.png`

![Execució del prototip a la consola](captures/execucio_prototip.png)

---

### Captura 3. Interacció amb l’usuari
**Descripció:**  
Exemple de lectura d’una acció del jugador i actualització de l’estat del combat.

**Fitxer recomanat:**  
`captures/interaccio_usuari.png`

![Interacció amb l'usuari i bucle de joc](captures/interaccio_usuari.png)

---

## 7. Estructura actual del projecte

L’estructura inicial del projecte en aquest punt és la següent:

```text
bug-hunter-the-last-commit/
│
├── src/
│   ├── Main.java
│   ├── Game.java
│   ├── Player.java
│   ├── Enemy.java
│   └── Combat.java
│
├── docs/
│   ├── 01_idea_i_abast.md
│   ├── 02_model_del_joc.md
│   └── 03_entorn_i_prototip.md
│
├── diagrames/
│   ├── diagrama_classes.png
│   └── diagrama_comportament.png
│
├── captures/
│   ├── ide_projecte.png
│   ├── execucio_prototip.png
│   └── interaccio_usuari.png
│
├── IA_log.md
└── README.md
```

Aquesta estructura manté separats el codi, la documentació i les evidències visuals del projecte.

---

## 8. Commits realitzats fins ara

Durant aquesta fase s’han realitzat commits progressius per deixar evidència de l’evolució del prototip.

### Exemples de commits descriptius
- `Inicialitza el projecte Java i l'estructura del repositori`
- `Afegeix les classes principals del joc`
- `Implementa un primer combat funcional per consola`

Aquests commits permeten demostrar que el desenvolupament s’ha fet de forma progressiva i no només amb una pujada final del resultat.

---

## 9. Valoració breu del prototip

El prototip actual és simple, però ja compleix la funció principal d’aquesta fase: disposar d’una base executable i funcional sobre la qual continuar treballant.

Els aspectes més importants assolits són:

- el projecte s’executa sense errors crítics;
- hi ha interacció real amb l’usuari;
- existeix un bucle de joc mínim;
- es gestiona un estat bàsic de combat;
- ja es pot obtenir un resultat final de partida.

La següent fase consistirà a verificar el comportament del sistema amb casos de prova reals, detectar incidències i aplicar correccions.

---

## 10. Conclusió

En aquesta fase s’ha passat del model teòric a una primera implementació funcional. L’entorn de desenvolupament ha quedat configurat correctament, el projecte s’executa des de l’IDE i el prototip ja permet iniciar una partida, interactuar amb l’usuari i resoldre un combat bàsic.

Això proporciona una base coherent per avançar cap a la fase de verificació, proves i depuració.