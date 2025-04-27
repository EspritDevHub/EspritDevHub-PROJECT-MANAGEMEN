package com.example.projectmanagement.controllers;


import com.example.projectmanagement.Dtos.TacheDTO;
import com.example.projectmanagement.iservices.ITacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/Taches")
public class TacheController {
    @Autowired
    private ITacheService TacheService;

    @PostMapping
    public TacheDTO createTache(@RequestBody TacheDTO TacheDTO) {
        return TacheService.createTache(TacheDTO);
    }

    @GetMapping("/{id}")
    public TacheDTO getTacheById(@PathVariable String id) {
        return TacheService.getTacheById(id);
    }

    @GetMapping
    public List<TacheDTO> getAllTaches() {
        return TacheService.getAllTaches();
    }

    @PutMapping("/{id}")
    public TacheDTO updateTache(@PathVariable String id, @RequestBody TacheDTO TacheDTO) {
        return TacheService.updateTache(id, TacheDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteTache(@PathVariable String id) {
        TacheService.deleteTache(id);
    }
}
