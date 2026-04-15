<div align="center">

# 🎮 Bug Hunter: The Last Commit

### *Microvideojoc textual de combats per torns desenvolupat en Java*

Un projecte acadèmic d’**Entorns de Desenvolupament** centrat en el procés complet de construcció d’un sistema:  
**idea → modelatge → prototip → proves → millora**

<br>

<img alt="Java" src="https://img.shields.io/badge/Java-Project-orange?style=flat-square&logo=openjdk&logoColor=white">
<img alt="Status" src="https://img.shields.io/badge/status-in%20progress-blueviolet?style=flat-square">
<img alt="Docs" src="https://img.shields.io/badge/docs-Markdown-111111?style=flat-square&logo=markdown">
<img alt="GitHub" src="https://img.shields.io/badge/versioned%20with-GitHub-black?style=flat-square&logo=github">

</div>

---

## Índex

- [Sobre el projecte](#sobre-el-projecte)
- [Objectiu del joc](#objectiu-del-joc)
- [Mecànica principal](#mecànica-principal)
- [Bucle de joc](#bucle-de-joc)
- [Tecnologies](#tecnologies)
- [Estructura del repositori](#estructura-del-repositori)
- [Fases del desenvolupament](#fases-del-desenvolupament)
- [Execució](#execució)
- [Autor](#autor)

---

## Sobre el projecte

**Bug Hunter: The Last Commit** és un microvideojoc textual on el jugador assumeix el rol d’un desenvolupador que ha d’eliminar bugs crítics d’un sistema abans que aquest col·lapsi.

El projecte ha estat concebut amb un abast reduït i realista, prioritzant:

- la coherència del sistema
- la qualitat de l’estructura
- la documentació del procés
- la viabilitat dins del temps disponible

---

## Objectiu del joc

Derrotar tots els enemics abans que la vida del jugador arribi a zero.

Cada enemic representa un bug del sistema i cada combat obliga el jugador a prendre decisions simples però estratègiques.

---

## Mecànica principal

El joc es basa en un sistema de **combats per torns**.

### El jugador pot:
- atacar
- defensar-se
- recuperar vida
- executar una acció especial de depuració

### El sistema gestiona:
- punts de vida
- torns
- accions limitades
- estat de combat
- victòria i derrota

---

## Bucle de joc

```text
Mostrar estat → llegir acció → validar entrada → aplicar acció →
executar torn enemic → actualitzar estat → comprovar final → repetir
