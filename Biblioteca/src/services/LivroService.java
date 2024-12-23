package services;

import java.util.List;
import models.Livro;
import repositories.LivroRepository;

public class LivroService {
    private LivroRepository livroRepository;
    
    public LivroService(LivroRepository livroRepository){
        this.livroRepository = livroRepository;
    }
    
    public void adicionar(Livro livro){
        livroRepository.adicionar(livro);
    }
    
    public List<Livro> listar(){
        return livroRepository.listar();
    }
    
    public void imprimir(Livro livro){
        String disponibilidade;
        if (livro.isDisponivel()) {
            disponibilidade = "Indisponivel";
        } else {
            disponibilidade = "Disponivel";
        }

        System.out.println("ID: " + livro.getId() + " | Titulo: " + livro.getTitulo() + " | Autor: " + livro.getAutor() + " | Disponibilidade: " + disponibilidade);
    }
    
    public Livro buscar(int id){
        return livroRepository.buscar(id);
    }
    
    public boolean atualizar(Livro livro){
        Livro l = buscar(livro.getId());
        
        if(l == null)
            return false;
        else{
            livroRepository.atualizar(livro);
            return true;
        }
    }
    
    public boolean deletar(int id){
        Livro l = buscar(id);
        
        if(l == null)
            return false;
        else{
            livroRepository.deletar(id);
            return true;
        }
    }
}
