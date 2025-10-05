package pe.edu.upc.selecia_backend.dtos;

import pe.edu.upc.selecia_backend.entities.PerfilPostulante;

import java.util.Map;

public class CandidatoRankingDTO {
    private Integer idPerfil;
    private String username;

    // Puntajes por atributo (0–100)
    private Double experienciaScore;
    private Double educacionScore;
    private Double habilidadesTecScore;
    private Double habilidadesBlandasScore;
    private Double certificacionesScore;
    private Map<String, String> explicaciones;


    // Puntaje total ponderado (0–100)
    private Double totalScore;

    public CandidatoRankingDTO() {}

    public CandidatoRankingDTO(Integer idPerfil, String username, Double experienciaScore, Double educacionScore, Double habilidadesTecScore, Double habilidadesBlandasScore, Double certificacionesScore, Map<String, String> explicaciones, Double totalScore) {
        this.idPerfil = idPerfil;
        this.username = username;
        this.experienciaScore = experienciaScore;
        this.educacionScore = educacionScore;
        this.habilidadesTecScore = habilidadesTecScore;
        this.habilidadesBlandasScore = habilidadesBlandasScore;
        this.certificacionesScore = certificacionesScore;
        this.explicaciones = explicaciones;
        this.totalScore = totalScore;
    }

    public Map<String, String> getExplicaciones() {
        return explicaciones;
    }

    public void setExplicaciones(Map<String, String> explicaciones) {
        this.explicaciones = explicaciones;
    }

    public Integer getIdPerfil() { return idPerfil; }
    public void setIdPerfil(Integer idPerfil) { this.idPerfil = idPerfil; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public Double getExperienciaScore() { return experienciaScore; }
    public void setExperienciaScore(Double experienciaScore) { this.experienciaScore = experienciaScore; }

    public Double getEducacionScore() { return educacionScore; }
    public void setEducacionScore(Double educacionScore) { this.educacionScore = educacionScore; }

    public Double getHabilidadesTecScore() { return habilidadesTecScore; }
    public void setHabilidadesTecScore(Double habilidadesTecScore) { this.habilidadesTecScore = habilidadesTecScore; }

    public Double getHabilidadesBlandasScore() { return habilidadesBlandasScore; }
    public void setHabilidadesBlandasScore(Double habilidadesBlandasScore) { this.habilidadesBlandasScore = habilidadesBlandasScore; }

    public Double getCertificacionesScore() { return certificacionesScore; }
    public void setCertificacionesScore(Double certificacionesScore) { this.certificacionesScore = certificacionesScore; }

    public Double getTotalScore() { return totalScore; }
    public void setTotalScore(Double totalScore) { this.totalScore = totalScore; }
}


