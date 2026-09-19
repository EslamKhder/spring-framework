package com.spring.demo911.mapper;

import com.spring.demo911.controller.vm.PlayerResponseVM;
import com.spring.demo911.dto.PlayerDto;
import com.spring.demo911.model.Player;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlayerMapper {

    @Mapping(source = "ref_num", target = "id")
    Player toEntity(PlayerDto playerDto);

    @Mapping(source = "id", target = "ref_num")
    @Mapping(target = "salary", ignore = true)
    PlayerDto toDto(Player player);

    List<Player> toEntityList(List<PlayerDto> playerDtos);
    List<PlayerDto> toDtoList(List<Player> players);
    PlayerResponseVM toPlayerResponseVM(Player player);
}
