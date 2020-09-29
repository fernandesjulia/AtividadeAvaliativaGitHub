import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juhfe
 */
public class fakeBancoDados {

    //vetor dinâmico estático para armazenar todos os produtos da mercearia
    private static Vector<Produto> produtos;

    //método responsábvel pela leitura das informações arquivo do excel
    private static void cargaArquivo() {
        //ajuste na criação de vetor de produtos static 
        //verificando se o vetor de produtos ainda não foi declarado
        if (produtos == null) {
            produtos = new Vector<>();
        } else {
            produtos.clear(); /*limpar o vetor, pois na sequencia será feito todo o procedimento de ler as informações 
             que estão armazenadas dentro do arquivo */

        }
        //instânciando o arquivo, utilizando o endereço onde ele se encontra no computador
        File arquivoCsv = new File("C:\\Users\\juhfe\\Downloads\\produtos.csv");

        //estruturas de leitura do arquivo
        try {
            //marcar o arquivo como arquivo de leitura    
            FileReader marcaLeitura = new FileReader(arquivoCsv);
            /*estrutura criada para passar o máximo de dados pelo barramento(de forma otimizada), em
             uma única "viagem" consiguimos levar mais dados*/
            BufferedReader bufLeitura = new BufferedReader(marcaLeitura);
            //****************ler cada linha***************************
            //a primeira linha (cabrçalho = descartar essa linha)
            bufLeitura.readLine();

            String linha = bufLeitura.readLine();
            //fazendo efetivamente a leitura do restante do arquivo:
            while (linha != null) {
                //linhas seguintes, até o final do arquivo
                //dividir o texto do arquivo a partir da marcação do ponto e virgula
                String infos[] = linha.split(";");
                //processamento de texto e extraindo as informações que precisamos para o produto
                //para passar a informação foi preciso converter o tipo String para tipo Inteiro
                int cod = Integer.parseInt(infos[0]);
                String nome = infos[1];
                //para passar a informação foi preciso converter o tipo String para tipo Double
                double preco = Double.parseDouble(infos[2]);
                //para passar a informação foi preciso converter o tipo String para tipo Inteiro
                int quant = Integer.parseInt(infos[3]);
                //add dos produtos para o vetor dinamico
                produtos.add(new Produto(cod, nome, preco, quant));
                //lendo a proxima linha do arquivo
                linha = bufLeitura.readLine();
            }
            //liberando o arquivo para outros processos
            bufLeitura.close();
        } catch (FileNotFoundException ex) { // exceção caso o arquivo não exista
            System.err.println("Arquico espec. não existe");
        } catch (IOException e) { // exceção caso o arquivo esteja corrompido/ acesso de otra máquina/ etc
            System.err.println("Arquivo corrompido");
        }
    }

    public static Produto consultaProdutoCod(int cod) {
        //se o arquivo não foi carregado, precisamos carrega-lo
        if (produtos == null) {
            cargaArquivo();
        }
        //busca pelo prroduto com o codigo especificado
        for (Produto prodI : produtos) {
            if (prodI.getCodigo() == cod) {
                return prodI;
            }

        }
        return null; //nao existe prduto com cod especificado no parametro
    }

    public static void atualizaArquivo() {
        File arquivo = new File("C:\\Users\\juhfe\\Downloads\\produtos.csv");
        try {
            FileWriter escritor = new FileWriter(arquivo);
            BufferedWriter bufEscrita = new BufferedWriter(escritor);

            for (int i = 0; i < produtos.size(); i++) {
                bufEscrita.write(produtos.get(i) + "\n");
            }
            //descarregando as informações
            bufEscrita.flush();
            //liberando arquivo para outros processos
            bufEscrita.close();

        } catch (IOException ex) {
            System.err.println("dispositivo com falha");
        }
    }
}
