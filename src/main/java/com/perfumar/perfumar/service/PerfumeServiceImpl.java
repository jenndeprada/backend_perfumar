package com.perfumar.perfumar.service;

import com.perfumar.perfumar.controller.PerfumeController;
import com.perfumar.perfumar.model.Perfume;
import com.perfumar.perfumar.utils.ConfigType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

}
