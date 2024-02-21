package com.akobir.blogapp.mapper;

import com.akobir.blogapp.dto.LikeDTO;
import com.akobir.blogapp.entity.Like;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LikeMapper {

    LikeMapper INSTANCE = Mappers.getMapper(LikeMapper.class);

    @Mapping(target = "likeId", source = "id")
    LikeDTO likeToLikeDTO(Like like);

    @Mapping(target = "id", source = "likeId")
    Like likeDTOToLike(LikeDTO likeDTO);
}
