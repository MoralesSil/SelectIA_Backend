package pe.edu.upc.selecia_backend.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import pe.edu.upc.selecia_backend.dtos.CandidatoRankingDTO;
import pe.edu.upc.selecia_backend.dtos.PerfilPostulanteDTO;
import pe.edu.upc.selecia_backend.dtos.PuestoDeTrabajoDTO;
import pe.edu.upc.selecia_backend.entities.*;
import pe.edu.upc.selecia_backend.serviceImplements.EmbeddingPythonService;
import pe.edu.upc.selecia_backend.serviceInterfaces.*;
import pe.edu.upc.selecia_backend.util.EmbeddingUtils;
import pe.edu.upc.selecia_backend.util.MultipartInputStreamFileResource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/recomendacion")
public class RecomendacionController {

    @Autowired
    private EmbeddingPythonService embeddingPythonService;
    @Autowired
    private PerfilPostulanteService perfilPostulanteService;
    @Autowired
    private PuestoDeTrabajoService puestoDeTrabajoService;
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private OfertaLaboralService ofertaLaboralService;

    @Autowired
    private PostulacionService postulacionService;

    @PutMapping("/perfil-postulante/{id}/embedding")
    @PreAuthorize("hasAuthority('Postulante')")
    public ResponseEntity<?> recalcularEmbedding(@PathVariable Integer id) {
        PerfilPostulante perfil = perfilPostulanteService.findById(id);
        if (perfil == null) {
            return ResponseEntity.notFound().build();
        }
        String textoCV = (perfil.getEducacion() == null ? "" : perfil.getEducacion())
                + (perfil.getHabilidades() == null ? "" : perfil.getHabilidades());
        List<Double> embedding = embeddingPythonService.getEmbedding(textoCV);

        ObjectMapper mapper = new ObjectMapper();
        try {
            perfil.setEmbeddingVector(mapper.writeValueAsString(embedding));
        } catch (Exception e) {
            perfil.setEmbeddingVector("[]");
        }
        perfilPostulanteService.insert(perfil);

        return ResponseEntity.ok("Embedding actualizado correctamente");
    }


    // USANDO DTO para puesto de trabajo
    @PutMapping("/puesto")
    @PreAuthorize("hasAuthority('Postulante')")
    public ResponseEntity<?> registrarPuesto(@RequestBody PuestoDeTrabajoDTO puestoDTO) {
        ModelMapper m = new ModelMapper();
        PuestoDeTrabajo puesto = m.map(puestoDTO, PuestoDeTrabajo.class);

        String descripcion = puesto.getDescripcion() + " " + puesto.getRequisitos();
        List<Double> embedding = embeddingPythonService.getEmbedding(descripcion);

        ObjectMapper mapper = new ObjectMapper();
        try {
            puesto.setEmbeddingVector(mapper.writeValueAsString(embedding));
        } catch (Exception e) {
            puesto.setEmbeddingVector("[]");
        }
        puestoDeTrabajoService.insert(puesto);
        return ResponseEntity.ok("Puesto guardado correctamente");
    }

    /*@GetMapping("/rank/{idPuesto}")
    @PreAuthorize("hasAuthority('Postulante')")
    public ResponseEntity<?> rankCandidatos(@PathVariable Integer idPuesto) {
        PuestoDeTrabajo puesto = puestoDeTrabajoService.findById_puesto(idPuesto);
        String descripcion = puesto.getDescripcion() + " " + puesto.getRequisitos();

        List<PerfilPostulante> postulantes = perfilPostulanteService.list(); // o sólo los relevantes
        List<List<Double>> embeddingsCandidatos = postulantes.stream()
                .map(p -> EmbeddingUtils.parseEmbedding(p.getEmbeddingVector()))
                .collect(Collectors.toList());

        List<Double> scores = embeddingPythonService.getSimilarities(descripcion, embeddingsCandidatos);

        List<CandidatoRankingDTO> resultados = new ArrayList<>();
        for (int i = 0; i < postulantes.size(); i++) {
            PerfilPostulante perfil = postulantes.get(i);
            resultados.add(new CandidatoRankingDTO(perfil.getIdperfil(), scores.get(i)));
        }

        resultados.sort((a, b) -> Double.compare(b.getScore(), a.getScore())); // descendente

        return ResponseEntity.ok(resultados);
    }*/

