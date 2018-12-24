package shopmanager;

/**
 *
 * @author Raul Farkas
 */
public class ProdottoFisico extends Prodotto {

    private String id;
    private boolean disponibile;
    private String nome;
    private double prezzo;
    private int numeroPezziDisponibili;

    /**
     * Costruttore
     *
     * @param id
     * @param disponibile
     * @param nome
     * @param prezzo
     * @param numeroPezziDisponibili
     */
    public ProdottoFisico(String id, boolean disponibile, String nome, double prezzo, int numeroPezziDisponibili) {
        setId(id);
        setDisponibile(disponibile);
        setNome(nome);
        setPrezzo(prezzo);
        setNumeroPezziDisponibili(numeroPezziDisponibili);
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

    /**
     * Getter
     *
     * @return numeroPezziDisponibili
     */
    public int getNumeroPezziDisponibili() {
        return numeroPezziDisponibili;
    }

    /**
     * Setter
     *
     * @param numeroPezziDisponibili
     */
    public void setNumeroPezziDisponibili(int numeroPezziDisponibili) {
        this.numeroPezziDisponibili = numeroPezziDisponibili;
    }

}
