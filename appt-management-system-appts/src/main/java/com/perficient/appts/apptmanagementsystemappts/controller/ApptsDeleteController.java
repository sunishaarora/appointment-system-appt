package com.perficient.appts.apptmanagementsystemappts.controller;

import com.perficient.appts.apptmanagementsystemappts.service.ApptsDeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "api/v1/appts/")
@RestController
public class ApptsDeleteController {
    private ApptsDeleteService service;

    @Autowired
    ApptsDeleteController(ApptsDeleteService service) {
        this.service = service;
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteApptById(@PathVariable("id") Long id){
        try{
            if(service.deleteApptById(id)){
                return ResponseEntity.ok().body("Appointment deleted");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The Appointment ID does not exist.");
            }
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete.");
        }
    }
}
