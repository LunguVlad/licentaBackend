package licenta.backend.controllers;

import licenta.backend.models.Bloc;
import licenta.backend.services.BlocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/bloc")
@RestController
public class BlocController {
    @Autowired
    private BlocService blocService;

    @GetMapping("/{numarBloc}")
    public ResponseEntity getBloc(@PathVariable int numarBloc){
        return ResponseEntity.ok(blocService.getBloc(numarBloc));
    }

    @PostMapping("create")
    public ResponseEntity createBloc(@RequestBody Bloc bloc){
        return ResponseEntity.ok(blocService.addBloc(bloc));
    }
}
