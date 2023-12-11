package com.brkbthn.business.service;

import com.brkbthn.business.dto.EmployeeDto;
import com.brkbthn.data.entity.EmployeeEntity;

import java.util.List;
import java.util.Map;

public interface IEmployeeService {
    //model mapper:   dto yu entity e  entitiy i de dto ya çeviren yapıdır
    public EmployeeDto entityToDto(EmployeeEntity employeeEntity);
    public EmployeeEntity dtoToEntity(EmployeeDto employeeDto);

    //hiçbir zaman entitiy ler dış ortama açılmaz. Bu veri güvenliği içindir

    //ModelMapper (entity)

    //save
    public EmployeeDto createEmployee(EmployeeDto employeeDto);


    //list
    public List<EmployeeDto> getAllEmployees();

    //Find
    public EmployeeDto getEmployeeById(Long id);


    //update
    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto);


    //delete
    public Map<String, Boolean> deleteEmployee(Long id);
}
