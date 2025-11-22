package springdemo.finalprojectrestoran.Mapper;

import org.aspectj.apache.bcel.generic.InstructionConstants;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import springdemo.finalprojectrestoran.dto.Jwt.ClientDto;
import springdemo.finalprojectrestoran.dto.Jwt.RoleDto;
import springdemo.finalprojectrestoran.model.ClientModels.Client;
import springdemo.finalprojectrestoran.model.ClientModels.Role;

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
