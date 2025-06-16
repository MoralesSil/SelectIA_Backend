package pe.edu.upc.selecia_backend.dtos;

import pe.edu.upc.selecia_backend.entities.PerfilPostulante;

public class CandidatoRankingDTO {
    private Integer idperfil;
    private Double score;
    private String username;

    public CandidatoRankingDTO(Integer idperfil, Double score, String username) {
        this.idperfil = idperfil;
        this.score = score;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getIdperfil() {
        return idperfil;
    }

    public void setIdperfil(Integer idperfil) {
        this.idperfil = idperfil;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}

