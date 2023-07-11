package com.perficient.appts.apptmanagementsystemappts.controller;

import com.perficient.appts.apptmanagementsystemappts.entity.ApptsEntity;
import com.perficient.appts.apptmanagementsystemappts.model.Appts;
import com.perficient.appts.apptmanagementsystemappts.service.ApptsCreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping(value = "api/v1/appts/")
@RestController
public class ApptsCreateController {
    private ApptsCreateService service;

    @Autowired
    ApptsCreateController(ApptsCreateService service) {
        this.service = service;
    }

    @RequestMapping(value="/add", method = RequestMethod.POST)
    public ResponseEntity<?> createAppt(@RequestBody Appts appts){
        try {
            if(appts.getUserId()==null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User ID cannot be null");
            ApptsEntity newAppts = service.createAppt(appts);
            return ResponseEntity.ok(newAppts);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create appointment.");
        }
    }
}
