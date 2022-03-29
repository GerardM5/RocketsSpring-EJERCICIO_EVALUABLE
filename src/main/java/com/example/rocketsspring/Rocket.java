package com.example.rocketsspring;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Entity(name = "users")
public class Rocket {
    @Id
    private String id = UUID.randomUUID().toString();
    private int numPropellers;
    @OneToMany(mappedBy = "propeller")
    private List<Propeller> propellers = new ArrayList<>();

    public Rocket(){

    }

    public Rocket(String id, int numPropellers) throws Exception {
        checkId(id);
        this.id = id;
        this.numPropellers = numPropellers;
    }

    public Propeller createPropeller(Propeller propeller) throws Exception {
        propeller.setRocket(this);
        this.propellers.add(propeller);
        return propeller;
    }


    private void checkId(String id) throws Exception {
        if (id.length() != 8) throw new Exception("ID incorrecto");
    }


    public int getNumPropellers() {

        return numPropellers;
    }

    public String getId() {
        return id;
    }

    public void setNumPropellers(int numPropellers) {
        this.numPropellers = numPropellers;
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

    @Override
    public String toString() {
        return "Rocket{" +
                "id='" + id + '\'' +
                ", currentPower=" + numPropellers +
                ", propellers=" + propellers +
                '}';
    }
}
