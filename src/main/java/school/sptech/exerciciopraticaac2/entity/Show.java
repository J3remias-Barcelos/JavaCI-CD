package school.sptech.exerciciopraticaac2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Show {
    // id: Integer
    //nome: string
    //localizacao: string
    //data: LocalDateTime
    //Um show pode ter muitos ingressos (NÃO DEVE ser bidirecional).
    //Um show tem um nome (Esse campo não pode ser nulo, nem ser vazio, nem conter apenas espaços).
    //Um show tem uma localização (Esse campo não pode ser nulo, nem ser vazio, nem conter apenas espaços).
    //Um show tem uma data (Esse campo não pode ser nulo, e deve ser uma data futura).
    //Não deve ser possível ter 2 shows no mesmo local e na mesma data (realizar pesquisa no banco antes de salvar).

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String nome;

    @NotBlank
    private String localizacao;

    @NotNull
    @Future
    private LocalDateTime data;
}
