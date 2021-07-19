package licenta.backend.controllers;

import licenta.backend.models.Cheltuiala;
import licenta.backend.services.CheltuialaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/cheltuiala")
@RestController
public class CheltuialaController {
    @Autowired
    private CheltuialaService cheltuialaService;

    @GetMapping("/{numarBloc}")
    public ResponseEntity getAllCheltuieliByBloc(@PathVariable int numarBloc){
        return ResponseEntity.ok(cheltuialaService.getAllCheltuieli(numarBloc));
    }

    @PostMapping("create/{numarBloc}")
    public ResponseEntity createCheltuiala(@RequestBody Cheltuiala cheltuiala, @PathVariable int numarBloc){
        return ResponseEntity.ok(cheltuialaService.addCheltuiala(cheltuiala,numarBloc));
    }
}
