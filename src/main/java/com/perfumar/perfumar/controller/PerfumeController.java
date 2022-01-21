package com.perfumar.perfumar.controller;

import com.perfumar.perfumar.handler.HandleExceptionInRest;
import com.perfumar.perfumar.handler.ThrowErrorMessage;
import com.perfumar.perfumar.model.Perfume;
import com.perfumar.perfumar.service.PerfumeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/perfumar")
public class PerfumeController {

    Logger logger = LogManager.getLogger(PerfumeController.class);

    @Autowired
    private final PerfumeService perfumeService;

    public PerfumeController(PerfumeService perfumeService) {
        this.perfumeService = perfumeService;
    }

    @GetMapping("/getAll")
    public List<Perfume> getAllPerfumes(){
        logger.info("Get todos los perfumes de la DB");
        return perfumeService.getAllPerfumes();
    }

    @PostMapping("/postPerfume")
    public void addPerfume(@RequestBody Perfume perfume){
        logger.info("Post un perfume en la DB");
        perfumeService.insertPerfume(perfume);
    }

    @GetMapping("/{id}")
    public Optional<Perfume> getPerfumeById(@PathVariable("id") UUID id) throws HandleExceptionInRest {
        if (!perfumeService.isPerfumeInDB(id)) {
            logger.error("No se encuestra el perfume con el id seleccionado");
            throw new HandleExceptionInRest("No se encuentra el id del perfume en DB");
        } else {
            return perfumeService.selectPerfumeById(id);
        }

    }
}
