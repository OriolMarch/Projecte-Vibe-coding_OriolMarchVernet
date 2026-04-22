<div align="center">

# 🌸 Bug Hunter: The Last Commit 🌸
### *Microvideojoc textual de combats per torns en Java* 💻⚔️

<img src="https://img.shields.io/badge/Java-Project-ffb6d9?style=for-the-badge" />
<img src="https://img.shields.io/badge/Status-In%20Development-c8a2ff?style=for-the-badge" />
<img src="https://img.shields.io/badge/Type-Turn%20Based%20Game-ffd6a5?style=for-the-badge" />
<img src="https://img.shields.io/badge/IDE-IntelliJ%20IDEA-bde0fe?style=for-the-badge" />

<br>

### ✨ *“Debugging the chaos, one bug at a time...”* ✨

</div>

---

## 🌷 Descripció del projecte

**Bug Hunter: The Last Commit** és un microvideojoc desenvolupat en **Java** com a projecte acadèmic d’**Entorns de Desenvolupament**.

Es tracta d’un **joc textual de combats per torns**, on el jugador assumeix el rol d’un desenvolupador que ha d’eliminar errors crítics del sistema abans que el projecte col·lapsi del tot.  
La proposta està pensada per ser **simple, funcional, viable i ben estructurada**, prioritzant la lògica interna, el modelatge i la qualitat del desenvolupament per sobre dels elements visuals.

---

## 🎀 Objectiu del joc

L’objectiu principal és **derrotar tots els enemics** representats com a bugs del sistema, gestionant correctament la vida, la defensa i les accions disponibles durant cada combat.

El jugador guanya quan supera tots els combats.  
La partida acaba en derrota si la seva vida arriba a **0 o menys**.

---

## 🕹️ Mecàniques principals

El joc funciona amb un sistema de **combats per torns**.

### Accions del jugador
- **Atacar** → fa dany directe a l’enemic
- **Defensar-se** → redueix el dany rebut al següent atac
- **Recuperar vida** → restaura una part de la salut, amb usos limitats
- **Depuració arriscada** → acció especial amb resultat variable

### Sistema de combat
- El jugador tria una acció
- L’acció s’aplica
- Si l’enemic continua viu, ataca
- Els estats del joc s’actualitzen
- El cicle es repeteix fins a victòria o derrota

---

## 💖 Característiques del projecte

- 🎮 Joc completament funcional en consola
- 🔁 Bucle de joc clar i repetible
- ❤️ Gestió d’estats interns del joc
- ⚔️ Sistema de combat per torns
- 🧩 Estructura modular pensada per ser escalable
- 🧪 Fàcil de provar i depurar
- 📘 Dissenyat per documentar tot el procés de desenvolupament
- 🌸 Idea viable dins del límit temporal del projecte

---

## 🌼 Estructura del repositori

```bash
BugHunter-TheLastCommit/
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
│   ├── 03_entorn_i_prototip.md
│   ├── 04_proves_i_depuracio.md
│   └── 05_millores_i_reflexio_final.md
│
├── diagrames/
│   ├── diagrama_classes.png
│   └── diagrama_comportament.png
│
├── IA_log.md
└── README.md
```

---

## 🌟 Tecnologies utilitzades

- **Java**
- **IntelliJ IDEA Community Edition**
- **Git**
- **GitHub**
- **draw.io** o **PlantUML** per a diagrames
- **ChatGPT** com a suport per a ideació, revisió i documentació

---

## 🧠 Estructura lògica del joc

El projecte està pensat per treballar una estructura clara basada en responsabilitats separades:

### `Player`
Gestiona les dades i accions del jugador:
- vida
- defensa
- curacions disponibles
- accions de combat

### `Enemy`
Representa cada bug o enemic:
- nom
- vida
- atac
- comportament bàsic

### `Combat`
Controla la lògica de cada enfrontament:
- torn del jugador
- torn de l’enemic
- aplicació d’efectes
- comprovació de derrota o victòria

