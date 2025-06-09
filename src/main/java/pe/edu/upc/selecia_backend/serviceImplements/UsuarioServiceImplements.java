package pe.edu.upc.selecia_backend.serviceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.selecia_backend.entities.Usuario;
import pe.edu.upc.selecia_backend.repositories.UsuarioRepository;
import pe.edu.upc.selecia_backend.serviceInterfaces.UsuarioService;

import java.util.List;

@Service
public class UsuarioServiceImplements implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void insert(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> list() {
        return usuarioRepository.findAll();
    }

    @Override
    public void delete(long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public Usuario findById(long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public Usuario findByCorreo(String correo) {
        return usuarioRepository.findByCorreo(correo);
    }
}
