package controllers;

import java.util.List;
import java.util.Scanner;
import models.Livro;
import services.LivroService;

public class LivroController {
    private LivroService livroService;
    private Scanner scanner;
    
    public LivroController(LivroService livroService, Scanner scanner){
        this.livroService = livroService;
        this.scanner = scanner;
    }
    
    public void Menu(){
        int op;
        
        do{ 
            System.out.println("===Livros===");
            System.out.println("1-Cadastrar Livro");
            System.out.println("2-Listar todos os Livros");
            System.out.println("3-Buscar Livro Por ID");
            System.out.println("4-Atualizar Livro");
            System.out.println("5-Deletar Livro");
            System.out.println("6-Voltar para o Menu Principal");
            System.out.println("Escolha uma opcao: ");

            op = scanner.nextInt();
            scanner.nextLine();

            switch(op){
                case 1:{
                    cadastrar();
                    break;
                }
                case 2:{
                    listar();
                    break;
                }
                case 3:{
                    buscar();
                    break;
                }
                case 4:{
                    atualizar();
                    break;
                }
                case 5:{
                    deletar();
                    break;
                }
                case 6:{
                    System.out.println("Voltando para o menu principal...");
                    break;
                }
                default:{
                    System.out.println("Opcao invalida.");
                }
            }
        } while(op != 6);
    }
    
    public void cadastrar(){
        System.out.println("===Cadastro de Livros===");
        
        System.out.println("Titulo: ");
        String titulo = scanner.nextLine();
        System.out.println("Autor: ");
        String autor = scanner.nextLine();
        
        livroService.adicionar(new Livro(titulo, autor));
        System.out.println("Livro adicionado com sucesso.");
    }
    
    public void listar(){
        System.out.println("===Lista de Livros===");
        
        List<Livro> livros = livroService.listar();
        if (livros == null) {
            System.out.println("Nenhum livro cadastrado.");
        } else {
            for (Livro livro : livros) {
                livroService.imprimir(livro);
            }
        }
    }
    
    public void buscar(){
        System.out.println("===Buscando Livro===");
        
        System.out.println("ID do livro: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();
        
        Livro livro = livroService.buscar(id);
        if(livro == null)
            System.out.println("Erro: Livro nao encontrado.");
        else{
            System.out.println("Livro encontrado com sucesso.");
            livroService.imprimir(livro);
        }
    }
    
    public void atualizar(){
        System.out.println("===Atualizacao de Livros===");
        
        System.out.println("ID do livro: ");
        Integer id = scanner.nextInt();
        
        Livro livro = livroService.buscar(id);
        if(livro == null)
            System.out.println("Erro: Livro nao encontrado.");
        else{
            System.out.println("Novo Titulo: ");
            livro.setTitulo(scanner.nextLine());
            System.out.println("Titulo atualizado!");
            
            scanner.nextLine();
            
            System.out.println("Novo Autor: ");
            livro.setAutor(scanner.nextLine());
            System.out.println("Autor atualizado!");
            
            scanner.nextLine();
            
            boolean resp = livroService.atualizar(livro);
            if(resp)
                System.out.println("Livro atualizado com sucesso.");
            else
                System.out.println("Erro: nao foi possivel atualizar o livro.");
        }
    }
    
    public void deletar(){
        System.out.println("===Deletando Livros===");
        
        System.out.println("ID do livro: ");
        Integer id = scanner.nextInt();
        
        boolean resp = livroService.deletar(id);
        if(resp)
            System.out.println("Livro deletado com sucesso.");
        else
            System.out.println("Erro: Impossivel deletar um livro nao cadastrado.");
    }
}
