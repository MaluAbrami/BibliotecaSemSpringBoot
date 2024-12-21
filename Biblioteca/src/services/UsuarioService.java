package services;

import java.util.List;
import models.Usuario;
import repositories.UsuarioRepository;

public class UsuarioService {
    private UsuarioRepository usuarioRepository;
    
    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }
    
    public void adicionar(Usuario usuario){
        usuarioRepository.adicionar(usuario);
    }
    
    public List<Usuario> listar(){
        return usuarioRepository.listar();
    }
    
    public void imprimir(Usuario usuario){
        System.out.println("ID: " + usuario.getId() + " | Nome: " + usuario.getNome());
    }
    
    public Usuario buscar(int id){
        return usuarioRepository.buscar(id);
    }
    
    public boolean atualizar(Usuario usuario){
        Usuario u = buscar(usuario.getId());
        
        if(u == null)  
            return false;
        else{
            usuarioRepository.atualizar(usuario);
            return true;
        }
    }
    
    public boolean deletar(int id){
        Usuario u = buscar(id);
        
        if(u == null)
            return false;
        else{
            usuarioRepository.deletar(id);
            return true;
        }
    }
}
