import java.util.ArrayList;
import java.util.Iterator;
/**
 * Gerencia o estoque de uma empresa.
 * Um estoque é formado por zero ou mais produtos.
 * 
 * Traduzido por Julio César Alves - 2023.10.10
 * 
 * @author (seu nome) 
 * @version (a data)
 */
public class GerenciadorDeEstoque
{
    // Uma lista dos produtos.
    private ArrayList<Produto> estoque;

    /**
     * Inicializa o gerenciador de estoque.
     */
    public GerenciadorDeEstoque()
    {
        estoque = new ArrayList<>();
    }

    /**
     * Adiciona um produto à lista.
     * @param item O item a ser adicionado.
     */
    public void adicionarProduto(Produto item)
    {
        boolean jaExiste = false;
        for (Produto produtoExistente : estoque) 
        {
        if (item.obterID() == produtoExistente.obterID() && !jaExiste) {
            System.out.println("ID já existente");
            jaExiste = true;
        }
        }   
    
        if (!jaExiste) 
        {
            estoque.add(item);
        }

    }
    
    /**
     * Tenta encontrar um produto no estoque com o identificador passado.
     * @return O produto identificado, ou null se não há nenhum produto
     *         com o identificador passado.
     */
    public Produto encontrarProduto(int id)
    {
        boolean achou = false;
        
        Iterator<Produto> it = estoque.iterator();
        while (it.hasNext() && !achou)
        {
            Produto produtoDetalhe = it.next();
            if (produtoDetalhe.obterID() == id)
            {
            achou = true;
            return produtoDetalhe;
            }
        }
       
        return null;
        
    }
    
    public Produto encontrarProduto(String nome)
    {
       boolean achou = false;
        
        Iterator<Produto> it = estoque.iterator();
        while (it.hasNext() && !achou)
        {
            Produto produtoDetalhe = it.next();
            if (produtoDetalhe.obterNome().equals(nome))
            {
            achou = true;
            return produtoDetalhe;
            }
        }
       
        return null; 
    }
    
    /**
     * Recebe uma entrega de um produto particular.
     * Aumenta a quantidade do produto pela quantidade passada.
     * @param id O identificador do produto.
     * @param quantidade A quantidade a ser aumentada do produto.
     */
    public void receberEntrega(int id, int quantidade)
    {
        Produto produto = encontrarProduto(id);
        int quantidadeProduto = produto.obterQuantidade();
        if (produto !=null)
        {
            produto.aumentarQuantidade(quantidade);
        }
    }
    
    /**
     * Localiza um produto com o identificador passado, e retorna
     * quantas unidades dele existem no estoque. Retorna zero
     * se não há nenhum produto com o identificador passado.
     * @param id O identificador do produto.
     * @return A quantidade do produto solicitado em estoque.
     */
    public int quantidadeEmEstoque(int id)
    {
        Produto produto = encontrarProduto(id);
        if (produto !=null)
        {
        return produto.obterQuantidade();
        }
        else
        {
        return 0;
        }
    }

    /**
     * Exibe os detalhes de todos os produtos.
     */
    public void imprimirDetalhesDosProdutos()
    {
        Iterator<Produto> it = estoque.iterator();
        while (it.hasNext())
        {
            Produto produtoDetalhe = it.next();
            System.out.println(produtoDetalhe.paraString());
        }
    }
    
    public void imprimirDetalhesDosProdutos(int quantidade)
    {
        Iterator<Produto> it = estoque.iterator();
        while (it.hasNext())
        {
            Produto produto = it.next();
            if (produto.obterQuantidade() < quantidade)
            {
            System.out.println(produto.paraString());
            }
        }
    }
}
