package sornii.anofiscal;

import java.time.Month;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OrganizadorMeses {

    public static final Integer ULTIMA_ORDEM = 11;
    public static final Integer PRIMEIRA_ORDEM = 0;

    private Comparator<Month> comparadorMeses;

    public OrganizadorMeses(PeriodoMeses periodoMeses) {
        Month primeiroMes = periodoMeses.getPrimeiroMes();
        Month ultimoMes = periodoMeses.getUltimoMes();

        Map<Month, Integer> ordenacaoMeses = new EnumMap<>(Month.class);

        Month mes = primeiroMes;
        Integer ordenacao = 1;

        while (true) {

            ordenacaoMeses.put(mes, ordenacao);

            if (mes == ultimoMes) {
                break;
            }

            mes = mes.plus(1);
            ordenacao++;
        }

        comparadorMeses = Comparator.comparing(ordenacaoMeses::get);
    }

    @SuppressWarnings("squid:S2095")
    public List<Month> getMesesOrdenados() {
        return Stream.of(Month.values())
                .sorted(comparadorMeses)
                .collect(Collectors.toList());
    }

    public Month getMesNaOrdem(int ordem) {
        return getMesesOrdenados().get(ordem);
    }

    public int getOrdemDoMes(Month month) {
        return getMesesOrdenados().indexOf(month);
    }

    public Comparator<Month> comparadorDeMeses() {
        return comparadorMeses;
    }
}
