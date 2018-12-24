package shopmanager;

import java.util.ArrayList;

/**
 *
 * @author Raul Farkas
 */
public class ListaProdottiDigitali {

    private String nome;
    private ArrayList prodotti;

    /**
     * Costruttore per la lista dei prodotti
     *
     * @param nome
     */
    public ListaProdottiDigitali(String nome) {
        this.nome = nome;
        this.prodotti = new ArrayList();
    }

    /**
     * Aggiungi un prodotto digitale
     *
     * @param prodotto
     */
    public void aggiungiProdotto(ProdottoDigitale prodotto) {
        getProdotti().add(prodotto);
    }

    /**
     * Cerca prodotto in base all'id
     *
     * @param id
     * @return prodotto
     */
    public ProdottoDigitale getProdottoById(String id) {
        ProdottoDigitale prodotto = null;
        for (int i = 0; i < getProdotti().size(); i++) {
            if (((ProdottoDigitale) getProdotti().get(i)).getId().equals(id)) {
                prodotto = (ProdottoDigitale) getProdotti().get(i);
            }

        }
        return prodotto;
    }

    /**
     * Cerca prodotto in base al nome
     *
     * @param nome
     * @return prodotto
     */
    public ProdottoDigitale getProdottoByNome(String nome) {
        ProdottoDigitale prodotto = null;
        for (int i = 0; i < getProdotti().size(); i++) {
            if (((ProdottoDigitale) getProdotti().get(i)).getNome().equals(nome)){
                prodotto = (ProdottoDigitale) getProdotti().get(i);
            }

        }
        return prodotto;
    }

    /**
     * Getter
     *
     * @return nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Setter
     *
     * @param nome
     */
    private void setNome(String nome) {
        this.nome = nome;
    }

    /**
     *
     * @return
     */
    public ArrayList getProdotti() {
        return prodotti;
    }

    private void setProdotti(ArrayList prodotti) {
        this.prodotti = prodotti;
    }

}
