/**
 *
 * @author juhfe
 */
public class Produto {

    //definindo os atributos do Produto

    private int codigo;
    private String nome;
    private double preco;
    private int quantidade;

    public Produto(int codigo, String nome, double preco, int quantidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    Produto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //definindo todos os metodos de encapsulamento (com exceção do setNome e setCodigo pois eles não podem ser alterados)
    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return this.codigo + ";" + this.nome + ";" + this.preco + ";" + this.quantidade;//To change body of generated methods, choose Tools | Templates.
    }

}
