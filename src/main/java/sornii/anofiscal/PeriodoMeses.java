package sornii.anofiscal;

import lombok.Data;

import java.time.Month;

@Data
public class PeriodoMeses {

    private Month primeiroMes;

    private Month ultimoMes;

    protected PeriodoMeses() {
    }

    public static PeriodoMeses construirUsandoPrimeiroMes(Month primeiroMes) {
        PeriodoMeses periodoMeses = new PeriodoMeses();
        periodoMeses.setPrimeiroMes(primeiroMes);

        return periodoMeses;
    }

    public static PeriodoMeses construirUsandoUltimoMes(Month ultimoMes) {
        PeriodoMeses periodoMeses = new PeriodoMeses();
        periodoMeses.setUltimoMes(ultimoMes);

        return periodoMeses;
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
