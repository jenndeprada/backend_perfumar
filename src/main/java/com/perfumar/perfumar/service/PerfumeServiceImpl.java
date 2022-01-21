package com.perfumar.perfumar.service;

import com.perfumar.perfumar.controller.PerfumeController;
import com.perfumar.perfumar.model.Perfume;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PerfumeServiceImpl implements PerfumeService{

    Logger logger = LogManager.getLogger(PerfumeController.class);

    private static List<Perfume> DB = new ArrayList<>();

    @Override
    public List<Perfume> getAllPerfumes() {
        return DB;
    }

    @Override
    public int insertPerfume(UUID id, Perfume perfume) {
        DB.add(new Perfume(id, perfume.getName()));
        return 1;
    }

    @Override
    public Optional<Perfume> selectPerfumeById(UUID id) {
        return DB.stream().filter(perfume -> perfume.getId().equals(id)).findFirst();
    }

    @Override
    public boolean isPerfumeInDB(UUID id) {
        int i = 0;
        logger.info(DB.size());
        while(i < DB.size() ){
            if(DB.get(i).getId().equals(id)){
                logger.error("ENtra");
                return true;
            }
            i++;
        }
        return false;
    }
}