### `Game`
Coordina el flux global de la partida:
- inici del joc
- progressió entre combats
- estat general
- final de partida

### `Main`
Punt d’entrada del programa.

---

## 🔁 Bucle principal del joc

El bucle del joc segueix aquesta seqüència:

1. Mostrar l’estat actual del combat
2. Mostrar les opcions disponibles
3. Llegir la decisió del jugador
4. Validar l’entrada
5. Aplicar l’acció escollida
6. Executar el torn de l’enemic si continua viu
7. Actualitzar els estats interns
8. Comprovar victòria o derrota
9. Repetir

Aquest bucle és el nucli del sistema i dona coherència a tota la implementació.

---

## 🌈 Estats del joc

Alguns dels estats principals que es gestionen al llarg de la partida són:

- `vidaJugador`
- `vidaEnemic`
- `recuperacionsRestants`
- `defensaActiva`
- `enemicsDerrotats`
- `estatPartida`

Aquests valors evolucionen durant el joc i determinen el comportament del sistema en cada moment.

---

## 💥 Condicions de victòria i derrota

### ✅ Victòria
El jugador derrota tots els bugs o enemics del sistema.

### ❌ Derrota
La vida del jugador arriba a 0 o menys abans d’acabar tots els combats.

---

## 🧪 Proves i depuració

Aquest projecte inclou una fase específica de verificació per comprovar:

- funcionament correcte del bucle principal
- validació de les entrades de l’usuari
- comportament esperat de les accions
- actualització correcta dels estats
- detecció i correcció d’errors lògics

La idea no és només que el joc “funcioni”, sinó demostrar que es pot **provar, analitzar i millorar** com qualsevol altre sistema software.

---

## 🌸 Com executar el projecte

### Opció 1. Des d’IntelliJ IDEA
1. Obrir el projecte a IntelliJ
2. Verificar que el JDK estigui configurat correctament
3. Obrir `Main.java`
4. Executar el programa

### Opció 2. Des de terminal
```bash
javac src/*.java
java src/Main
```

> *La forma exacta pot variar segons l’estructura final de paquets del projecte.*

---

## 🎐 Objectius acadèmics del projecte

Aquest microvideojoc no està pensat com un producte comercial ni com un joc visualment complex.  
El seu valor principal és servir com a evidència de les diferents fases del desenvolupament de programari:

- anàlisi de la idea
- delimitació de l’abast
- modelatge
- implementació
- proves i depuració
- millora i refactorització
- documentació del procés

Per tant, el focus principal és **pensar i treballar com un desenvolupador**, no només escriure codi perquè sí.

---

## 🩷 Ús de la IA

La intel·ligència artificial s’ha utilitzat com a eina de suport per:

- explorar alternatives de joc
- comparar mecàniques
- revisar la viabilitat de la proposta
- millorar la redacció de la documentació
- identificar possibles riscos o punts febles

La IA no s’ha utilitzat per substituir el disseny ni la comprensió del projecte, sinó com a suport per prendre decisions amb més criteri.

---

## 🌟 Estat del projecte

📌 **Fase actual:** desenvolupament acadèmic per fases

- [x] Idea i abast
- [ ] Modelatge del sistema
- [ ] Prototip funcional
- [ ] Proves i depuració
- [ ] Millores i reflexió final

---

## 👤 Autor

**Oriol March Vernet**  
Projecte individual per al mòdul d’**Entorns de Desenvolupament**  
Cicle formatiu **1r DAM**

---

## 💌 Nota final

Aquest projecte busca demostrar que un microvideojoc petit també pot estar **ben pensat, ben documentat i ben desenvolupat**.  
No cal crear un joc gegant per demostrar criteri tècnic.

<div align="center">

### 🌸 Thanks for visiting this cute little repo 🌸
**Made with logic, caffeine and emotional damage** ♡

</div>
