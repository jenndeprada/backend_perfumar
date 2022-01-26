package com.perfumar.perfumar.service;

import com.perfumar.perfumar.controller.PerfumeController;
import com.perfumar.perfumar.handler.HandleExceptionInRest;
import com.perfumar.perfumar.model.Perfume;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PerfumeServiceImpl implements PerfumeService{

    Logger logger = LogManager.getLogger(PerfumeController.class);

    private static List<Perfume> DB = new ArrayList<>();
    int count;

    @Override
    public List<Perfume> getAllPerfumes() {
        return DB;
    }

    @Override
    public int insertPerfume(Perfume perfume) {
        int id = count + 1;
        count = id;
        DB.add(new Perfume(id, perfume.getName(), perfume.getBrand()));
        return 1;
    }

    @Override
    public Optional<Perfume> selectPerfumeById(int id) {
        return DB.stream().filter(perfume -> Objects.equals(perfume.getId(), id)).findFirst();
    }

    @Override
    public boolean isPerfumeInDB(int id) {
        int i = 0;
        logger.info(DB.size());
        while(i < DB.size() ){
            if(Objects.equals(DB.get(i).getId(), id)){
                logger.error("ENtra");
                return true;
            }
            i++;
        }
        return false;
    }

    @Override
    public int deletePerfumeById(int id) {
        boolean theresPerfume = isPerfumeInDB(id);
        if(!theresPerfume){
            return 0; // if there is not a perfume in database, return 0. Otherwise, delete it.
        }
        DB.remove(selectPerfumeById(id).get());
        return 1;
    }

    @Override
    public int updatePerfumeById(int id, Perfume perfume){
        return selectPerfumeById(id).map(p -> {
            int indexOfPerfumeToUpdate = DB.indexOf(p);
            if(indexOfPerfumeToUpdate >= 0){
                DB.set(indexOfPerfumeToUpdate, new Perfume(id, perfume.getName(), perfume.getBrand()));
                return 1;
            }
            return 0;
        }) .orElse(0);
    }
}
