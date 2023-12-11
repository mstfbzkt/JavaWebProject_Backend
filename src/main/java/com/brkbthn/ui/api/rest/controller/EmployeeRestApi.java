package com.brkbthn.ui.api.rest.controller;

import com.brkbthn.business.dto.EmployeeDto;
import com.brkbthn.business.service.IEmployeeService;
import com.brkbthn.error.ApiResult;
import com.brkbthn.ui.api.rest.IEmployeeApiRest;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Dış dünyaya açılan katman
//lombok
@Log4j2

@RestController
@RequestMapping("employee/api/v1")
@CrossOrigin(origins  = "http:localhost:3000") //izin verir
public class EmployeeRestApi implements IEmployeeApiRest {
    private final static String PATH = "/employee/api/v1/employees";


    // Dependency injection yöntemleri
    //1)
    /*
    @Autowired
    IEmployeeService service;
     */


    //2)
    //Constructor injection, 1 tane field için autowired yazmana gerek yoktur

    IEmployeeService service;
    @Autowired
    public EmployeeRestApi(IEmployeeService service){
        this.service = service;
    }

    //3)
    //Bu yöntemde class üzerinde @RequiredArgsConstructor anotasyonu kullanılması constructor injection yapılması için yeterlidir
    //ancak kesinlikle private final yapısı ile kurulmalıdır
    /*
    private final IEmployeeService service;

     */

    //http:localhost:8090/employee/api/v1
    //http:localhost:8090/employee/api/v1/index
    @Override
    @GetMapping({"/", "/index"})
    public String getRoot() {
        return "index";//index sayfasına yönlendirir
    }
    //SAVE
    //http:localhost:8090/employee/api/v1/employees
    @Override
    @PostMapping("/employees")
    public ResponseEntity<ApiResult> createEmployee(@Valid @RequestBody EmployeeDto employeeDto) {

        service.createEmployee(employeeDto);

        //int Status, String Path, String Message
        ApiResult apiResult = new ApiResult(200, PATH, "CREATED EMPLOYEE");
        //return ResponseEntity.ok(employeeDto);
        return ResponseEntity.ok(apiResult);
    }
    //list
    //http:localhost:8090/employee/api/v1/employees
    @Override
    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        List<EmployeeDto> list = service.getAllEmployees();
        return ResponseEntity.ok(list);
    }
    //Find
    //http:localhost:8090/employee/api/v1/employees/{id}
    @Override
    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable(name="id") Long id) {

        return ResponseEntity.ok(service.getEmployeeById(id));
    }
    //Delete
    //http:localhost:8090/employee/api/v1/employees/{id}
    @Override
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable(name = "id") Long id) {
        service.deleteEmployee(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("silindi", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
    //Update
    @Override
    @PutMapping("/employees/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@Valid @PathVariable(name = "id") Long id, @RequestBody EmployeeDto employeeDto) {
        service.updateEmployee(id, employeeDto);
        return ResponseEntity.ok(employeeDto);
    }
}

