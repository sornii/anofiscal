package sornii.anofiscal;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.YearMonth;

public class AnoFiscalTest {

    //TODO: reconstruir testes

    @Test
    public void testarCalculadoraDataFiscal() {
        AnoFiscalPadraoMundial reinoUnido = AnoFiscalPadraoMundial.REINO_UNIDO;
        AnoFiscalPadrao anoFiscalPadrao = reinoUnido.getAnoFiscalPadrao();

        CalculadoraDataFiscal calculadoraDataFiscal = new CalculadoraDataFiscal();

        Assert.assertEquals(calculadoraDataFiscal.calcularDataFiscal(anoFiscalPadrao, YearMonth.of(2016, 8)), YearMonth.of(2017, 8));
        Assert.assertEquals(calculadoraDataFiscal.calcularDataFiscal(anoFiscalPadrao, YearMonth.of(2016, 2)), YearMonth.of(2016, 2));
        Assert.assertEquals(calculadoraDataFiscal.calcularDataFiscal(anoFiscalPadrao, YearMonth.of(2016, 4)), YearMonth.of(2017, 4));
        Assert.assertEquals(calculadoraDataFiscal.calcularDataFiscal(anoFiscalPadrao, YearMonth.of(2016, 3)), YearMonth.of(2016, 3));
    }

    @Test
    public void testarCalculadoraDataGregoriana() {
        AnoFiscalPadraoMundial reinoUnido = AnoFiscalPadraoMundial.REINO_UNIDO;
        AnoFiscalPadrao anoFiscalPadrao = reinoUnido.getAnoFiscalPadrao();

        CalculadoraDataGregoriana calculadoraDataGregoriana = new CalculadoraDataGregoriana();

        Assert.assertEquals(calculadoraDataGregoriana.calcularDataGregoriana(anoFiscalPadrao, YearMonth.of(2017, 2)), YearMonth.of(2017, 2));
        Assert.assertEquals(calculadoraDataGregoriana.calcularDataGregoriana(anoFiscalPadrao, YearMonth.of(2017, 4)), YearMonth.of(2016, 4));
    }
}
