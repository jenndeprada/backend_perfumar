package com.perfumar.perfumar.controller;

import com.perfumar.perfumar.domain.PerfumeConfig;
import com.perfumar.perfumar.handler.HandleExceptionInRest;
import com.perfumar.perfumar.model.Perfume;
import com.perfumar.perfumar.service.ConfigService;
import com.perfumar.perfumar.service.PerfumeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class PerfumeController {

    Logger logger = LogManager.getLogger(PerfumeController.class);

    @Autowired
    private final PerfumeService perfumeService;

    public PerfumeController(PerfumeService perfumeService) {
        this.perfumeService = perfumeService;
    }

    @GetMapping
    public List<Perfume> getAllPerfumes(){
        logger.info("Get todos los perfumes de la DB");
        return perfumeService.getAllPerfumes();
    }

    @PostMapping
    public void addPerfume(@RequestBody Perfume perfume){
        logger.info("Post un perfume en la DB");
        perfumeService.insertPerfume(perfume);
    }

    @GetMapping("/{id}")
    public Optional<Perfume> getPerfumeById(@PathVariable("id") int id) throws HandleExceptionInRest {
        if (!perfumeService.isPerfumeInDB(id)) {
            logger.error("No se encuestra el perfume con el id seleccionado");
            throw new HandleExceptionInRest("No se encuentra el id del perfume en DB");
        } else {
            return perfumeService.selectPerfumeById(id);
        }
    }

    @Autowired
    ConfigService configService;

    @PutMapping("/{id}") //ruta para aplicar observer actualizando los atributos de un perfume
    PerfumeConfig updateConfig(@RequestBody PerfumeConfig perfumeConfig){
        logger.info("Put recibido para actualizar perfume");
        configService.updatePerfumeConfig(perfumeConfig.getName());
        return perfumeConfig;
    }


}
