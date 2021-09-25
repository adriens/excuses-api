/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.adriens.excusesapi.controller;

import com.github.adriens.excuses.sdk.Excuse;
import com.github.adriens.excusesapi.service.ExcusesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 3004SAL
 */
@RestController
public class ExcusesController {
    
    @Autowired
    private ExcusesService excusesService;
    
    @GetMapping("/categories")
    public List<String> getCategories() throws Exception {
        return excusesService.getCategories();
    }
    
    @GetMapping(value = "/excuses/{excuseId}")
    public Excuse getExcuse(@PathVariable int excuseId) throws Exception {
        return excusesService.getById(excuseId);
    }
    
    @GetMapping(value = "/excuses")
    public List<Excuse> getExcuses(
            @RequestParam(value = "maxLength", defaultValue = "100") int maxLength,
            @RequestParam(value = "category", defaultValue = "") String category
    ) throws Exception {
        if(category.length() == 0){
            return excusesService.getAll(maxLength);
        }
        else{
            return excusesService.getByCat(category, maxLength);
        }
        
    }
    
    @GetMapping(value = "/excuses/rand")
    public Excuse getExcusesRandomly(
            @RequestParam(value = "maxLength", defaultValue = "100") int maxLength,
            @RequestParam(value = "category", defaultValue = "") String category
    ) throws Exception {
        if(category.length() == 0){
            return excusesService.pickRandomly(maxLength);
        }
        else{
            return excusesService.pickRandomly(category, maxLength);
        }
        
    }
    //
    @GetMapping(value = "/excuses/{category}")
    public List<Excuse> getExcuses(@PathVariable String category) throws Exception {
        return excusesService.getByCat(category);
    }
}
