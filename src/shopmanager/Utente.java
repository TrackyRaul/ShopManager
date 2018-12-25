package shopmanager;

/**
 * Classe di tipo utente che contiene tutte le informazione dell'utente
 *
 * @author Raul Farkas
 */
public class Utente extends Persona {

    private String nome;
    private String cognome;
    private int eta;
    private String indirizzo;
    private String username;
    private String password;
    private ListaProdottiFisici carrello;
    private String tipo = "Normale";

    /**
     * Costruttore
     *
     * @param nome
     * @param cognome
     * @param eta
     * @param indirizzo
     * @param username
     * @param password
     */
    public Utente(String nome, String cognome, int eta, String indirizzo, String username, String password) {
        setNome(nome);
        setCognome(cognome);
        setEta(eta);
        setIndirizzo(indirizzo);
        setUsername(username);
        setPassword(password);

    }

    /**
     * Costruttore
     *
     * @param nome
     * @param cognome
     * @param username
     * @param password
     */
    public Utente(String nome, String cognome, String username, String password) {
        setNome(nome);
        setCognome(cognome);
        setPassword(password);
        setUsername(username);
    }

    /**
     * Costruttore
     *
     * @param username
     * @param password
     */
    public Utente(String username, String password) {
        setUsername(username);
        setPassword(password);
    }

    /**
     * Aggiungi informazioni extra riguardo all'utente
     *
     * @param nome
     * @param cognome
     * @param eta
     * @param indirizzo
     */
    public void impostaDatiPersonali(String nome, String cognome, int eta, String indirizzo) {
        setNome(nome);
        setCognome(cognome);
        setEta(eta);
        setIndirizzo(indirizzo);
    }

    /**
     * Getter
     *
     * @return nome
     */
    @Override
    public String getNome() {
        return nome;
    }

    /**
     * Setter
     *
     * @param nome
     */
    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Getter
     *
     * @return cognome
     */
    @Override
    public String getCognome() {
        return cognome;
    }

    /**
     * Setter
     *
     * @param cognome
     */
    @Override
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * Getter
     *
     * @return eta
     */
    @Override
    public int getEta() {
        return eta;
    }

    /**
     * Setter
     *
     * @param eta
     */
    @Override
    public void setEta(int eta) {
        this.eta = eta;
    }

    /**
     * Getter
     *
     * @return indirizzo
     */
    @Override
    public String getIndirizzo() {
        return indirizzo;
    }

    /**
     * Setter
     *
     * @param indirizzo
     */
    @Override
    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    /**
     * Getter
     *
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setter
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Getter
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Ritorna il carrello
     *
     * @return
     */
    public ListaProdottiFisici getCarrello() {
        return carrello;
    }

    /**
     * Getter
     *
     * @return tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Setter
     *
     * @param tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
