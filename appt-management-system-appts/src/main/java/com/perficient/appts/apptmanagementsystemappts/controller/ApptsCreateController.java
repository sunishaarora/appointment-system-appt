package com.perficient.appts.apptmanagementsystemappts.controller;

import com.perficient.appts.apptmanagementsystemappts.entity.ApptsEntity;
import com.perficient.appts.apptmanagementsystemappts.model.Appts;
import com.perficient.appts.apptmanagementsystemappts.service.ApptsCreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RequestMapping(value = "api/v1/appts/")
@RestController
public class ApptsCreateController {
    private ApptsCreateService service;

    @Autowired
    ApptsCreateController(ApptsCreateService service) {
        this.service = service;
    }

    @RequestMapping(value="/add", method = RequestMethod.POST)
    public ResponseEntity<Void> createAppt(@RequestBody Appts appts){
        ApptsEntity newAppts = service.createAppt(appts);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newAppts.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
