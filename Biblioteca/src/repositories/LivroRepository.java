package repositories;

import java.util.HashMap;
import java.util.List;
import models.Livro;

public class LivroRepository {
    private int contador = 1;
    private HashMap<Integer, Livro> livros;
    
    public LivroRepository(){
        livros = new HashMap<>();
    }

    public void adicionar(Livro livro){
        livros.put(contador++, livro);
    }
    
    public List<Livro> listar(){
        List<Livro> listaLivros = null;
        
        for(Livro livro: livros.values()){
            listaLivros.add(livro);
        }
        return listaLivros;
    }
    
    public Livro buscar(int id){
        return livros.get(id);
    }
    
    public boolean atualizar(Livro livro){
        if(livros.containsKey(livro.getId())){
            livros.put(livro.getId(), livro);
            return true;
        } else
            return false;
    }
    
    public boolean deletar(int id){
        if(livros.containsKey(id)){
            livros.remove(id);
            return true;
        } else
            return false;
    }
}
