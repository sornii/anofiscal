package sornii.anofiscal;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AnoFiscalTest {

    @DataProvider(name = "tipos")
    public Iterator<Object[]> tipos() {
        return Stream.of(AnoFiscalTipo.values())
                .map(a -> new Object[]{a})
                .collect(Collectors.toList())
                .iterator();
    }

    @DataProvider(name = "meses")
    public Iterator<Object[]> meses() {
        return Stream.of(Month.values())
                .map(m -> new Object[]{m})
                .collect(Collectors.toList())
                .iterator();
    }

    @DataProvider(name = "tiposMeses")
    public Iterator<Object[]> tiposMeses() {
        List<Object[]> list = new ArrayList<>();

        for (AnoFiscalTipo tipo : AnoFiscalTipo.values()) {
            for (Month mes : Month.values()) {
                list.add(new Object[]{tipo, mes});
            }
        }

        return list.iterator();
    }

    @Test(dataProvider = "meses")
    public void testarMesFinalAnoFiscal(Month mesInicial) {
        Month mesFinal = mesInicial.minus(1);

        AnoFiscal anoFiscal = new AnoFiscal(mesInicial, Year.now());

        Assert.assertEquals(anoFiscal.getUltimoMes(), mesFinal);
    }

    @Test(dataProvider = "tipos")
    public void testarCriacaoAnoFiscal(AnoFiscalTipo tipo) {
        AnoFiscal anoFiscal = new AnoFiscal(tipo, Year.now());

        PeriodoMeses periodoMeses = tipo.getPeriodoMeses();

        Assert.assertEquals(anoFiscal.getPrimeiroMes(), periodoMeses.getPrimeiroMes());
        Assert.assertEquals(anoFiscal.getUltimoMes(), periodoMeses.getUltimoMes());
    }

    @Test(dataProvider = "tipos")
    public void testarTiposAnoFiscal(AnoFiscalTipo tipo) {
        PeriodoMeses periodoMeses = tipo.getPeriodoMeses();

        Month primeiroMes = periodoMeses.getPrimeiroMes();
        Month ultimoMes = primeiroMes.minus(1);

        Assert.assertEquals(periodoMeses.getUltimoMes(), ultimoMes);
    }

    @Test(dataProvider = "tipos")
    public void testarQuantidadeMesesOrdenados(AnoFiscalTipo tipo) {
        OrganizadorMeses organizadorMeses = tipo.getOrganizadorMeses();

        List<Month> mesesOrdenados = organizadorMeses.getMesesOrdenados();
        Assert.assertEquals(mesesOrdenados.size(), 12);
    }

    @Test(dataProvider = "tipos")
    public void testarPrimeiroUltimoMesesOrdenados(AnoFiscalTipo tipo) {
        OrganizadorMeses organizadorMeses = tipo.getOrganizadorMeses();
        List<Month> mesesOrdenados = organizadorMeses.getMesesOrdenados();

        PeriodoMeses periodoMeses = tipo.getPeriodoMeses();

        Assert.assertEquals(mesesOrdenados.get(0), periodoMeses.getPrimeiroMes());
        Assert.assertEquals(mesesOrdenados.get(11), periodoMeses.getUltimoMes());
    }

    @Test(dataProvider = "tipos")
    public void testarPrimeiroUltimoMesesOrdenadosContrario(AnoFiscalTipo tipo) {
        OrganizadorMeses organizadorMeses = tipo.getOrganizadorMeses();

        List<Month> mesesOrdenadosContrario = Stream.of(Month.values())
                .sorted(organizadorMeses.comparadorDeMeses().reversed())
                .collect(Collectors.toList());

        PeriodoMeses periodoMeses = tipo.getPeriodoMeses();

        Assert.assertEquals(mesesOrdenadosContrario.get(11), periodoMeses.getPrimeiroMes());
        Assert.assertEquals(mesesOrdenadosContrario.get(0), periodoMeses.getUltimoMes());
    }

    @Test(dataProvider = "tiposMeses")
    public void testarAnoFiscalData(AnoFiscalTipo tipo, Month mes) {

    }
}
