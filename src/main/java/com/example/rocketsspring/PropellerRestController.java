package com.example.rocketsspring;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rockets/{rocketId}/propellers")
public class PropellerRestController {

    private Service service;

    public PropellerRestController(Service service){
        this.service = service;
    }

    @PostMapping
    public Propeller createPropeller(@PathVariable String rocketId,@RequestBody Propeller propeller) throws Exception {
        return service.createPropeller(rocketId, propeller);
    }
    @PutMapping("/{propellerId}")
    public Propeller updatePropeller(@PathVariable String propellerId, @RequestBody Propeller propeller, @PathVariable String rocketId){
        return service.updatePropeller(propellerId,propeller);
    }

    @GetMapping
    public List<Propeller> getPropellerList(@PathVariable String rocketId){
        return service.getPropellerList(rocketId);
    }

    @GetMapping("/{propellerId}")
    public Propeller getPropeller(@PathVariable String propellerId, @PathVariable String rocketId){
        return service.getPropeller(propellerId);
    }

    @DeleteMapping
    public void deletePropellerList(@PathVariable String rocketId){
        service.deletePropellerList(rocketId);
    }

    @DeleteMapping("/{propellerId}")
    public void deletePropeller(@PathVariable String propellerId, @PathVariable String rocketId){
        service.deletePropeller(propellerId);
    }


}
