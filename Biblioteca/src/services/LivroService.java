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
        System.out.println("Livro adicionado com sucesso.");
    }
    
    public void listar(){
        List<Livro> livros = livroRepository.listar();
        
        if(livros == null){
            System.out.println("Nenhum livro cadastrado.");
        } else{
            for (Livro livro : livros) {
                String disponibilidade;
                if (livro.isDisponivel()) {
                    disponibilidade = "Indisponivel";
                } else {
                    disponibilidade = "Disponivel";
                }

                System.out.println("ID: " + livro.getId() + " | Titulo: " + livro.getTitulo() + " | Autor: " + livro.getAutor() + " | Disponibilidade: " + disponibilidade);
            }
        }
    }
    
    public void buscar(int id){
        Livro livro = livroRepository.buscar(id);
        
        if(livro == null){
            System.out.println("Erro: Livro nao encontrado.");
        } else{
            System.out.println("Livro encontrado com sucesso.");
        }
    }
    
    public void atualizar(Livro livro){
        boolean resp = livroRepository.atualizar(livro);
        
        if(resp)
            System.out.println("Livro atualizado com sucesso.");
        else
            System.out.println("Erro: Livro nao encontrado.");
    }
    
    public void deletar(int id){
        boolean resp = livroRepository.deletar(id);
        
        if(resp)
            System.out.println("Livro removido com sucesso.");
        else
            System.out.println("Erro: Livro nao encontrado.");
    }
}
