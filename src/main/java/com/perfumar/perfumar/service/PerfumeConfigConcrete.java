package com.perfumar.perfumar.service;

import com.perfumar.perfumar.utils.ConfigObserver;
import com.perfumar.perfumar.utils.ConfigType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class PerfumeConfigConcrete implements ConfigObserver {

    private static final Logger logger = LogManager.getLogger(PerfumeConfigConcrete.class);

    @Autowired
    ConfigSubject configSubject;
    @Autowired
    ConfigService configService;

    private String name;

    @Override
    public void updateConfig(Object event) {
        logger.info("Actualiza el config");
        if (event.equals(ConfigType.PERFUME)) {
            this.name = configService.getPerfumeName();
            logger.info("Nombre nuevo {}", this.name);
        }
    }

}
