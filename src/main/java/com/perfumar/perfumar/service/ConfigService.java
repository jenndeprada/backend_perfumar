package com.perfumar.perfumar.service;

import com.perfumar.perfumar.utils.ConfigType;
import org.springframework.beans.factory.annotation.Autowired;

public class ConfigService {

    @Autowired
    ConfigSubject configSubject;

    private String perfumeName;

    public void updatePerfumeConfig(String perfumeNameParam) {
        perfumeName = perfumeNameParam;
        configSubject.notifyObservers(ConfigType.PERFUME);
    }

    public String getPerfumeName() {
        return perfumeName;
    }

    public void setPerfumeName(String perfumeName) {
        this.perfumeName = perfumeName;
    }

}
