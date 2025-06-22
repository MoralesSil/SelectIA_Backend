package pe.edu.upc.selecia_backend.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.selecia_backend.dtos.PostulacionDTO;
import pe.edu.upc.selecia_backend.entities.OfertaLaboral;
import pe.edu.upc.selecia_backend.entities.PerfilPostulante;
import pe.edu.upc.selecia_backend.entities.Postulacion;
import pe.edu.upc.selecia_backend.entities.Usuario;
import pe.edu.upc.selecia_backend.serviceInterfaces.OfertaLaboralService;
import pe.edu.upc.selecia_backend.serviceInterfaces.PerfilPostulanteService;
import pe.edu.upc.selecia_backend.serviceInterfaces.PostulacionService;
import pe.edu.upc.selecia_backend.serviceInterfaces.UsuarioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/postulaciones")
public class PostulacionController {

    @Autowired
    private PostulacionService postulacionService;
    @Autowired
    private PerfilPostulanteService perfilPostulanteService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private OfertaLaboralService ofertaLaboralService;


    @PostMapping
    public ResponseEntity<Void> insertar(@RequestBody PostulacionDTO postulacionDTO) {
        ModelMapper m = new ModelMapper();
        Postulacion postulacion = m.map(postulacionDTO, Postulacion.class);
        postulacionService.insert(postulacion);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/existe")
    public boolean existePostulacion(
            @RequestParam Integer idUsuario,
            @RequestParam Integer idOferta
    ) {
        Usuario usuario = usuarioService.findById(idUsuario);
        PerfilPostulante perfil = perfilPostulanteService.findByUsuario(usuario);
        OfertaLaboral oferta = ofertaLaboralService.findById(idOferta);
        return postulacionService.existsByPerfilPostulante_IdPerfilAndOfertaLaboral_IdOferta(perfil, oferta);
    }

    @GetMapping
    public ResponseEntity<List<PostulacionDTO>> listar() {
        List<Postulacion> lista = postulacionService.list();
        ModelMapper m = new ModelMapper();
        List<PostulacionDTO> listaDTO = lista.stream()
                .map(p -> m.map(p, PostulacionDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(listaDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostulacionDTO> buscarPorId(@PathVariable("id") int id) {
        Postulacion postulacion = postulacionService.findById(id);
        if (postulacion == null) {
            return ResponseEntity.notFound().build();
        }
        ModelMapper m = new ModelMapper();
        PostulacionDTO dto = m.map(postulacion, PostulacionDTO.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") int id) {
        postulacionService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/perfil-postulante/{perfilId}")
    public ResponseEntity<List<PostulacionDTO>> buscarPorPerfilPostulante(@PathVariable("perfilId") int perfilId) {
        PerfilPostulante perfil = new PerfilPostulante();
        perfil.setIdperfil(perfilId);
    
        List<Postulacion> lista = postulacionService.findByPerfilPostulante(perfil);
    
        List<PostulacionDTO> listaDTO = lista.stream().map(p -> {
            PostulacionDTO dto = new PostulacionDTO();
            dto.setIdPostulacion(p.getIdPostulacion());
            dto.setFechaPostulacion(p.getFechaPostulacion());
            dto.setEstado(p.getEstado());
    
            // Solo enviar el ID del perfil
            PerfilPostulante perfilDTO = new PerfilPostulante();
            perfilDTO.setIdperfil(p.getPerfilPostulante().getIdperfil());
            dto.setPerfilPostulante(perfilDTO);
    
            // Enviar solo los datos necesarios de la oferta laboral
            OfertaLaboral ofertaDTO = new OfertaLaboral();
            ofertaDTO.setIdoferta(p.getOfertaLaboral().getIdoferta());
            ofertaDTO.setEstado(p.getOfertaLaboral().getEstado());
            ofertaDTO.setFechaCreacion(p.getOfertaLaboral().getFechaCreacion());
            ofertaDTO.setFechaCulminacion(p.getOfertaLaboral().getFechaCulminacion());
    
            // Adjuntar solo el puesto de trabajo con título y descripción
            if (p.getOfertaLaboral().getPuestoDeTrabajo() != null) {
                ofertaDTO.setPuestoDeTrabajo(p.getOfertaLaboral().getPuestoDeTrabajo());
            }
    
            dto.setOfertaLaboral(ofertaDTO);
    
            return dto;
        }).collect(Collectors.toList());
    
        return ResponseEntity.ok(listaDTO);
    }


    @GetMapping("/oferta-laboral/{ofertaId}")
    public ResponseEntity<List<PostulacionDTO>> buscarPorOfertaLaboral(@PathVariable("ofertaId") int ofertaId) {
        OfertaLaboral oferta = new OfertaLaboral();
        oferta.setIdoferta(ofertaId);
        List<Postulacion> lista = postulacionService.findByOfertaLaboral(oferta);
        ModelMapper m = new ModelMapper();
        List<PostulacionDTO> listaDTO = lista.stream()
                .map(p -> m.map(p, PostulacionDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(listaDTO);
    }
}
