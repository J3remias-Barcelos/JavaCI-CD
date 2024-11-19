package school.sptech.exerciciopraticaac2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.sptech.exerciciopraticaac2.entity.Show;

import java.time.LocalDateTime;

public interface ShowRepository extends JpaRepository<Show, Integer> {

    boolean existsByLocalizacaoAndData(String localizacao, LocalDateTime data);
}
