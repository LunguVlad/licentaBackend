package licenta.backend.controllers;

import licenta.backend.services.PlataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RequestMapping("/plata")
@RestController
public class PlataController {
    @Autowired
    private PlataService plataService;

    @PostMapping("/createPlata/{listaPlataId}")
    public ResponseEntity createPlata(@PathVariable int listaPlataId){
        try {
            plataService.createPlata(listaPlataId);
            HashMap<String,String> emptyResponse = new HashMap<>();
            return ResponseEntity.ok(emptyResponse);
        }catch (Exception ex){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/getPlata/{listaPlataId}")
    public ResponseEntity getPlata(@PathVariable int listaPlataId){
        try {
            return ResponseEntity.ok(plataService.getPlataByListaPlata(listaPlataId));
        }catch (Exception ex){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
