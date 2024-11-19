package school.sptech.exerciciopraticaac2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.sptech.exerciciopraticaac2.entity.Ingresso;
import school.sptech.exerciciopraticaac2.entity.Show;
import school.sptech.exerciciopraticaac2.repository.IngressoRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IngressoService {

    private final IngressoRepository ingressoRepository;
    private final ShowService showService;

    public List<Ingresso> listar() {
        return ingressoRepository.findAll();
    }

    public Ingresso buscarPorId(Integer id) {
        return ingressoRepository.findById(id).orElse(null);
    }

    public Ingresso salvar(Ingresso ingresso, Integer showId) {
        Show show = showService.buscaPorId(showId);
        if (show == null) {
            throw new IllegalArgumentException("Show não encontrado");
        }
        ingresso.setShow(show);
        return ingressoRepository.save(ingresso);
    }

    public void deletar(Integer id) {
        ingressoRepository.deleteById(id);
    }
}
