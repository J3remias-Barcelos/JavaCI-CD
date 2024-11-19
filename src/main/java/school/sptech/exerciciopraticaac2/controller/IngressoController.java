package school.sptech.exerciciopraticaac2.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import school.sptech.exerciciopraticaac2.entity.Ingresso;
import school.sptech.exerciciopraticaac2.entity.Show;
import school.sptech.exerciciopraticaac2.entity.TipoIngressoEnum;
import school.sptech.exerciciopraticaac2.service.IngressoService;
import school.sptech.exerciciopraticaac2.service.ShowService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ingressos")
public class IngressoController {

    private final IngressoService ingressoService;

    private final ShowService showService;

    @GetMapping
    public ResponseEntity<List<Ingresso>> listar() {
        List<Ingresso> ingressos = ingressoService.listar();
        return ingressos.isEmpty() ? ResponseEntity.status(204).build() : ResponseEntity.ok(ingressos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingresso> buscarPorId(@PathVariable Integer id) {
        Ingresso ingresso = ingressoService.buscarPorId(id);
        return ingresso == null ? ResponseEntity.status(404).build() : ResponseEntity.ok(ingresso);
    }

    @PostMapping("/shows/{showId}")
    public ResponseEntity<Ingresso> salvar(@Valid @RequestBody Ingresso ingresso, @PathVariable Integer showId) {
        Show show = showService.buscaPorId(showId);
        if (show == null) {
            return ResponseEntity.status(404).build(); // Show não existe
        }
        Ingresso ingressoSalvo = ingressoService.salvar(ingresso, showId);
        return ResponseEntity.status(201).body(ingressoSalvo); // Ingresso criado com sucesso
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Integer id) {
        if (ingressoService.buscarPorId(id) == null) {
            return ResponseEntity.status(404).build(); // Ingresso não existe
        }
        ingressoService.deletar(id);
        return ResponseEntity.status(204).build(); // Ingresso removido com sucesso
    }
}