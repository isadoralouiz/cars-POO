package br.edu.ifpr.cars.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import br.edu.ifpr.cars.domain.Passeger;
import br.edu.ifpr.cars.domain.PassegerRepository;

@Service
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class PassegerController {

    @Autowired
    PassegerRepository passegerRepository;

    // Listar todos
    @GetMapping("/passegers")
    public List<Passeger> listPassegers() {
        return passegerRepository.findAll();
    }

    // Buscar id
    @GetMapping("/passegers/{id}")
    public Passeger findPasseger(@PathVariable("id") Long id) {
        return passegerRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Passageiro não encontrado"));
    }

    // Criar novo
    @PostMapping("/passegers")
    public Passeger createPasseger(@RequestBody Passeger passeger) {
        return passegerRepository.save(passeger);
    }

    // Atualização completa (PUT)
    @PutMapping("/passegers/{id}")
    public Passeger fullUpdatePasseger(@PathVariable("id") Long id, @RequestBody Passeger passeger) {
        Passeger foundPasseger = findPasseger(id);
        foundPasseger.setName(passeger.getName());
        foundPasseger.setEmail(passeger.getEmail());
        return passegerRepository.save(foundPasseger);
    }

    // Atualização parcial (PATCH) — forma compatível com todas as versões
    @RequestMapping(value = "/passegers/{id}", method = RequestMethod.PATCH)
    public Passeger incrementalUpdatePasseger(@PathVariable("id") Long id, @RequestBody Passeger passeger) {
        Passeger foundPasseger = findPasseger(id);
        foundPasseger.setName(Optional.ofNullable(passeger.getName()).orElse(foundPasseger.getName()));
        foundPasseger.setEmail(Optional.ofNullable(passeger.getEmail()).orElse(foundPasseger.getEmail()));
        return passegerRepository.save(foundPasseger);
    }

    // Deletar
    @DeleteMapping("/passegers/{id}")
    public void deletePasseger(@PathVariable("id") Long id) {
        Passeger foundPasseger = findPasseger(id);
        passegerRepository.delete(foundPasseger);
    }
}
