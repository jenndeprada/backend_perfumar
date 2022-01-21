package com.perfumar.perfumar.service;
import com.perfumar.perfumar.model.Perfume;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PerfumeService {

    List<Perfume> getAllPerfumes();

    int insertPerfume(UUID id, Perfume perfume);

    default int insertPerfume(Perfume perfume){
        UUID id = UUID.randomUUID();
        return insertPerfume(id, perfume);
    }

    Optional<Perfume> selectPerfumeById(UUID id);

    boolean isPerfumeInDB(UUID id);
}
