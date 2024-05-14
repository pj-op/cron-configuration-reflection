package org.test.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.test.entity.ActorDAO;
import org.test.repository.ActorRepository;
import org.test.request.impl.Actor;
import org.test.request.impl.Person;

import java.util.List;

@Slf4j
@Service
public class CommonService {
    @Autowired
    private ActorRepository actorRepository;

    private final String CLASS_NAME = this.getClass().getName();
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public String greetPersonAPI(String name) {
        log.info("Entered @{}.{}", CLASS_NAME, "greetPersonAPI");
        return "hi " + name + "Welcome!! ";
    }

    public String checkVotingEligibility(String reqString) {
        log.info("Entered @{}.{}", CLASS_NAME, "checkVotingEligibility");
        String reqPayLoad = reqString.substring(reqString.indexOf(':') + 1);
        Person person = gson.fromJson(reqPayLoad, Person.class);
        log.info("Person object: {}", person.getAge());
        return person.getAge() >= 18 ? "You can vote" : " You can't vote";
    }

    public String getActorInfo(String reqString) {
        log.info("Entered @{}.{}", CLASS_NAME, "getActorInfo");
        String reqPayLoad = reqString.substring(reqString.indexOf(':') + 1);
        Actor actor = gson.fromJson(reqPayLoad, Actor.class);
        log.info("Actor object: {}", actor.getFrom());
        String res = actor.getFrom().equalsIgnoreCase("South") ? "Tollywood" : "BollyWood";
        return "hi " + actor.getActorName() + ", .... " + res;
    }

    public String getActorInfoFromDB(String actorReqString) {
        log.info("Entered @{}.{}", CLASS_NAME, "getActorInfoFromDB");

        String reqPayLoad = actorReqString.substring(actorReqString.indexOf(':') + 1);
        Actor actor = gson.fromJson(reqPayLoad, Actor.class);
        log.info("Actor object: {}", actorRepository.findAll().size());

        String queryString = "%" + actor.getActorName() + "%";
        List<ActorDAO> actorsList = actorRepository.findByFirstNameLike(queryString).isEmpty() ? null : actorRepository.findByFirstNameLike(queryString);
        return gson.toJson(actorsList);
    }

}
