package school.sptech.exerciciopraticaac2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Ingresso {
    // id: Integer
    //preco: Double
    //tipoIngresso: TipoIngresso (Enum)
    //show: Show (Entidade Show)
    // Muitos ingressos para um show.
    //
    //Um ingresso pode ser do tipo INTEIRA, MEIA ou CORTESIA(Esse campo não pode ser nulo).
    //
    //Um ingresso tem um preço (Esse campo não pode ser nulo, valor mínimo 30.0).
    //
    //Um ingresso tem um precoFinal que é calculado de acordo com o tipo do ingresso (Campo calculado).
    //
    //Inteira: precoFinal = preco
    //Meia: precoFinal = preco / 2
    //Cortesia: precoFinal = 0
    //Um ingresso pertence a um show (Não pode existir ingresso sem show).

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Preço não pode ser nulo")
    @Min(value = 30, message = "Preço deve ser no mínimo 30")
    private Double preco;

    @NotNull(message = "Tipo de ingresso não pode ser nulo")
    @Enumerated(EnumType.STRING)
    private TipoIngressoEnum tipoIngresso;

    @ManyToOne
    @JoinColumn(name = "show_id", nullable = false)
    @NotNull(message = "Show não pode ser nulo")
    private Show show;

    @Transient
    private Double precoFinal;

    public Double getPrecoFinal() {
        switch (tipoIngresso) {
            case INTEIRA:
                return preco;
            case MEIA:
                return preco / 2;
            case CORTESIA:
                return 0.0;
            default:
                throw new IllegalArgumentException("Tipo de ingresso desconhecido");
        }
    }
}
