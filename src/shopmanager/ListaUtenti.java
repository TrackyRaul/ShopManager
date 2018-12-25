package shopmanager;

import java.util.ArrayList;

/**
 * Classe racoglitrice per gli oggetti di tipo Utente
 *
 * @author Raul Farkas
 */
public class ListaUtenti {

    private String nome;
    private ArrayList listaUtenti;

    /**
     * Costruttore
     *
     * @param nome
     * @param listaUtenti
     */
    public ListaUtenti(String nome, ArrayList listaUtenti) {
        setNome(nome);
        setListaUtenti(listaUtenti);
    }

    /**
     * Costruttore
     *
     * @param nome
     */
    public ListaUtenti(String nome) {
        setNome(nome);
        setListaUtenti(new ArrayList());

    }

    /**
     * Ritorna l'utente se esiste in base al nome
     *
     * @param nome
     * @return
     */
    public Utente getUtenteByNome(String nome) {
        Utente u = null;
        if (esisteUtente(nome) == true) {
            for (int i = 0; i < getListaUtenti().size(); i++) {
                if (((Utente) getListaUtenti().get(i)).getUsername().equals(nome)) {
                    u = (Utente) getListaUtenti().get(i);
                }
            }
        } else {
            throw new IllegalArgumentException("L'utente non esiste!");

        }
        return u;

    }

    /**
     * Controlla se un utente esite
     *
     * @param nome
     * @return esiste
     */
    public boolean esisteUtente(String nome) {
        boolean esiste = false;
        for (int i = 0; i < getListaUtenti().size(); i++) {
            if (((Utente) getListaUtenti().get(i)).getUsername().equals(nome)) {
                esiste = true;

            }

        }

        return esiste;
    }

    /**
     * Aggiungi utente all'ArrayList
     *
     * @param utente
     */
    public void aggiungiUtente(Utente utente) {
        boolean aggiungibile = true;
        for (int i = 0; i < getListaUtenti().size(); i++) {
            if (((Utente) getListaUtenti().get(i)).getUsername().equals(utente.getUsername())) {
                aggiungibile = false;
            }
        }

        if (aggiungibile == true) {
            listaUtenti.add(utente);
        } else {
            throw new IllegalArgumentException("L'utente con questo username esiste gia!");
        }

    }

    /**
     * Rimuovi utente in base al nome se esiste
     *
     * @param nome
     */
    public void rimuuoviUtente(String nome) {
        for (int i = 0; i < getListaUtenti().size(); i++) {
            if (((Utente) getListaUtenti().get(i)).getUsername().equals(nome)) {
                getListaUtenti().remove(i);
                break;

            }
        }
    }

    /**
     * Getter
     *
     * @return
     * @ nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Setter
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Getter
     *
     * @return listaUtenti
     */
    public ArrayList getListaUtenti() {
        return listaUtenti;
    }

    /**
     * Setter
     *
     * @param listaUtenti
     */
    private void setListaUtenti(ArrayList listaUtenti) {
        this.listaUtenti = listaUtenti;
    }

}
