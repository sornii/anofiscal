package sornii.anofiscal;

import lombok.Getter;

import java.time.Month;

/**
 * Utilizada para definição dinâmica do primeiro e do último mês de um calendário de ano fiscal
 */
@Getter
public class PeriodoMeses {

    private Month primeiroMes;

    private Month ultimoMes;

    private OrganizadorMeses organizadorMeses;

    PeriodoMeses(Month primeiroMes) {
        this.primeiroMes = primeiroMes;
        this.ultimoMes = primeiroMes.minus(1);
        this.organizadorMeses = new OrganizadorMeses(this);
    }
}
