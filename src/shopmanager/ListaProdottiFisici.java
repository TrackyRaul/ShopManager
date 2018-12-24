package shopmanager;

import java.util.ArrayList;

/**
 *
 * @author Raul Farkas
 */
public class ListaProdottiFisici {

    private String nome;
    private ArrayList prodotti;

    /**
     * Costruttore per la lista dei prodotti
     *
     * @param nome
     */
    public ListaProdottiFisici(String nome) {
        this.nome = nome;
        this.prodotti = new ArrayList();
    }

    /**
     * Aggiungi un prodotto fisico
     *
     * @param prodotto
     */
    public void aggiungiProdotto(ProdottoFisico prodotto) {
        getProdotti().add(prodotto);
    }

    /**
     * Cerca prodotto in base all'id
     *
     * @param id
     * @return prodotto
     */
    public ProdottoFisico getProdottoById(String id) {
        ProdottoFisico prodotto = null;
        for (int i = 0; i < getProdotti().size(); i++) {
            if (((ProdottoFisico) getProdotti().get(i)).getId().equals(id)) {
                prodotto = (ProdottoFisico) getProdotti().get(i);
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
    public ProdottoFisico getProdottoByNome(String nome) {
        ProdottoFisico prodotto = null;
        for (int i = 0; i < getProdotti().size(); i++) {
            if (((ProdottoFisico) getProdotti().get(i)).getNome().equals(nome)){
                prodotto = (ProdottoFisico) getProdotti().get(i);
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
