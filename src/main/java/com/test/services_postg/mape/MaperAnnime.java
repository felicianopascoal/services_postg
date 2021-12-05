package com.test.services_postg.mape;

import com.test.services_postg.domain.Annime;
import com.test.services_postg.requests.RequestPostAnnime;
import com.test.services_postg.requests.RequestPutAnnime;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class MaperAnnime {
    public static final MaperAnnime INSTACE = Mappers.getMapper(MaperAnnime.class);
    public abstract Annime toAnnime(RequestPostAnnime requestPostAnnime);
    public abstract Annime toAnnime(RequestPutAnnime requestPutAnnime);
}
