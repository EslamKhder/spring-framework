package com.spring.boot.mapper;

import com.spring.boot.dto.EmployeeDto;
import com.spring.boot.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    EmployeeMapper EMPLOYEE_MAPPER = Mappers.getMapper(EmployeeMapper.class);

    Employee toEmployee(EmployeeDto employeeDto);

    @Mapping(source = "roles" , target = "roleDtos")
    EmployeeDto toEmployeeDto(Employee employee);

    List<Employee> toEmployeeList(List<EmployeeDto> employeeDtos);
    List<EmployeeDto> toEmployeeDtoList(List<Employee> employees);
}
