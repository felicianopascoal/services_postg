package com.test.services_postg.service;

import com.test.services_postg.domain.Annime;
import com.test.services_postg.mape.MaperAnnime;
import com.test.services_postg.repository.RepositoryAnnime;
import com.test.services_postg.requests.RequestPostAnnime;
import com.test.services_postg.requests.RequestPutAnnime;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceAnnime {


    private final RepositoryAnnime repositoryAnnime;

    public List<Annime> listAll(){
        return repositoryAnnime.findAll();
    }

    public Annime findByIdOrThrowBadRequestBody(long id){
        return repositoryAnnime.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "not found"));
    }

    public Annime save(RequestPostAnnime requestPostAnnime) {

        return repositoryAnnime.save(MaperAnnime.INSTACE.toAnnime(requestPostAnnime));
    }

    public void delete(long id) {
        repositoryAnnime.delete(findByIdOrThrowBadRequestBody(id));
    }

    public void replece(RequestPutAnnime requestPutAnnime) {
        Annime annimeSave = findByIdOrThrowBadRequestBody(requestPutAnnime.getId());
        Annime annime = MaperAnnime.INSTACE.toAnnime(requestPutAnnime);
        annime.setId(annimeSave.getId());
        repositoryAnnime.save(annime);
    }
}
