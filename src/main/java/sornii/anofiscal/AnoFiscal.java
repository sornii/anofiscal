package sornii.anofiscal;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.time.Month;
import java.time.Year;
import java.util.function.BiConsumer;
import java.util.function.Function;

@Data
public class AnoFiscal {

    private Year ano;

    private PeriodoMeses periodoMeses;

    private AnoFiscalPadraoMundial tipo;

    private AnoFiscalMesReferencia offsetTipo;

    @Setter(AccessLevel.NONE)
    private OrganizadorMeses organizadorMeses;

    protected AnoFiscal() {
    }

    private AnoFiscal(Year ano) {
        setAno(ano);
    }

    public AnoFiscal(AnoFiscalPadraoMundial tipo, Year ano) {
        this(ano);
        setTipo(tipo);
    }

    public AnoFiscal(Month primeiroMes, Year ano) {
        this(ano);
        setPrimeiroMes(primeiroMes);
    }

    public void setTipo(AnoFiscalPadraoMundial tipo) {
        this.tipo = tipo;
        this.periodoMeses = tipo.getPeriodoMeses();
        this.offsetTipo = tipo.getOffsetTipo();
        atualizarOrganizadorMeses();
    }

    private void setMes(Month mes, BiConsumer<PeriodoMeses, Month> setter,
                        Function<Month, PeriodoMeses> construtor) {
        if (isAnoFiscalPersonalizado() && periodoMeses != null) {
            setter.accept(periodoMeses, mes);
        } else {
            periodoMeses = construtor.apply(mes);
        }
        atualizarOrganizadorMeses();
        tipo = null;
    }

    public Month getPrimeiroMes() {
        return periodoMeses.getPrimeiroMes();
    }

    public void setPrimeiroMes(Month primeiroMes) {
        setMes(primeiroMes, PeriodoMeses::setPrimeiroMes,
                PeriodoMesesFactory::construirUsandoPrimeiroMes);
    }

    public Month getUltimoMes() {
        return periodoMeses.getUltimoMes();
    }

    public void setUltimoMes(Month ultimoMes) {
        setMes(ultimoMes, PeriodoMeses::setUltimoMes,
                PeriodoMesesFactory::construirUsandoUltimoMes);
    }

    public boolean isAnoFiscalPersonalizado() {
        return tipo == null;
    }

    public AnoFiscalData construirAnoFiscalData(Month mes) {
        return new AnoFiscalData(this, mes);
    }

    private void atualizarOrganizadorMeses() {
        organizadorMeses = new OrganizadorMeses(periodoMeses);
    }
}
