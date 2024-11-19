package school.sptech.exerciciopraticaac2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import school.sptech.exerciciopraticaac2.entity.Show;
import school.sptech.exerciciopraticaac2.repository.ShowRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShowService {

    private final ShowRepository showRepository;

    public List<Show> listar() {
        return showRepository.findAll();
    }

    public Show buscaPorId(Integer id) {
        return showRepository.findById(id).orElse(null);
    }

    public Show salvar(Show show) {
        return showRepository.save(show);
    }

    public void deletar(Integer id) {
        showRepository.deleteById(id);
    }

    public boolean existeShowNoMesmoLocalEData(String localizacao, LocalDateTime data) {
        return showRepository.existsByLocalizacaoAndData(localizacao, data);
    }
}