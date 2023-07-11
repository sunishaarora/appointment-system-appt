package com.perficient.appts.apptmanagementsystemappts.controller;

import com.perficient.appts.apptmanagementsystemappts.entity.ApptsEntity;
import com.perficient.appts.apptmanagementsystemappts.service.ApptsGetService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "api/v1/appts/")
@RestController
public class ApptsGetController {

    private ApptsGetService service;

    @Autowired
    ApptsGetController(ApptsGetService service) {
        this.service = service;
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getApptById(@PathVariable("id") Long id){
        try {
            ApptsEntity entity = service.getApptById(id);
            if (entity != null) {
                return new ResponseEntity<>(entity, HttpStatus.OK);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The Appointment ID does not exist.");
            }
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The Appointment ID does not exist.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Could not retrieve appointment: " + e.getMessage());
        }
    }


}
