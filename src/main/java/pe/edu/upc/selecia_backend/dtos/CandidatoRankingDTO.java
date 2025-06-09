package pe.edu.upc.selecia_backend.dtos;

import pe.edu.upc.selecia_backend.entities.PerfilPostulante;

public class CandidatoRankingDTO {
    private Integer idperfil;
    private Double score;

    public CandidatoRankingDTO(Integer idperfil, Double score) {
        this.idperfil = idperfil;
        this.score = score;
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

