package biblioteca;

import controllers.LivroController;
import controllers.UsuarioController;
import java.util.Scanner;
import repositories.LivroRepository;
import repositories.UsuarioRepository;
import services.LivroService;
import services.UsuarioService;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LivroRepository livroRepository = new LivroRepository();
        UsuarioRepository usuarioRepository = new UsuarioRepository();
        LivroService livroService = new LivroService(livroRepository);
        UsuarioService usuarioService = new UsuarioService(usuarioRepository);
        LivroController livroController = new LivroController(livroService, scanner);
        UsuarioController usuarioController = new UsuarioController(usuarioService, scanner);
        MenuPrincipal menuPrincipal = new MenuPrincipal(scanner, livroController, usuarioController);
        
        menuPrincipal.Menu();
    }
    
}
