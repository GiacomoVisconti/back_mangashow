# ✅ Checklist Progetto Manga App

## 1. Pianificazione
- [x] Definire l’entità principale **Manga** con i campi:
  - id
  - titolo
  - autore
  - anno_pubblicazione
  - stato (boolean: false = in corso, true = concluso)
  - numero_volumi
  - descrizione
  - editore
  - copertina_url

### 🔗 Relazioni tra le entità
- [ ] **Manga ↔ Volumi** (1-N: un manga ha più volumi)
- [x] **Manga ↔ Generi** (N-N: un manga può appartenere a più generi)
- [x] **Manga ↔ Autori** (N-N: più autori possono scrivere più manga)
- [ ] **Manga ↔ Case Editrici** (1-N: un editore pubblica più manga)
- [ ] **Manga ↔ Recensioni** (1-N: un manga può avere più recensioni)

### 📑 Campi delle tabelle secondarie
- **Volumi**
  - id
  - numero_volume
  - data_pubblicazione
  - numero_capitoli
  - manga_id (FK)

- **Generi**
  - id
  - nome
  - descrizione

- **Autori**
  - id
  - nome
  - cognome
  - nazionalità

- **Case Editrici**
  - id
  - nome
  - paese
  - anno_fondazione

- **Recensioni**
  - id
  - utente
  - voto (es. da 1 a 5)
  - commento
  - data
  - manga_id (FK)

---

## 2. Database
- [x] Creare lo schema ER con tutte le entità e relazioni.
- [x] Definire chiavi primarie e chiavi esterne.
- [] Implementare vincoli logici (es. stato ↔ numero_volumi).
- [x] Popolare il database con dati di esempio.

---

## 3. Backend Spring (Backoffice con Thymeleaf)
### 3.1 Autenticazione
- [ ] Configurare **Spring Security** per login/logout.
- [ ] Creare ruoli (Admin, Editor).

### 3.2 CRUD
- [x] Implementare CRUD per Manga.
- [ ] Implementare CRUD per Volumi e Capitoli.
- [ ] Implementare CRUD per Generi, Autori, Editori.
- [ ] Implementare CRUD per Personaggi.
- [ ] Implementare CRUD per Recensioni.

### 3.3 Validazioni
- [ ] Validare coerenza tra stato e numero_volumi.
- [ ] Rendere obbligatori i campi principali (titolo, autore, editore).
- [ ] Gestire relazioni coerenti (es. un capitolo deve appartenere a un volume).

---

## 4. API REST
- [ ] Creare endpoint `/api/manga`.
- [ ] Creare endpoint `/api/volumi`.
- [ ] Creare endpoint `/api/capitoli`.
- [ ] Creare endpoint `/api/generi`.
- [ ] Creare endpoint `/api/autori`.
- [ ] Creare endpoint `/api/personaggi`.
- [ ] Creare endpoint `/api/recensioni`.
- [ ] Testare gli endpoint con Postman.

---

## 5. Frontend React (Guest site)
### 5.1 Struttura
- [ ] Creare Home page con lista Manga.
- [ ] Creare pagina dettaglio Manga (info + volumi + generi + autore + editore).
- [ ] Creare pagina dettaglio Volume (lista capitoli).
- [ ] Creare pagina dettaglio Personaggio (manga e capitoli collegati).
- [ ] Creare sezione Recensioni.

### 5.2 Funzionalità
- [ ] Implementare chiamate AJAX alle API REST.
- [ ] Configurare React Router per la navigazione.
- [ ] Creare componenti riutilizzabili (Card Manga, Lista Volumi).
- [ ] Migliorare UI con librerie (Material UI, Bootstrap).

---

## 6. Testing
- [ ] Testare CRUD e relazioni nel backend.
- [ ] Testare navigazione e rendering dati nel frontend.
- [ ] Verificare integrazione tra React e API REST.

---

## 7. Extra (Opzionale)
- [ ] Implementare ricerca e filtri (titolo, genere, autore).
- [ ] Aggiungere rating medio dei Manga.
- [ ] Implementare paginazione per liste lunghe.
- [ ] Aggiungere immagini di copertina per i Manga.

---

## 8. Consegna finale
- [ ] Backoffice completo con autenticazione e CRUD.
- [ ] API REST funzionanti.
- [ ] Frontend React con visualizzazione dati e relazioni.
- [ ] Documentazione del progetto (README con istruzioni).
