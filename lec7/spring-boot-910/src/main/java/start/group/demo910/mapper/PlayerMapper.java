package start.group.demo910.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import start.group.demo910.controller.vm.PlayerVM;
import start.group.demo910.dto.PlayerDto;
import start.group.demo910.model.Player;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlayerMapper {
    // Player  PlayerDto
    @Mapping(source = "number", target = "digits")
    @Mapping(target = "salary", ignore = true)
    PlayerDto toDto(Player player);
    // PlayerDto  Player

    @Mapping(source = "digits", target = "number")
    @Mapping(target = "salary", ignore = true)
    Player toEntity(PlayerDto playerDto);
    // List<Player>  List<PlayerDto>
    List<PlayerDto> toDtoList(List<Player> players);
    // List<PlayerDto>  List<Player>
    List<Player> toEntityList(List<PlayerDto> playersDto);

    PlayerVM toVM(Player player);
}
