package ru.salikhov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import ru.salikhov.model.Socks;
import ru.salikhov.service.SocksService;

import javax.validation.Valid;


@Controller
@RequestMapping("/api/socks")
public class SocksController {

    @Autowired
    private SocksService socksService;

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity handleMethodArgumentNotValidException() {
        return new ResponseEntity("Invalid request param", HttpStatus.BAD_REQUEST);
    }

    @PostMapping(value = "/income")
    public ResponseEntity income(@RequestBody @Valid Socks socks) {

        socksService.income(Socks.toEntity(socks));
        return ResponseEntity.ok("Socks income");

    }

    @PostMapping("/outcome")
    public ResponseEntity outcome(@RequestBody @Valid Socks socks) {
        return ResponseEntity.ok(socksService.outcome(Socks.toEntity(socks)) ?
                                                "Socks outcome" : "Not enough socks");
    }

    @GetMapping
    @Transactional(readOnly = true)
    public ResponseEntity get(@RequestParam String color,
                              @RequestParam String operation,
                              @RequestParam int cottonPart) {
        return ResponseEntity.ok(socksService.get(color, operation, cottonPart));
    }
}
