package com.example.rocketsspring;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rockets")
public class RocketRestController {

    private Service service;

    public RocketRestController(Service service){
        this.service = service;
    }

    @PostMapping
    public Rocket createRocket(@RequestBody Rocket rocket){
        return service.createRocket(rocket);
    }

    @PutMapping("/{rocketId}")
    public Rocket updateRocketId(@PathVariable String rocketId, @RequestBody String newRocketId){
        return service.updateRocketId(rocketId, newRocketId);
    }

    @GetMapping
    public List<Rocket> getRocketList(){
        return service.getRocketList();
    }

    @GetMapping("{rocketId}")
    public Rocket getRocket (@PathVariable String rocketId){
        return service.getRocket(rocketId);
    }

    @DeleteMapping
    public void deleteRocketList(){
        service.deleteRocketList();
    }

    @DeleteMapping("/{rocketId}")
    public void deleteRocket(@PathVariable String rocketId){
        service.deleteRocket(rocketId);
    }

}
