package com.meisterlampe.dockertestingarea2.controller;

import com.meisterlampe.dockertestingarea2.entities.Ausleihe;
import com.meisterlampe.dockertestingarea2.repository.AusleiheRepository;
import com.meisterlampe.dockertestingarea2.serviceImpl.AusleiheServiceImpl;
import com.meisterlampe.dockertestingarea2.services.AusleiheService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController()
@RequestMapping("api/")
public class AusleiheController {


    AusleiheRepository ausleiheRepository;
    AusleiheService ausleiheService;

    @RequestMapping(value = "/ausleihe/create", method = RequestMethod.POST)
    public void createAusleihe(Ausleihe ausleihe) {

        ausleiheRepository.save(ausleihe);

    }

    @RequestMapping(value = "/ausleihe/all", method = RequestMethod.GET)
    public Iterable<Ausleihe> alleAusleihen() {

        return ausleiheService.ausleiheAlle();

    }

    @RequestMapping(value = "/ausleihe/{idbookorder}", method = RequestMethod.GET)
    public Object findbyIdAusleihe(@PathVariable int idbookorder) {
        try {
            Optional<Ausleihe> ausleihe = ausleiheRepository.findById(idbookorder);

            return ausleihe;

        } catch (NumberFormatException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Die ID ist nicht vorhanden!");
        }
    }


}
