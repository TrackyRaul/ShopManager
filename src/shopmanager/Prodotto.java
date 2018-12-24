package shopmanager;

/**
 * Classe astratta del prodotto con metodi base
 * 
 * @author Raul Farkas
 */
public abstract class Prodotto {
    abstract void setId(String id);
    abstract String getId();
    abstract boolean isDisponibile();
    abstract void setDisponibile(boolean disponibile);
    abstract String getNome();
    abstract void setNome(String nome);
    abstract double getPrezzo();
    abstract void setPrezzo(double prezzo);
    
    
}