    @GetMapping("/rank/oferta/{idOferta}")
    @PreAuthorize("hasAuthority('reclutador')")
    public ResponseEntity<?> rankCandidatosPorOferta(@PathVariable Integer idOferta) {
        OfertaLaboral oferta = ofertaLaboralService.findById(idOferta);
        if (oferta == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Oferta laboral no encontrada");
        }

        PuestoDeTrabajo puesto = oferta.getPuestoDeTrabajo();
        String embeddingPuestoStr = puesto.getEmbeddingVector();
        List<Double> embeddingPuesto = EmbeddingUtils.parseEmbedding(embeddingPuestoStr);

        List<Postulacion> postulaciones = postulacionService.findByOfertaLaboral(oferta);
        List<PerfilPostulante> perfilesPostulantes = postulaciones.stream()
                .map(Postulacion::getPerfilPostulante)
                .collect(Collectors.toList());
        List<List<Double>> embeddingsCandidatos = perfilesPostulantes.stream()
                .map(p -> EmbeddingUtils.parseEmbedding(p.getEmbeddingVector()))
                .collect(Collectors.toList());

        // Mandas el embedding directamente al microservicio Python
        List<Double> scores = embeddingPythonService.getSimilaritiesWithEmbedding(embeddingPuesto, embeddingsCandidatos);

        List<CandidatoRankingDTO> resultados = new ArrayList<>();
        for (int i = 0; i < perfilesPostulantes.size(); i++) {
            PerfilPostulante perfil = perfilesPostulantes.get(i);
            resultados.add(new CandidatoRankingDTO(perfil.getIdperfil(), scores.get(i)));
        }
        resultados.sort((a, b) -> Double.compare(b.getScore(), a.getScore()));

        return ResponseEntity.ok(resultados);
    }



    @PostMapping("/perfilpostulante/register")
    @PreAuthorize("hasAuthority('Postulante')")
    public ResponseEntity<?> registerPerfil(
            @RequestParam("usuarioId") Integer usuarioId,
            @RequestParam("cvUrl") String cvUrl) {

        // 1. Valida usuario
        Usuario usuario = usuarioService.findById(usuarioId);
        if (usuario == null) {
            return ResponseEntity.badRequest().body("Usuario no encontrado");
        }

        // 2. Llama a microservicio Python con solo la URL
        String pythonUrl = "http://localhost:8000/parse_cv_url";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("cv_url", cvUrl);

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(body, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Map> response = restTemplate.postForEntity(pythonUrl, requestEntity, Map.class);
        Map<String, Object> result = response.getBody();

        // 3. Crea el perfil
        PerfilPostulante perfil = new PerfilPostulante();
        perfil.setUsuario(usuario);
        perfil.setCvUrl(cvUrl);
        perfil.setTextoExtraido((String) result.get("texto_extraido"));
        perfil.setHabilidades((String) result.get("habilidades"));
        perfil.setEducacion((String) result.get("educacion"));
        perfil.setExperiencia((String) result.get("experiencia"));
        String textoCV = (perfil.getEducacion() == null ? "" : perfil.getEducacion())
                + (perfil.getExperiencia() == null ? "" : perfil.getExperiencia())
                + (perfil.getHabilidades() == null ? "" : perfil.getHabilidades());
        List<Double> embedding = embeddingPythonService.getEmbedding(textoCV);

        ObjectMapper mapper = new ObjectMapper();
        try {
            perfil.setEmbeddingVector(mapper.writeValueAsString(embedding));
        } catch (Exception e) {
            perfil.setEmbeddingVector("[]");
        }

        perfilPostulanteService.insert(perfil);

        return ResponseEntity.ok("Perfil guardado correctamente");
    }



}

