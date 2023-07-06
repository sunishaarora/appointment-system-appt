package com.perficient.appts.apptmanagementsystemappts.controller;

import com.perficient.appts.apptmanagementsystemappts.entity.ApptsEntity;
import com.perficient.appts.apptmanagementsystemappts.service.ApptsListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value = "api/v1/")
@RestController
public class ApptsListController {

    private ApptsListService service;

    @Autowired
    ApptsListController(ApptsListService service) {
        this.service = service;
    }

    @RequestMapping(value="/appts", method = RequestMethod.GET)
    public ResponseEntity<List<ApptsEntity>> getApptsList(){
        List<ApptsEntity> entity = service.getApptsList();
        if(entity!=null){
            return new ResponseEntity<>(entity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
