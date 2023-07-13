package com.perficient.appts.apptmanagementsystemappts.controller;

import com.perficient.appts.apptmanagementsystemappts.entity.ApptsEntity;
import com.perficient.appts.apptmanagementsystemappts.model.Appts;
import com.perficient.appts.apptmanagementsystemappts.service.ApptsUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "api/v1/appts/")
@RestController
public class ApptsUpdateController {
    private ApptsUpdateService service;

    @Autowired
    ApptsUpdateController(ApptsUpdateService service) {
        this.service = service;
    }

    @RequestMapping(value="/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateAppt(@PathVariable("id") Long id, @RequestBody Appts appts){
        try {
            ApptsEntity newAppts = service.updateAppt(id, appts);
            return ResponseEntity.ok(newAppts);
        } catch(IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Appointment ID does not exist");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update appointment.");
        }
    }
}
