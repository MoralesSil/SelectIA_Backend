package pe.edu.upc.selecia_backend.serviceInterfaces;

import pe.edu.upc.selecia_backend.entities.Usuario;

import java.util.List;

public interface UsuarioService {
    void insert(Usuario usuario);

    List<Usuario> list();

    void delete(long id);

    Usuario findById(long id);

    Usuario findByCorreo(String correo);

    public Usuario listId(Long idUsuario);

    public int findByUsername(String username);

    public Usuario findByUsername1(String username);
}
