package shopmanager;

import java.util.ArrayList;

/**
 *
 * @author Raul Farkas
 */
public class ShopManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Variabili
        String userInput;
        ListaUtenti lu = new ListaUtenti("Utenti");
        ListaProdottiFisici lp = new ListaProdottiFisici("Prodotti");
        ListaProdottiFisici carrello = new ListaProdottiFisici("Carrello");
        ProdottoFisico prodotto = null;
        String username;
        String pwd;
        String nome;
        String cognome;
        Utente utenteIn = null;
        Utente utente;

        boolean disponibile;
        String nomeProdotto;
        double prezzo;
        int numeroPezziDisponibili;

        // Messaggio iniziale
        Tools.println("Benvenuto su ShopManager");
        Tools.println("Il contenuto inserito in questo programma non viene salvato!");
        Tools.println("Comandi disponibili: /registrati, /login, /exit");

        do {
            userInput = "";
            if (utenteIn != null) {
                userInput = Tools.input("\n" + utenteIn.getNome() + " >>>> ");
            } else {
                userInput = Tools.input("\n>>>> ");
            }
            switch (userInput) {
                case "/registrati":
                    try {
                        username = Tools.input("Inserire un username:");
                        pwd = Tools.input("Inserire una password:");
                        nome = Tools.input("Inserire il nome: ");
                        cognome = Tools.input("Inserire il cognome: ");
                        utente = new Utente(nome, cognome, username, pwd);
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
                        if (utenteIn == null) {
                            username = Tools.input("Inserire l'username: ");
                            pwd = Tools.input("Inserire la password: ");
                            utente = lu.getUtenteByNome(username);
                            if (utente.getPassword().equals(pwd)) {
                                utenteIn = utente;
                                Tools.print("Ciao " + utenteIn.getNome() + "!");
                                if (utenteIn.getTipo() == "Normale") {
                                    Tools.println("Comandi: /mostraprodotti, /cercaprodotto, /aggingialcarrello, /mostracarrello, /cancelladalcarrello, /svuotacarrello, /acquista, /logout");
                                } else if (utenteIn.getTipo() == "Admin") {
                                    Tools.println("\nComandi: /aggiungiprodotto, /mostraprodotti, /cercaprodotto, /aggingialcarrello, /mostracarrello, /eliminaprodotto, /cancellaprodotto, /cancelladalcarrello, /svuotacarrello, /svuotaprodotti, /acquista, /logout");
                                }

                            } else {
                                Tools.print("Login fallito, ritenta o crea un account!");
                            }
                        }
                    } catch (Exception e) {
                        Tools.println(e.toString());

                    }

                    break;
                case "/mostraprodotti":
                    if (utenteIn != null) {
                        Tools.print(lp.toString());
                    } else {
                        Tools.println("Devi prima entrare con username e passwords!");
                    }
                    break;
                case "/aggiungiprodotto":
                    try {
                        if (utenteIn != null && utenteIn.getTipo() == "Admin") {
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
                            nomeProdotto = Tools.input("Inserisci il nome del prodotto: ");
                            lp.rimuoviProdotto(nomeProdotto);
                        } catch (Exception e) {
                            Tools.println(e.toString());
                        }
                    }
                    break;
                case "/svuotaprodotti":
                    if (utenteIn != null && utenteIn.getTipo() == "Admin") {
                        lp.svuota();
                    }
                    break;
                case "/svuotacarrello":
                    if (utenteIn != null) {
                        carrello.svuota();
                    }
                    break;
                case "/mostracarrello":
                    if (utenteIn != null) {
                        Tools.println(carrello.toString());
                    }
                    break;
                case "/acquista":
                    if (utenteIn != null) {
                        Tools.println(carrello.toString());
                        double somma = 0;
                        for (int i = 0; i < carrello.getProdotti().size(); i++) {
                            somma += ((ProdottoFisico) carrello.getProdotti().get(i)).getPrezzo();
                        }
                        Tools.println("Totale euro: " + Double.toString(somma));
                        boolean conferma = Boolean.parseBoolean(Tools.input("Sei sicuro di voler acquistare?(true o false): "));
                        if (conferma) {
                            Tools.println("Prodotti acquistati!");
                            carrello.svuota();
                        } else {
                            Tools.println("Ordine anullato!");
                        }

                    }
                    break;
                case "/logout":
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
