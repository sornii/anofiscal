package sornii.anofiscal;

/**
 * Define qual o mês que dirá o ano fiscal de uma data.
 */
public enum AnoFiscalMesReferencia {

    /**
     * Quando a referência for o último mês, o ano do último mês será utilizada para
     * definir o ano do ano fiscal.
     */
    ULTIMO_MES,

    /**
     * Quando a referência for o primeiro mês, o ano do primeiro mês será utilizada para
     * definir o ano do ano fiscal.
     */
    PRIMEIRO_MES
}
