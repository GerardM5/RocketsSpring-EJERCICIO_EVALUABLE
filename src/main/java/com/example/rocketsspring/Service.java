package com.example.rocketsspring;

import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;


@Controller
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

    public Rocket moveRocket(String rocketId, Movement movement){
        Rocket rocket = rocketRepository.findById(rocketId).get();

        for (int i = 0; i < movement.getTimes(); i++) {
            if(movement.getMovementType().equals(Movement.ACCELERATE)){
                rocket.speedUp();
            }else if(movement.getMovementType().equals(Movement.BRAKE)){
                rocket.speedDown();
            }
        }

        propellerRepository.saveAll(rocket.getPropellers());
        return rocket;
    }

    public void deleteRocketList() {
        rocketRepository.deleteAll();
    }

    public Rocket movementRocket(String toDO, String rocketId) throws Exception {

        Rocket rocket = findRocket(rocketId);

        if (toDO.equalsIgnoreCase("Speed Up")) {
            rocket.speedUp();
        }
        if (toDO.equalsIgnoreCase("SpeedDown")) {
            rocket.speedDown();
        }

        propellerRepository.saveAll(rocket.getPropellers());
        return rocket;
    }

    public Rocket updateRocketName(String rocketId, String newRocketId) {
        findRocket(rocketId).setName(newRocketId);
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
        propellerRepository.save(propeller);
        return propeller;
    }

    public Propeller updatePropeller(String propellerId, Propeller newPropeller){
        Propeller propeller = findPropeller(propellerId);
        propeller.setMaxPower(newPropeller.getMaxPower());
        return propeller;
    }

    private Propeller findPropeller(String propellerId) {
        return propellerRepository.findById(propellerId).get();
    }

    public List<Propeller> getPropellerList(String rocketId){
        return findRocket(rocketId).getPropellers();
    }

    public Propeller getPropeller(String propellerId){
        return findPropeller(propellerId);
    }

    public void deletePropellerList(String rocketId){
        propellerRepository.deleteAllByRocket(findRocket(rocketId));
    }

    public void deletePropeller (String propellerId){
        propellerRepository.deleteById(propellerId);
    }

}
