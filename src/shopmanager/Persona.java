package shopmanager;

/**
 * Classe astratta persona
 * 
 * @author Raul Farkas
 */
public abstract class Persona {
    
    abstract String getNome();
    abstract void setNome(String nome);
    abstract String getCognome();
    abstract void setCognome(String cognome);
    abstract void setEta(int eta);
    abstract int getEta();
    abstract String getIndirizzo();
    abstract void setIndirizzo(String indirizzo);
    
}
