package shopmanager;

import java.util.ArrayList;

/**
 * Classe main
 * Repository GitHub: https://github.com/TrackyRaul/ShopManager
 * 
 * @author Raul Farkas
 */
public class ShopManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Variabili
        // Variabile globale input utente
        String userInput;

        // Gestione utenti
        String username;
        String pwd;
        String nome;
        String cognome;
        Utente utenteIn = null;
        Utente utente;
        ListaUtenti lu = new ListaUtenti("Utenti");

        // Gestione prodotti
        ListaProdottiFisici lp = new ListaProdottiFisici("Prodotti");
        ListaProdottiFisici carrello = new ListaProdottiFisici("Carrello");
        ProdottoFisico prodotto = null;
        boolean disponibile;
        String nomeProdotto;
        double prezzo;
        int numeroPezziDisponibili;

        // Messaggio iniziale
        Tools.println("Benvenuto su ShopManager");
        Tools.println("Il contenuto inserito in questo programma non viene salvato!");
        Tools.println("Comandi disponibili: /registrati, /login, /exit, /info");

        do {
            // Input da tastiera
            userInput = "";

            // Prompt costumizzato
            if (utenteIn != null) {
                userInput = Tools.input("\n" + utenteIn.getNome() + " >>>> ");
            } else {
                userInput = Tools.input("\n>>>> ");
            }
            switch (userInput) {
                case "/info":
                    Tools.println("Questo programma simula il funzionamento di uno shop online."
                            + "\nPer poter aggiungere prodotti registrarsi con l'username admin!"
                            + "\nUna volta chiuso il programma i dati vengono persi.");
                    break;
                case "/registrati":
                    // Crea un nuovo utente
                    try {
                        username = Tools.input("Inserire un username:");
                        pwd = Tools.input("Inserire una password:");
                        nome = Tools.input("Inserire il nome: ");
                        cognome = Tools.input("Inserire il cognome: ");
                        utente = new Utente(nome, cognome, username, pwd);

                        // Se l'utente ha admin come username allora ha i privilegi admin 
                        if (username.equals("admin")) {
                            utente.setTipo("Admin");
                        }
                        lu.aggiungiUtente(utente);
                    } catch (Exception e) {
                        Tools.println("\n" + e);

                    }
                    break;
                case "/login":
                    try {
                        // Controlla se l'utente e collegato
                        if (utenteIn == null) {
                            // Richiedi dati per il login
                            username = Tools.input("Inserire l'username: ");
                            String pswd = Tools.input("Inserire la password: ");

                            // Controlla se l'utente esiste
                            utente = lu.getUtenteByNome(username);

                            // Controlla password
                            if (utente.getPassword().equals(pswd)) {
                                utenteIn = utente;
                                Tools.print("Ciao " + utenteIn.getNome() + "!");

                                // Messaggi dopo il login
                                if (utenteIn.getTipo() == "Normale") {
                                    Tools.println("Comandi: /info, /mostraprodotti, /cercaprodotto, /aggingialcarrello, /mostracarrello, /cancelladalcarrello, /svuotacarrello, /acquista, /logout");
                                } else if (utenteIn.getTipo() == "Admin") {
                                    Tools.println("\nComandi: /info, /aggiungiprodotto, /mostraprodotti, /cercaprodotto, /aggingialcarrello, /mostracarrello, /eliminaprodotto, /cancellaprodotto, /cancelladalcarrello, /svuotacarrello, /svuotaprodotti, /acquista, /logout");
                                }

                            } else {
                                Tools.print("Login fallito, ritenta o crea un account!");
                            }
                        } else {
                            Tools.println("Utente gia collegato!");
                        }
                    } catch (Exception e) {
                        Tools.println(e.toString());

                    }

                    break;
                case "/mostraprodotti":
                    // Stampa su video i prodotti utilizzando i vari toString
                    if (utenteIn != null) {
                        Tools.print(lp.toString());
                    } else {
                        Tools.println("Devi prima entrare con username e passwords!");
                    }
                    break;
                case "/aggiungiprodotto":
                    try {
                        // Controlla se l'utente e admin
                        if (utenteIn != null && utenteIn.getTipo() == "Admin") {
                            // Aggiungi il prodotto
                            disponibile = Boolean.parseBoolean(Tools.input("Inserisci disponiblita(true o false): "));
                            nomeProdotto = Tools.input("Inserire il nome: ");
                            prezzo = Double.parseDouble(Tools.input("Inserire il prezzo: "));
                            numeroPezziDisponibili = Integer.parseInt(Tools.input("Inserire il numero di pezzi disponibili: "));
                            prodotto = new ProdottoFisico(disponibile, nomeProdotto, prezzo, numeroPezziDisponibili);
                            lp.aggiungiProdotto(prodotto);

                        } else {
                            Tools.println("Devi essere entrato come amministratore!");
                        }
                    } catch (Exception e) {
                        Tools.println(e.toString());
                    }
                    break;
                case "/cercaprodotto":
                    if (utenteIn != null) {
                        // Cerca il prodotto nella lista prodotti
                        String nomeProdottoCercato = Tools.input("Inserisci il nome: ");
                        ArrayList a = lp.getProdottiByNome(nomeProdottoCercato);
                        for (int i = 0; i < a.size(); i++) {
                            Tools.println(((ProdottoFisico) a.get(i)).toString());
                        }

                    } else {
                        Tools.println("Devi prima entrare con username e passwords!");
                    }
                    break;
                case "/aggiungialcarrello":
                    if (utenteIn != null) {
                        // Aggiungi un prodotto nel carello in base al nome
                        nomeProdotto = Tools.input("Inserisci il nome del prodotto: ");
                        prodotto = lp.getProdottoByNome(nomeProdotto);
                        if (prodotto != null) {
                            carrello.aggiungiProdotto(prodotto);
                        } else {
                            Tools.println("Il prodotto che vuoi aggiungere non esiste");
                        }
                    }
                    break;
                case "/cancelladalcarrello":
                    if (utenteIn != null) {
                        try {
                            // Cancella il prodotto dal carrello
                            nomeProdotto = Tools.input("Inserisci il nome del prodotto: ");
                            carrello.rimuoviProdotto(nomeProdotto);
                        } catch (Exception e) {
                            Tools.println(e.toString());
                        }
                    }
                    break;
                case "/cancellaprodotto":
                    if (utenteIn != null && utenteIn.getTipo() == "Admin") {
                        try {
                            // Cancella il prodotto dalla lista di prodotti 
                            nomeProdotto = Tools.input("Inserisci il nome del prodotto: ");
                            lp.rimuoviProdotto(nomeProdotto);
                        } catch (Exception e) {
                            Tools.println(e.toString());
                        }
                    }
                    break;
                case "/svuotaprodotti":
                    if (utenteIn != null && utenteIn.getTipo() == "Admin") {
                        // Elimina tutti i prodotti dalla lista prodotti
                        lp.svuota();
                    }
                    break;
                case "/svuotacarrello":
                    if (utenteIn != null) {
                        // Elimina i prodotti dal carrello
                        carrello.svuota();
                    }
                    break;
                case "/mostracarrello":
                    if (utenteIn != null) {
                        // Mostra i prodotti nel carrello
                        Tools.println(carrello.toString());
                    }
                    break;
                case "/acquista":
                    if (utenteIn != null) {
                        // Mostra il carrello con la somma in euro da spendere
                        Tools.println(carrello.toString());
                        double somma = 0;
                        for (int i = 0; i < carrello.getProdotti().size(); i++) {
                            somma += ((ProdottoFisico) carrello.getProdotti().get(i)).getPrezzo();
                        }
                        Tools.println("Totale euro: " + Double.toString(somma));
                        Tools.println("Inserire i dati personali:");
                        // Inserire ulteriori dati per la spedizione
                        int eta = Integer.parseInt(Tools.input("Inserisci la tua eta: "));
                        String indirizzo = Tools.input("Inserire l'indirizzo: ");
                        utenteIn.impostaDatiPersonali(eta, indirizzo);
                        // Controlla conferma ordine
                        boolean conferma = Boolean.parseBoolean(Tools.input("Sei sicuro di voler acquistare?(true o false): "));
                        if (conferma) {
                            Tools.println("Prodotti acquistati!");
                            Tools.println("Verra spedito a: " + utenteIn.getIndirizzo());
                            carrello.svuota();
                        } else {
                            Tools.println("Ordine anullato!");
                        }

                    }
                    break;
                case "/logout":
                    // Chiudi sessione come utente
                    if (utenteIn != null) {
                        utenteIn = null;
                        Tools.println("Utente scollegato!");
                    }
                    break;
                default:
                    Tools.println("Errore, comando non riconosciuto!");
                    break;
            }

        } while (!userInput.equals("/exit"));

    }

}
