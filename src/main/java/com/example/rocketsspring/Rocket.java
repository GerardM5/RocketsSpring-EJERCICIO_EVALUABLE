package com.example.rocketsspring;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Entity(name = "rockets")
public class Rocket {
    @Id
    private String id = UUID.randomUUID().toString();
    private String name;

    @OneToMany(mappedBy = "rocket")
    @JsonManagedReference
    private List<Propeller> propellers = new ArrayList<>();

    public Rocket(){

    }

    public Rocket(String name){
        this.name = name;

    }

    public Propeller createPropeller(Propeller propeller) throws Exception {
        propeller.setRocket(this);
        this.propellers.add(propeller);
        return propeller;
    }


    private void checkId(String id) throws Exception {
        if (id.length() != 8) throw new Exception("ID incorrecto");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumPropellers() {

        return propellers.size();
    }

    public String getId() {
        return id;
    }

    public List<Propeller> getPropellers() {
        return propellers;
    }

    public void setPropellers(List<Propeller> propellers) {
        this.propellers = propellers;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCurrentPower() {
        int currentPower = 0;
        for (Propeller currentPropeller : propellers) {
            currentPower += currentPropeller.getCurrentPower();
        }
        return currentPower;
    }

    public void speedUp() {
        for (Propeller currentPropeller : propellers) {
            currentPropeller.speedUp();
        }
    }

    public void speedDown() {
        for (Propeller currentPropeller : propellers) {
            currentPropeller.speedDown();
        }
    }

}
