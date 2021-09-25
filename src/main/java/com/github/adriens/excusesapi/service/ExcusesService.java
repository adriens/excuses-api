/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.adriens.excusesapi.service;

import com.github.adriens.excuses.sdk.Excuse;
import com.github.adriens.excuses.sdk.Excuses;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author 3004SAL
 */
@Service
public class ExcusesService {
    private static Excuses excuses = new Excuses();
    
    public Excuse getById(int excuseId) throws Exception {
        return excuses.getById(excuseId);
    }
    
    public List<String> getCategories() throws Exception {
        return excuses.getCategories();
    }
    
    // Collection d'excuses
    public List<Excuse> getAll() throws Exception {
        return excuses.getAll();
    }
    
    public List<Excuse> getAll(int maxLength) throws Exception {
        return excuses.getAll(maxLength);
    }
    
    public List<Excuse> getByCat(String aCategory) throws Exception {
        return excuses.getByCategory(aCategory);
    }
    public List<Excuse> getByCat(String aCategory,int maxLength) throws Exception {
        return excuses.getByCategory(aCategory,maxLength);
    }
    
    // Excuse au hasard
    public Excuse pickRandomly() throws Exception {
        return excuses.pickRandomly();
    }
    
    public Excuse pickRandomly(String aCategory) throws Exception {
        return excuses.pickRandomly(aCategory);
    }
    
    public Excuse pickRandomly(int maxLength) throws Exception {
        return excuses.pickRandomly(maxLength);
    }
    
    public Excuse pickRandomly(String aCategory, int maxLength) throws Exception {
        return excuses.pickRandomly(aCategory, maxLength);
    } 
}
