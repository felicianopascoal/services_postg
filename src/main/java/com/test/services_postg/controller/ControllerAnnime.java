package com.test.services_postg.controller;


import com.test.services_postg.domain.Annime;
import com.test.services_postg.requests.RequestPostAnnime;
import com.test.services_postg.requests.RequestPutAnnime;
import com.test.services_postg.service.ServiceAnnime;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("annimes")
@Log4j
@RequiredArgsConstructor
public class ControllerAnnime {
    private final ServiceAnnime serviceAnimme;

    @GetMapping
    public ResponseEntity<List<Annime>> list(){
        return ResponseEntity.ok(serviceAnimme.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Annime> findById(@PathVariable long id){
        return ResponseEntity.ok(serviceAnimme.findByIdOrThrowBadRequestBody(id));
    }

    @PostMapping
    public ResponseEntity<Annime> save(@RequestBody RequestPostAnnime requestPostAnnime){
        return new  ResponseEntity<>(serviceAnimme.save(requestPostAnnime), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        serviceAnimme.delete(id);
        return new  ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replece(@RequestBody RequestPutAnnime requestPutAnnime){
        serviceAnimme.replece(requestPutAnnime);
        return new  ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
