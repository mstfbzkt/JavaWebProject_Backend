package com.brkbthn.ui.api.rest;

import com.brkbthn.business.dto.EmployeeDto;
import com.brkbthn.error.ApiResult;
import org.springframework.http.ResponseEntity;

import javax.xml.stream.events.EntityReference;
import java.util.List;
import java.util.Map;

public interface IEmployeeApiRest {

    //Speed data
    public String getRoot();

    //save
    public ResponseEntity<ApiResult> createEmployee(EmployeeDto employeeDto);

    //list
    public ResponseEntity<List<EmployeeDto>> getAllEmployees();

    //find
    public ResponseEntity<EmployeeDto> getEmployeeById(Long id);

    //delete
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(Long id);

    //update
    public ResponseEntity<EmployeeDto> updateEmployee(Long id, EmployeeDto employeeDto);
}
