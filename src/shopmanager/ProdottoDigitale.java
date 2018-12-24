package shopmanager;

/**
 *
 * @author Raul Farkas
 */
public class ProdottoDigitale extends Prodotto {
    private String id;
    private boolean disponibile;
    private String nome;
    private double prezzo;

    /**
     *
     * @param id
     * @param disponibile
     * @param nome
     * @param prezzo
     */
    public ProdottoDigitale(String id, boolean disponibile, String nome, double prezzo) {
        setId(id);
        setDisponibile(disponibile);
        setNome(nome);
        setPrezzo(prezzo);
    }
    
    /**
     * Getter
     * 
     * @return id
     */
    @Override
    public String getId() {
        return id;
    }
    
    /**
     * Setter
     *  
     * @param id
     */
    @Override
    public void setId(String id) {
        this.id = id;
    }
    
    /**
     * Getter is type
     * 
     * @return disponibile
     */
    @Override
    public boolean isDisponibile() {
        return disponibile;
    }
    
    /**
     * Setter
     * 
     * @param disponibile
     */
    @Override
    public void setDisponibile(boolean disponibile) {
        this.disponibile = disponibile;
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
     * @return prezzo
     */
    @Override
    public double getPrezzo() {
        return prezzo;
    }

    /**
     * Setter
     * 
     * @param prezzo
     */
    @Override
    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }
    
}
