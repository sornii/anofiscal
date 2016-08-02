package sornii.anofiscal;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.time.Month;
import java.time.Year;

@Data
public class AnoFiscal {

    private Year ano;

    private PeriodoMeses periodoMeses;

    private AnoFiscalTipo tipo;

    private AnoFiscalOffsetTipo offsetTipo;

    @Setter(AccessLevel.NONE)
    private OrganizadorMeses organizadorMeses;

    protected AnoFiscal() {
    }

    private AnoFiscal(Year ano) {
        setAno(ano);
    }

    public AnoFiscal(AnoFiscalTipo tipo, Year ano) {
        this(ano);
        setTipo(tipo);
    }

    public AnoFiscal(Month primeiroMes, Year ano) {
        this(ano);
        setPrimeiroMes(primeiroMes);
    }

    public void setTipo(AnoFiscalTipo tipo) {
        this.tipo = tipo;
        this.periodoMeses = tipo.getPeriodoMeses();
    }

    public Month getPrimeiroMes() {
        return periodoMeses.getPrimeiroMes();
    }

    public void setPrimeiroMes(Month primeiroMes) {
        if (isAnoFiscalPersonalizado() && periodoMeses != null) {
            periodoMeses.setPrimeiroMes(primeiroMes);
        } else {
            periodoMeses = PeriodoMeses.construirUsandoPrimeiroMes(primeiroMes);
        }
        tipo = null;
    }

    public Month getUltimoMes() {
        return periodoMeses.getUltimoMes();
    }

    public void setUltimoMes(Month ultimoMes) {
        if (isAnoFiscalPersonalizado() && periodoMeses != null) {
            periodoMeses.setUltimoMes(ultimoMes);
        } else {
            periodoMeses = PeriodoMeses.construirUsandoUltimoMes(ultimoMes);
        }
        tipo = null;
    }

    public boolean isAnoFiscalPersonalizado() {
        return tipo == null;
    }
}
