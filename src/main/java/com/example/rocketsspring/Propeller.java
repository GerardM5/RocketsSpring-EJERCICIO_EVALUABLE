package com.example.rocketsspring;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Entity(name = "propellers")
public class Propeller {
    @Id
    private String id = UUID.randomUUID().toString();
    private int maxPower;
    private int currentPower;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "rocket_id")
    private Rocket rocket;

    public Propeller() {

    }

    public Propeller(int maxPower) throws Exception {
        checkMaxPower(maxPower);
        this.maxPower = maxPower;
        currentPower = 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setMaxPower(int maxPower) {
        this.maxPower = maxPower;
    }

    public void setCurrentPower(int currentPower) {
        this.currentPower = currentPower;
    }

    public Rocket getRocket() {
        return rocket;
    }

    public void setRocket(Rocket rocket) {
        this.rocket = rocket;
    }

    private void checkMaxPower(int maxPower) throws Exception {
        if (maxPower % 10 != 0 && maxPower == 0) throw new Exception("Maxima potencia incorrecta");
    }

    public void speedUp() {
        currentPower += 10;
        if (currentPower > maxPower) {
            currentPower=maxPower;
        }
    }

    public void speedDown() {
        if (currentPower > 0) {
            currentPower -= 10;
        }
    }

    public int getMaxPower() {
        return maxPower;
    }

    public int getCurrentPower() {
        return currentPower;
    }

    @Override
    public String toString() {
        return "Propeller{" +
                "MaxPower=" + maxPower +
                '}';
    }
}
