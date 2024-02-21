package com.akobir.blogapp.mapper;

import com.akobir.blogapp.dto.SubscribeDTO;
import com.akobir.blogapp.entity.Subscribe;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SubscribeMapper {

    SubscribeMapper INSTANCE = Mappers.getMapper(SubscribeMapper.class);

    @Mapping(target = "subscribeId", source = "id")
    SubscribeDTO subscribeToSubscribeDTO(Subscribe subscribe);

    @Mapping(target = "id", source = "subscribeId")
    Subscribe subscribeDTOToSubscribe(SubscribeDTO subscribeDTO);
}
