package com.perfumar.perfumar.inteceptor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AOPApplied {

    Logger logger = LogManager.getLogger(AOPApplied.class);

    //*****************GET REQUEST********************+
    @Pointcut("execution(* com.perfumar.perfumar.controller.PerfumeController.getAllPerfumes(..))")
    void forTraceGetMethod() {}

    @Before("forTraceGetMethod()")  //
    void beforeGetPerfumeFromDB(){
        logger.info("Consiguiendo los perfumes de la base de datos... ");
    }
    @AfterReturning("forTraceGetMethod()")  //si no hay errores en el get request
    void afterGettingFromDB(){
        logger.info("Perfumes traidos de DB satisfactoriamente");
    }

    //*****************GET REQUEST BY ID********************+
    @Pointcut("execution(* com.perfumar.perfumar.controller.PerfumeController.getPerfumeById(..))")
    void forTraceGetIDMethod() {}

    @Before("forTraceGetIDMethod()")  //
    void beforeGetIDPerfumeFromDB(){
        logger.info("Consiguiendo el perfume con el ID seleccionado...");
    }
    @AfterReturning("forTraceGetIDMethod()")  //si no hay errores en el get request del ID
    void afterGettingIfWorks(){
        logger.info("Perfumes traidos de DB satisfactoriamente");
    }
    @AfterThrowing("forTraceGetIDMethod()")  //si llega a haber errores en el request
    void afterGettingIfDoesntWork(){
        logger.info("No se pudo hallar el perfume, tal vez no exista en DB");
    }

    //***************PUT REQUEST************************

    @Pointcut("execution(* com.perfumar.perfumar.controller.PerfumeController.addPerfume(..))")
    void forTracePostMethod() {}

    @Before("forTracePostMethod()")  //
    void beforePostPerfume(){
        logger.info("Preparando para postear el perfumes en la base de datos... ");
    }
    @AfterReturning("forTracePostMethod()")
    void afterPostingPefume(){
        logger.info("Perfume posteado en DB satisfactoriamente");
    }


    //***************DELETE REQUEST************************

    @Pointcut("execution(* com.perfumar.perfumar.controller.PerfumeController.deletePerfumeById(..))")
    void forDeleteMethod() {}

    @AfterReturning("forDeleteMethod()")
    void afterDeletePerfume(){
        logger.info("Eliminando perfume de la DB");
    }

    //***************UPDATE REQUEST************************

    @Pointcut("execution(* com.perfumar.perfumar.controller.PerfumeController.updatePerfume(..))")
    void forTraceUpdateMethod() {}

    @Before("forTracePostMethod()")  //
    void beforeUpdatePerfume(){
        logger.info("Por actualizar el perfume seleccionado...");
    }

    @AfterReturning("forTracePostMethod()")
    void afterUpdatingPerfume(){
        logger.info("Perfume actualizado correctamente...");
    }

    @AfterThrowing("forTracePostMethod()")
    void afterUpdatingPerfumeIfFail(){
        logger.info("No se pudo actualizar el perfume correctamente");
    }






}
