package br.com.systempus.systempus.domain.embeddableclass;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class HorarioAulaId {
    
    // @Column(name = "id_carga_horaria")
    private Integer cargaHorariaId;
   
    // @Column(name = "id_periodo")
    private Integer periodoId;

    public HorarioAulaId(Integer cargaHorariaId, Integer periodoId) {
        this.cargaHorariaId = cargaHorariaId;
        this.periodoId = periodoId;
    }

    public Integer getCargaHorariaId() {
        return cargaHorariaId;
    }

    public void setCargaHorariaId(Integer cargaHorariaId) {
        this.cargaHorariaId = cargaHorariaId;
    }

    public Integer getPeriodoId() {
        return periodoId;
    }

    public void setPeriodoId(Integer periodoId) {
        this.periodoId = periodoId;
    }

    

    
}
