package sornii.anofiscal;

import java.time.Month;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

final class OrganizadorMeses {

    private Comparator<Month> comparadorMeses;

    public OrganizadorMeses(Month primeiroMes, Month ultimoMes) {

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

    OrganizadorMeses(PeriodoMeses periodoMeses) {
        this(periodoMeses.getPrimeiroMes(), periodoMeses.getUltimoMes());
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
