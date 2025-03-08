package com.spring.restaurant.mapper;

import com.spring.restaurant.model.clientmodels.Client;
import com.spring.restaurant.service.dto.Jwt.ClientDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
//requestOrders
@Mapper
public interface ClientMapper {
    ClientMapper Client_Mapper = Mappers.getMapper(ClientMapper.class);

    Client toEntity(ClientDto clientDto);
    List<Client> toEntityList( List<ClientDto> clientDtoList);

    @Mapping(target ="roles", ignore = true)
    @Mapping(target ="requestOrders", ignore = true)
    ClientDto toDto(Client client);
    List<ClientDto> toDtoList( List<Client> clientList);

}
