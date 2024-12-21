package biblioteca;

import controllers.LivroController;
import controllers.UsuarioController;
import java.util.Scanner;

public class MenuPrincipal {
    Scanner scanner;
    private LivroController livroController;
    private UsuarioController usuarioController;
    
    public MenuPrincipal(Scanner scanner, LivroController livroController, UsuarioController usuarioController){
        this.scanner = scanner;
        this.livroController = livroController;
        this.usuarioController = usuarioController;
    }
    
    public void Menu(){
        int op;
        
        do{
            System.out.println("===Menu Principal===");
            System.out.println("1-Gerenciar Livros");
            System.out.println("2-Gerenciar Usuarios");
            System.out.println("3-Sair");
            System.out.println("Escolha uma opcao: ");
            
            op = scanner.nextInt();
            scanner.nextLine();
            
            switch(op){
                case 1:{
                    livroController.Menu();
                    break;
                }
                case 2:{
                    usuarioController.Menu();
                    break;
                }
                case 3:{
                    System.out.println("Saindo do sistema...");
                    break;
                }
                default:{
                    System.out.println("Opcao invalida.");
                }
            }
        } while(op != 3);
    }
}
