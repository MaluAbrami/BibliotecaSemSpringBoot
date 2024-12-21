package repositories;

import java.util.HashMap;
import java.util.List;
import models.Usuario;

public class UsuarioRepository {
    private int contador = 1;
    private HashMap<Integer, Usuario> usuarios;
    
    public UsuarioRepository(){
        usuarios = new HashMap<>();
    }
    
    public void adicionar(Usuario usuario){
        usuarios.put(contador++, usuario);
    }
    
    public List<Usuario> listar(){
        List<Usuario> listaUsuarios = null;
        
        for(Usuario usuario: usuarios.values()){
            listaUsuarios.add(usuario);
        }
        return listaUsuarios;
    }
    
    public Usuario buscar(int id){
        return usuarios.get(id);
    }
    
    public void atualizar(Usuario usuario){
        usuarios.put(usuario.getId(), usuario);
    }
    
    public void deletar(int id){
        usuarios.remove(id);
    }
}
