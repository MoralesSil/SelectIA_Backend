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
import java.util.*;
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

        ObjectMapper mapper = new ObjectMapper();

        try {
            // Recalcular embeddings por cada campo
            List<Double> embEducacion = embeddingPythonService.getEmbedding(
                    perfil.getEducacion() == null ? "" : perfil.getEducacion());
            List<Double> embExperiencia = embeddingPythonService.getEmbedding(
                    perfil.getExperiencia() == null ? "" : perfil.getExperiencia());
            List<Double> embHabTec = embeddingPythonService.getEmbedding(
                    perfil.getHabilidadesTecnicas() == null ? "" : perfil.getHabilidadesTecnicas());
            List<Double> embHabBlandas = embeddingPythonService.getEmbedding(
                    perfil.getHabilidadesBlandas() == null ? "" : perfil.getHabilidadesBlandas());
            List<Double> embCerts = embeddingPythonService.getEmbedding(
                    perfil.getCertificaciones() == null ? "" : perfil.getCertificaciones());

            // Guardar embeddings serializados en columnas
            perfil.setSetEmbEducacion(mapper.writeValueAsString(embEducacion));
            perfil.setSetEmbExperiencia(mapper.writeValueAsString(embExperiencia));
            perfil.setSetEmbHabTec(mapper.writeValueAsString(embHabTec));
            perfil.setSetEmbHabBlandas(mapper.writeValueAsString(embHabBlandas));
            perfil.setSetcertificaciones(mapper.writeValueAsString(embCerts));

            perfilPostulanteService.insert(perfil);

            return ResponseEntity.ok("Embeddings recalculados correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al recalcular embeddings: " + e.getMessage());
        }
    }



    // USANDO DTO para puesto de trabajo
    @PutMapping("/puesto")
        public ResponseEntity<?> registrarPuesto(@RequestBody PuestoDeTrabajoDTO puestoDTO) {
        ModelMapper m = new ModelMapper();
        PuestoDeTrabajo puesto = m.map(puestoDTO, PuestoDeTrabajo.class);

        // Embeddings por campo (Opción 2)
        List<Double> embExperiencia   = embeddingPythonService.getEmbedding(puesto.getExperiencia() == null ? "" : puesto.getExperiencia());
        List<Double> embEducacion     = embeddingPythonService.getEmbedding(puesto.getEducacion() == null ? "" : puesto.getEducacion());
        List<Double> embHabTec        = embeddingPythonService.getEmbedding(puesto.getHabilidadesTecnicas() == null ? "" : puesto.getHabilidadesTecnicas());
        List<Double> embHabBlandas    = embeddingPythonService.getEmbedding(puesto.getHabilidadesBlandas() == null ? "" : puesto.getHabilidadesBlandas());
        List<Double> embCertificaciones = embeddingPythonService.getEmbedding(puesto.getCertificaciones() == null ? "" : puesto.getCertificaciones());

        ObjectMapper mapper = new ObjectMapper();
        try {
            puesto.setSetEmbExperiencia(mapper.writeValueAsString(embExperiencia));
            puesto.setSetEmbEducacion(mapper.writeValueAsString(embEducacion));
            puesto.setSetEmbHabTec(mapper.writeValueAsString(embHabTec));
            puesto.setSetEmbHabBlandas(mapper.writeValueAsString(embHabBlandas));
            puesto.setSetEmbCertificaciones(mapper.writeValueAsString(embCertificaciones));
        } catch (Exception e) {
            puesto.setSetEmbExperiencia("[]");
            puesto.setSetEmbEducacion("[]");
            puesto.setSetEmbHabTec("[]");
            puesto.setSetEmbHabBlandas("[]");
            puesto.setSetEmbCertificaciones("[]");
        }

        puestoDeTrabajoService.insert(puesto);
        return ResponseEntity.ok("Puesto guardado correctamente");
    }


    @PostMapping("/puesto")
    public ResponseEntity<?> registrarPuesto1(@RequestBody PuestoDeTrabajoDTO puestoDTO) {
        ModelMapper m = new ModelMapper();
        PuestoDeTrabajo puesto = m.map(puestoDTO, PuestoDeTrabajo.class);

        // Embeddings por campo (5 atributos)
        List<Double> embExperiencia     = embeddingPythonService.getEmbedding(puesto.getExperiencia() == null ? "" : puesto.getExperiencia());
        List<Double> embEducacion       = embeddingPythonService.getEmbedding(puesto.getEducacion() == null ? "" : puesto.getEducacion());
        List<Double> embHabTec          = embeddingPythonService.getEmbedding(puesto.getHabilidadesTecnicas() == null ? "" : puesto.getHabilidadesTecnicas());
        List<Double> embHabBlandas      = embeddingPythonService.getEmbedding(puesto.getHabilidadesBlandas() == null ? "" : puesto.getHabilidadesBlandas());
        List<Double> embCertificaciones = embeddingPythonService.getEmbedding(puesto.getCertificaciones() == null ? "" : puesto.getCertificaciones());

        ObjectMapper mapper = new ObjectMapper();
        try {
            puesto.setSetEmbExperiencia(mapper.writeValueAsString(embExperiencia));
            puesto.setSetEmbEducacion(mapper.writeValueAsString(embEducacion));
            puesto.setSetEmbHabTec(mapper.writeValueAsString(embHabTec));
            puesto.setSetEmbHabBlandas(mapper.writeValueAsString(embHabBlandas));
            puesto.setSetEmbCertificaciones(mapper.writeValueAsString(embCertificaciones));
        } catch (Exception e) {
            puesto.setSetEmbExperiencia("[]");
            puesto.setSetEmbEducacion("[]");
            puesto.setSetEmbHabTec("[]");
            puesto.setSetEmbHabBlandas("[]");
            puesto.setSetEmbCertificaciones("[]");
        }

        puestoDeTrabajoService.insert(puesto);
        return ResponseEntity.ok().build();
    }



    @GetMapping("/rank/oferta/{idOferta}")
    public ResponseEntity<?> rankCandidatosPorOferta(@PathVariable Integer idOferta) {
        OfertaLaboral oferta = ofertaLaboralService.findById(idOferta);
        if (oferta == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Oferta laboral no encontrada");

        PuestoDeTrabajo puesto = oferta.getPuestoDeTrabajo();
        if (puesto == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Puesto no asociado a la oferta");

        Map<String, String> puestoMap = new HashMap<>();
        puestoMap.put("experiencia", nullToEmpty(puesto.getExperiencia()));
        puestoMap.put("educacion", nullToEmpty(puesto.getEducacion()));
        puestoMap.put("habilidades_tecnicas", nullToEmpty(puesto.getHabilidadesTecnicas()));
        puestoMap.put("habilidades_blandas", nullToEmpty(puesto.getHabilidadesBlandas()));
        puestoMap.put("certificaciones", nullToEmpty(puesto.getCertificaciones()));

        List<Postulacion> postulaciones = postulacionService.findByOfertaLaboral(oferta);
        List<CandidatoRankingDTO> resultados = new ArrayList<>();

        for (Postulacion post : postulaciones) {
            PerfilPostulante p = post.getPerfilPostulante();

            Map<String, String> candMap = new HashMap<>();
            candMap.put("experiencia", nullToEmpty(p.getExperiencia()));
            candMap.put("educacion", nullToEmpty(p.getEducacion()));
            candMap.put("habilidades_tecnicas", nullToEmpty(p.getHabilidadesTecnicas()));
            candMap.put("habilidades_blandas", nullToEmpty(p.getHabilidadesBlandas()));
            candMap.put("certificaciones", nullToEmpty(p.getCertificaciones()));

            var resp = embeddingPythonService.similaridadExplicable(puestoMap, candMap);
            Map<String, Double> r = resp.getResultados();

            CandidatoRankingDTO row = new CandidatoRankingDTO(
                    p.getIdperfil(),
                    p.getUsuario().getUsername(),
                    round2(r.getOrDefault("experiencia", 0.0)),
                    round2(r.getOrDefault("educacion", 0.0)),
                    round2(r.getOrDefault("habilidades_tecnicas", 0.0)),
                    round2(r.getOrDefault("habilidades_blandas", 0.0)),
                    round2(r.getOrDefault("certificaciones", 0.0)),
                    resp.getExplicaciones(),                        // 8°
                    round2(r.getOrDefault("TOTAL", 0.0))            // 9°
            );

            resultados.add(row);
        }

        resultados.sort((a, b) -> Double.compare(b.getTotalScore(), a.getTotalScore()));
        return ResponseEntity.ok(resultados);
    }

    private static String nullToEmpty(String s) { return s == null ? "" : s; }
    private static double round2(double v) { return Math.round(v * 100.0) / 100.0; }






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
        String pythonUrl = "https://sbert-production.up.railway.app";
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
        perfil.setHabilidadesBlandas((String) result.get("habilidades")); // <-- Mantengo tu asignación original
        perfil.setEducacion((String) result.get("educacion"));
        perfil.setExperiencia((String) result.get("experiencia"));

        // 4. Embeddings por campo (opción 2)
        List<Double> embEducacion   = embeddingPythonService.getEmbedding(perfil.getEducacion() == null ? "" : perfil.getEducacion());
        List<Double> embExperiencia = embeddingPythonService.getEmbedding(perfil.getExperiencia() == null ? "" : perfil.getExperiencia());
        List<Double> embHabBlandas  = embeddingPythonService.getEmbedding(perfil.getHabilidadesBlandas() == null ? "" : perfil.getHabilidadesBlandas());

        ObjectMapper mapper = new ObjectMapper();
        try {
            perfil.setSetEmbEducacion(mapper.writeValueAsString(embEducacion));
            perfil.setSetEmbExperiencia(mapper.writeValueAsString(embExperiencia));
            perfil.setSetEmbHabBlandas(mapper.writeValueAsString(embHabBlandas));
        } catch (Exception e) {
            perfil.setSetEmbEducacion("[]");
            perfil.setSetEmbExperiencia("[]");
            perfil.setSetEmbHabBlandas("[]");
        }

        perfilPostulanteService.insert(perfil);

        return ResponseEntity.ok("Perfil guardado correctamente");
    }


    @PutMapping("/perfilpostulante/update/{idUsuario}")
    @PreAuthorize("hasAuthority('Postulante')")
    public ResponseEntity<?> updatePerfil(
            @PathVariable("idUsuario") Integer idUsuario,
            @RequestParam("cvUrl") String cvUrl) {

        // 1. Busca el perfil existente
        Usuario usuario = usuarioService.findById(idUsuario);
        if (usuario == null) {
            return ResponseEntity.badRequest().body("Usuario no encontrado");
        }

        PerfilPostulante perfil = perfilPostulanteService.findByUsuario(usuario);
        if (perfil == null) {
            return ResponseEntity.badRequest().body("Perfil no encontrado");
        }

        // 2. Llama al microservicio Python con la nueva URL (si cambió)
        String pythonUrl = "https://sbert-production.up.railway.app";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("cv_url", cvUrl);

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(body, headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Map> response = restTemplate.postForEntity(pythonUrl, requestEntity, Map.class);
        Map<String, Object> result = response.getBody();

        // 3. Actualiza los campos
        perfil.setCvUrl(cvUrl);
        perfil.setTextoExtraido((String) result.get("texto_extraido"));
        perfil.setHabilidadesTecnicas((String) result.get("habilidades")); // <-- Mantengo tu asignación original
        perfil.setEducacion((String) result.get("educacion"));
        perfil.setExperiencia((String) result.get("experiencia"));

        // 4. Embeddings por campo (opción 2)
        List<Double> embEducacion   = embeddingPythonService.getEmbedding(perfil.getEducacion() == null ? "" : perfil.getEducacion());
        List<Double> embExperiencia = embeddingPythonService.getEmbedding(perfil.getExperiencia() == null ? "" : perfil.getExperiencia());
        List<Double> embHabTec      = embeddingPythonService.getEmbedding(perfil.getHabilidadesTecnicas() == null ? "" : perfil.getHabilidadesTecnicas());

        ObjectMapper mapper = new ObjectMapper();
        try {
            perfil.setSetEmbEducacion(mapper.writeValueAsString(embEducacion));
            perfil.setSetEmbExperiencia(mapper.writeValueAsString(embExperiencia));
            perfil.setSetEmbHabTec(mapper.writeValueAsString(embHabTec));
        } catch (Exception e) {
            perfil.setSetEmbEducacion("[]");
            perfil.setSetEmbExperiencia("[]");
            perfil.setSetEmbHabTec("[]");
        }

        perfilPostulanteService.insert(perfil);

        return ResponseEntity.ok(Collections.singletonMap("mensaje", "Perfil actualizado correctamente"));
    }


    @PutMapping("/perfilpostulante/update-campos")
    @PreAuthorize("hasAuthority('Postulante')")
    public ResponseEntity<?> actualizarCamposPerfilYEmbedding(@RequestBody PerfilPostulanteDTO dto) {
        // 1. Busca el usuario y el perfil
        Usuario usuario = usuarioService.findById(dto.getIdUsuario());
        if (usuario == null) {
            return ResponseEntity.badRequest().body(Collections.singletonMap("error", "Usuario no encontrado"));
        }
        PerfilPostulante perfil = perfilPostulanteService.findByUsuario(usuario);
        if (perfil == null) {
            return ResponseEntity.badRequest().body(Collections.singletonMap("error", "Perfil no encontrado"));
        }

        // 2. Actualiza los campos desde el DTO
        perfil.setEducacion(dto.getEducacion());
        perfil.setExperiencia(dto.getExperiencia());
        perfil.setHabilidadesTecnicas(dto.getHabilidadesTecnicas());
        perfil.setHabilidadesBlandas(dto.getHabilidadesBlandas());
        perfil.setCertificaciones(dto.getCertificaciones());

        // 3. Genera embeddings por cada campo
        List<Double> embEducacion = embeddingPythonService.getEmbedding(dto.getEducacion() == null ? "" : dto.getEducacion());
        List<Double> embExperiencia = embeddingPythonService.getEmbedding(dto.getExperiencia() == null ? "" : dto.getExperiencia());
        List<Double> embHabTec = embeddingPythonService.getEmbedding(dto.getHabilidadesTecnicas() == null ? "" : dto.getHabilidadesTecnicas());
        List<Double> embHabBlandas = embeddingPythonService.getEmbedding(dto.getHabilidadesBlandas() == null ? "" : dto.getHabilidadesBlandas());
        List<Double> embCerts = embeddingPythonService.getEmbedding(dto.getCertificaciones() == null ? "" : dto.getCertificaciones());

        // 4. Serializa embeddings
        ObjectMapper mapper = new ObjectMapper();
        try {
            perfil.setSetEmbEducacion(mapper.writeValueAsString(embEducacion));
            perfil.setSetEmbExperiencia(mapper.writeValueAsString(embExperiencia));
            perfil.setSetEmbHabTec(mapper.writeValueAsString(embHabTec));
            perfil.setSetEmbHabBlandas(mapper.writeValueAsString(embHabBlandas));
            perfil.setSetcertificaciones(mapper.writeValueAsString(embCerts));
        } catch (Exception e) {
            perfil.setSetEmbEducacion("[]");
            perfil.setSetEmbExperiencia("[]");
            perfil.setSetEmbHabTec("[]");
            perfil.setSetEmbHabBlandas("[]");
            perfil.setSetcertificaciones("[]");
        }

        // 5. Guarda perfil actualizado
        perfilPostulanteService.insert(perfil);

        // 6. Respuesta
        return ResponseEntity.ok(Collections.singletonMap("mensaje", "Perfil y embeddings actualizados correctamente"));
    }

    @PostMapping("/perfilpostulante/create")
    @PreAuthorize("hasAuthority('Postulante')")
    public ResponseEntity<?> crearPerfilPostulante(@RequestBody PerfilPostulanteDTO dto) {
        // 1) Validaciones mínimas
        if (dto.getIdUsuario() == null) {
            return ResponseEntity.badRequest().body(Collections.singletonMap("error", "idUsuario es obligatorio"));
        }

        Usuario usuario = usuarioService.findById(dto.getIdUsuario());
        if (usuario == null) {
            return ResponseEntity.badRequest().body(Collections.singletonMap("error", "Usuario no encontrado"));
        }

        // 2) Normalizar textos (evitar null)
        String educacionTxt   = normalize(dto.getEducacion());
        String experienciaTxt = normalize(dto.getExperiencia());
        String habTecTxt      = normalize(dto.getHabilidadesTecnicas());
        String habBlandasTxt  = normalize(dto.getHabilidadesBlandas());
        String certsTxt       = normalize(dto.getCertificaciones());
        String cvUrl          = normalize(dto.getCvUrl());
        String textoExtraido  = normalize(dto.getTextoExtraido());

        // 3) Generar embeddings por campo (opción 2)
        //    _No_ concatenamos: pedimos un embedding por atributo para explicabilidad.
        List<Double> embEducacion    = safeEmbedding(educacionTxt);
        List<Double> embExperiencia  = safeEmbedding(experienciaTxt);
        List<Double> embHabTec       = safeEmbedding(habTecTxt);
        List<Double> embHabBlandas   = safeEmbedding(habBlandasTxt);
        List<Double> embCertificaciones = safeEmbedding(certsTxt);

        // 4) Serializar embeddings a JSON (si no usas pgvector)
        ObjectMapper mapper = new ObjectMapper();
        String embEducacionJson      = toJson(mapper, embEducacion);
        String embExperienciaJson    = toJson(mapper, embExperiencia);
        String embHabTecJson         = toJson(mapper, embHabTec);
        String embHabBlandasJson     = toJson(mapper, embHabBlandas);
        String embCertificacionesJson= toJson(mapper, embCertificaciones);

        // 5) Armar entidad
        PerfilPostulante perfil = new PerfilPostulante();
        perfil.setUsuario(usuario);

        // Campos de texto “visibles/explicables” (para tus dashboards)
        perfil.setEducacion(educacionTxt);
        perfil.setExperiencia(experienciaTxt);
        perfil.setHabilidadesTecnicas(habTecTxt);
        perfil.setHabilidadesBlandas(habBlandasTxt);
        perfil.setCertificaciones(certsTxt);
        perfil.setCvUrl(cvUrl);
        perfil.setTextoExtraido(textoExtraido);

        // Embeddings por campo (JSON en columnas text, según tu entidad)
        perfil.setSetEmbEducacion(embEducacionJson);
        perfil.setSetEmbExperiencia(embExperienciaJson);
        perfil.setSetEmbHabTec(embHabTecJson);
        perfil.setSetEmbHabBlandas(embHabBlandasJson);
        perfil.setSetcertificaciones(embCertificacionesJson);

        // 6) Persistir
        perfilPostulanteService.insert(perfil);

        // 7) Respuesta (opcional: devolver ids/eco)
        Map<String, Object> resp = new HashMap<>();
        resp.put("mensaje", "Perfil creado y embeddings por campo generados correctamente");
        resp.put("idPerfil", perfil.getIdperfil());
        return ResponseEntity.ok(resp);
    }

    /* ===================== Helpers ===================== */

    private String normalize(String s) {
        return (s == null) ? "" : s.trim();
    }

    private String toJson(ObjectMapper mapper, List<Double> vec) {
        try {
            return mapper.writeValueAsString(vec == null ? Collections.emptyList() : vec);
        } catch (Exception e) {
            return "[]";
        }
    }

    /**
     * Envuelve la llamada al servicio de embeddings para manejar:
     * - cadenas vacías (devuelve vector vacío)
     * - errores de red (devuelve vector vacío)
     */
    private List<Double> safeEmbedding(String text) {
        try {
            if (text == null || text.isBlank()) {
                return Collections.emptyList();
            }
            return embeddingPythonService.getEmbedding(text);
        } catch (Exception ex) {
            // loggear ex si deseas
            return Collections.emptyList();
        }
    }





}

