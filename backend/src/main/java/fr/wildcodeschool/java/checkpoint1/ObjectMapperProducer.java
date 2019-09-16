package fr.wildcodeschool.java.checkpoint1;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.enterprise.inject.Produces;
import javax.inject.Singleton;

@Singleton
public class ObjectMapperProducer {

    @Produces @Singleton
    public ObjectMapper createObjetMapper() {
        ObjectMapper om = new ObjectMapper();
        om.findAndRegisterModules();
        return om;
    }

}
