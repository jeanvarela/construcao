package br.com.controlador;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/primeiro")
public class PrimeiroControlador {

    @GetMapping
    public ResponseEntity<String> primeira(){
        return new ResponseEntity<>("Saida", HttpStatus.OK);
    }
}
