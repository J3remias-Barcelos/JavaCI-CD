package school.sptech.exerciciopraticaac2.entity;

public enum TipoIngressoEnum {
    INTEIRA("Inteira"),
    MEIA("Meia"),
    CORTESIA("Cortesia");

    private final String descricao;

    TipoIngressoEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}

// package school.sptech.marketplaceresumido.entity.enums;
//
//public enum ProdutoTipoEnum {
//    ACESSORIO("Acessórios"),
//    ELETRONICO("Eletrônico"),
//    MODA("Moda");
//
//    private String descricao;
//
//    ProdutoTipoEnum(String descricao) {
//        this.descricao = descricao;
//    }
//}