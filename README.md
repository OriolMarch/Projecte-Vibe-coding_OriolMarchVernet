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
