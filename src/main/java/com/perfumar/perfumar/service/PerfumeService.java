package com.perfumar.perfumar.service;
import com.perfumar.perfumar.model.Perfume;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PerfumeService {

    List<Perfume> getAllPerfumes();

    int insertPerfume(Perfume perfume);


    Optional<Perfume> selectPerfumeById(int id);

    boolean isPerfumeInDB(int id);
}
