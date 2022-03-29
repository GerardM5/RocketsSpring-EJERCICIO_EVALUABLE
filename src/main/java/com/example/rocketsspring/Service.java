package com.example.rocketsspring;

import java.util.ArrayList;
import java.util.List;

public class Service {

    private RocketRepository rocketRepository;
    private PropellerRepository propellerRepository;

    public Service(RocketRepository rocketRepository, PropellerRepository propellerRepository) {
        this.rocketRepository = rocketRepository;
        this.propellerRepository = propellerRepository;
    }


    //ROCKETS:

    public Rocket createRocket(Rocket rocket) {
        rocketRepository.save(rocket);
        return rocket;
    }

    public List<Rocket> getRocketList() {
        List<Rocket> rocketList = new ArrayList<>();
        rocketRepository.findAll().forEach(rocketList::add);
        return rocketList;
    }

    public void deleteRockets() {
        rocketRepository.deleteAll();
    }

    public String actionPropellers(String toDO, String rocketId) {
        if (toDO.equalsIgnoreCase("Speed Up")) {
            findRocket(rocketId).speedUp();
            return findRocket(rocketId).toString();
        }
        if (toDO.equalsIgnoreCase("SpeedDown")) {
            findRocket(rocketId).speedDown();
            return findRocket(rocketId).toString();
        }
        return "No se ha encontrado Rocket";
    }

    public Rocket updateRocketId(String rocketId, String newRocketId) {
        findRocket(rocketId).setId(newRocketId);
        return findRocket(rocketId);
    }

    public Rocket getRocket(String rocketId) {
        return findRocket(rocketId);
    }

    private Rocket findRocket(String rocketId) {
        return rocketRepository.findById(rocketId).get();
    }

    public void deleteRocket(String rocketId) {
        rocketRepository.deleteById(rocketId);
    }

    //PROPELLERS:

    public Propeller createPropeller(String rocketId, Propeller propeller) throws Exception {
        Rocket rocket = findRocket(rocketId);
        propeller = rocket.createPropeller(propeller);
        findRocket(rocketId).createPropeller(propeller);
        return findRocket(rocketId).getPropellers().get()
    }

}
