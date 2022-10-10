package com.example.worktask.family.controllers;

import com.example.worktask.family.components.FamilyApp;
import com.example.worktask.family.data.FamilyWithMembers;
import com.example.worktask.family.data.dto.FamilyWithMembersDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Rest controller of this app
 */
@RestController
@RequestMapping("/api")

public class FamilyController {
    
    private final FamilyApp familyApp;

    /**
     * Class constructor
     * @param familyApp Instance of a class managing Family objects
     */
    @Autowired
    public FamilyController(FamilyApp familyApp) {
        this.familyApp = familyApp;
    }

    /**
     * API used to receive info about given family
     * @param id ID of the family
     * @return Family with members and HTTP status OK
     */
    @GetMapping("/get_family/{id}")
    ResponseEntity<?> getFamily(@PathVariable Long id){
        return new ResponseEntity<>(familyApp.getFamily(id), HttpStatus.OK);
    }

    /**
     * API used to add new family to database
     * @param family FamilyWithMembers object in a form of JSON file
     * @return Information if operation was a success
     */
    @PostMapping("/add_family")
    ResponseEntity<?> addFamily(@RequestBody FamilyWithMembersDTO family){
        return familyApp.validateFamilyData(family);
    }


}
