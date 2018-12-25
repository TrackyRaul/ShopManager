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
        setNome(nome);
        setProdotti(new ArrayList());
    }
    
    

    @Override
    public String toString() {
        String stringa = getNome() + "\n";
        for (int i = 0; i < getProdotti().size(); i++) {
            stringa += ((Prodotto) getProdotti().get(i)).toString() + "\n";

        }

        return stringa;
    }
    public void svuota(){
        getProdotti().clear();
    }
    /**
     * Rimuovi un prodotto dal carrello
     * 
     * @param nome
     */
    public void rimuoviProdotto(String nome){
        getProdotti().remove(getProdottoByNome(nome));
    }
    /**
     * Aggiungi un prodotto fisico
     *
     * @param prodotto
     */
    public void aggiungiProdotto(ProdottoFisico prodotto) {
        boolean aggiungibile = true;
        for (int i = 0; i < getProdotti().size(); i++) {
            if (((Prodotto) getProdotti().get(i)).getNome().equals(prodotto.getNome())) {
                aggiungibile = false;
                break;
            }

        }
        if(aggiungibile){
            getProdotti().add(prodotto);
            ((ProdottoFisico)getProdotti().get(getProdotti().size()-1)).setId(getProdotti().indexOf(prodotto));
        }else{
            throw new IllegalArgumentException("Questo prodotto esiste gia!");
            
        }

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
     * Cerca prodotti in base a quanto simile e il nome
     *
     * @param nome
     * @return a
     */
    public ArrayList getProdottiByNome(String nome) {
        ArrayList a = new ArrayList();
        for (int i = 0; i < getProdotti().size(); i++) {
            String temp = (((ProdottoFisico) getProdotti().get(i)).getNome());
            if (temp.contains(nome)){
                a.add((ProdottoFisico) getProdotti().get(i));
            }

        }
        return a;
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
            if (((ProdottoFisico) getProdotti().get(i)).getNome().equals(nome)) {
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
