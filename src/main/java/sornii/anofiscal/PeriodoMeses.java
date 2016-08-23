package sornii.anofiscal;

import lombok.Data;

import java.time.Month;

/**
 * Utilizada para definição dinâmica do primeiro e do último mês de um calendário de ano fiscal
 */
@Data
public class PeriodoMeses {

    private Month primeiroMes;

    private Month ultimoMes;

    PeriodoMeses() {
    }

    public void setPrimeiroMes(Month primeiroMes) {
        this.primeiroMes = primeiroMes;
        this.ultimoMes = primeiroMes.minus(1);
    }

    public void setUltimoMes(Month ultimoMes) {
        this.primeiroMes = ultimoMes.plus(1);
        this.ultimoMes = ultimoMes;
    }
}
