package com.perficient.appts.apptmanagementsystemappts.controller;

import com.perficient.appts.apptmanagementsystemappts.entity.ApptsEntity;
import com.perficient.appts.apptmanagementsystemappts.service.ApptsGetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "api/v1/")
@RestController
public class ApptsGetController {

    private ApptsGetService service;

    @Autowired
    ApptsGetController(ApptsGetService service) {
        this.service = service;
    }

    @RequestMapping(value="/appts/{id}", method = RequestMethod.GET)
    public ResponseEntity<ApptsEntity> getApptById(@PathVariable("id") Long id){
        ApptsEntity entity = service.getApptById(id);
        if(entity!=null){
            return new ResponseEntity<>(entity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
