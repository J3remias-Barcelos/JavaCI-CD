package school.sptech.exerciciopraticaac2.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.exerciciopraticaac2.entity.Show;
import school.sptech.exerciciopraticaac2.service.ShowService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shows")
public class ShowController {

    private final ShowService showService;

    @GetMapping
    public ResponseEntity<List<Show>> listar() {
        List<Show> shows = showService.listar();
        return shows.isEmpty() ? ResponseEntity.status(204).build() : ResponseEntity.ok(shows);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Show> buscaPorId(@PathVariable Integer id) {
        Show show = showService.buscaPorId(id);
        return show == null ? ResponseEntity.status(404).build() : ResponseEntity.ok(show);
    }

    @PostMapping
    public ResponseEntity<Show> salvar(@Valid @RequestBody Show show) {
        boolean showExists = showService.existeShowNoMesmoLocalEData(show.getLocalizacao(), show.getData());
        if (showExists) {
            return ResponseEntity.status(409).build(); // Conflito: show no mesmo local e data
        }
        Show showSalvo = showService.salvar(show);
        return ResponseEntity.status(201).body(showSalvo); // Show criado com sucesso
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Integer id) {
        if (showService.buscaPorId(id) == null) {
            return ResponseEntity.status(404).build(); // Show não existe
        }
        showService.deletar(id);
        return ResponseEntity.status(204).build(); // Show removido com sucesso
    }
}