package com.pengesoft.crmsystem;


import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrmApplication {
    private static Logger logger = Logger.getLogger(CrmApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(CrmApplication.class,args);
        logger.info(CrmApplication.class.getSimpleName() + " start success!");

    }
}
