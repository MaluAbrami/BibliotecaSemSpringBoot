package controllers;

import java.util.List;
import java.util.Scanner;
import models.Usuario;
import services.UsuarioService;

public class UsuarioController {
    private UsuarioService usuarioService;
    private Scanner scanner;
    
    public UsuarioController(UsuarioService usuarioService, Scanner scanner){
        this.usuarioService = usuarioService;
        this.scanner = scanner;
    }
    
    public void Menu(){
        int op;
        
        do{
            System.out.println("===Usuarios===");
            System.out.println("1-Cadastrar Usuario");
            System.out.println("2-Listar todos os Usuarios");
            System.out.println("3-Buscar Usuario Por ID");
            System.out.println("4-Atualizar Usuario");
            System.out.println("5-Deletar Usuario");
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
        System.out.println("===Cadastro de Usuarios===");
        
        System.out.println("Nome: ");
        String nome = scanner.nextLine();
        
        usuarioService.adicionar(new Usuario(nome));
        System.out.println("Usuario adicionado com sucesso.");
    }
    
    public void listar(){
        System.out.println("===Lista de Usuarios===");
        
        List<Usuario> usuarios = usuarioService.listar();
        if(usuarios == null)
            System.out.println("Nenhum usuario cadastrado.");
        else{
            for(Usuario usuario: usuarios){
                usuarioService.imprimir(usuario);
            }
        }
    }
    
    public void buscar(){
        System.out.println("===Buscando Usuario===");
        
        System.out.println("ID do usuario: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();
        
        Usuario usuario = usuarioService.buscar(id);
        if(usuario == null)
            System.out.println("Erro: Usuario nao encontrado.");
        else{
            System.out.println("Usuario encontrado com sucesso.");
            usuarioService.imprimir(usuario);
        }
    }
    
    public void atualizar(){
        System.out.println("===Atualizacao de Usuario");
        
        System.out.println("ID do usuario: ");
        Integer id = scanner.nextInt();
        
        Usuario usuario = usuarioService.buscar(id);
        if(usuario == null)
            System.out.println("Erro: Usuario nao encontrado.");
        else{
            System.out.println("Novo nome: ");
            usuario.setNome(scanner.nextLine());
            
            boolean resp = usuarioService.atualizar(usuario);
            if(resp)
                System.out.println("Usuario atualizado com sucesso.");
            else
                System.out.println("Erro: nao foi possivel atualizar o usuario.");
        }
    }
    
    public void deletar(){
        System.out.println("===Deletando Usuarios===");
        
        System.out.println("ID do usuario: ");
        Integer id = scanner.nextInt();
        
        boolean resp = usuarioService.deletar(id);
        if(resp)
            System.out.println("Usuario deletado com sucesso.");
        else
            System.out.println("Erro: Impossivel deletar um usuario nao cadastrado.");
    }
}
