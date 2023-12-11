package com.brkbthn.business.service.Impl;

import com.brkbthn.Bean.ModelMapperBean;
import com.brkbthn.Bean.PasswordEncoderBean;
import com.brkbthn.business.dto.EmployeeDto;
import com.brkbthn.business.service.IEmployeeService;
import com.brkbthn.data.entity.EmployeeEntity;
import com.brkbthn.data.repository.IEmployeeRepository;
import com.brkbthn.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//Lombok
@RequiredArgsConstructor //zorunlu olan constructorları arka planda oluşturur DI için..
@Log4j2
//asıl işi yapan katmandır
@Service
@Transactional

public class EmployeeServiceImpl implements IEmployeeService {

    private final IEmployeeRepository repository;
    private final ModelMapperBean modelMapper;
    private final PasswordEncoderBean passwordEncoderBean;


    //Model Mapper (dto)
    @Override
    public EmployeeDto entityToDto(EmployeeEntity employeeEntity) {
        EmployeeDto employeeDto = modelMapper.modelMapperMethod().map(employeeEntity, EmployeeDto.class);
        return employeeDto;
    }
    //ModelMapper (entity)
    @Override
    public EmployeeEntity dtoToEntity(EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = modelMapper.modelMapperMethod().map(employeeDto, EmployeeEntity.class);
        return employeeEntity;
    }



    //Create
    //database e kayıt işlemi yapılabilmesi için @RequestBody anotasyonu mutlaka parametre kısmında metoda eklenmelidir
    @Override
    @PostMapping("/save/employee")
    public EmployeeDto createEmployee(@RequestBody EmployeeDto employeeDto) {
        if(employeeDto!=null) {
            //Spring Security maskeleme yapmak
            employeeDto.setPasword(passwordEncoderBean.passwordEncoderMethod().encode(employeeDto.getPasword()));
            EmployeeEntity employeeEntity = dtoToEntity(employeeDto);
            repository.save(employeeEntity);
        }
        return employeeDto;
    }



    //List
    @Override
    @GetMapping("/list/employee")
    public List<EmployeeDto> getAllEmployees() {
        //entity List (FindAll)
        Iterable<EmployeeEntity> employeeEntityList = repository.findAll();

        //dto list
        List<EmployeeDto> list = new ArrayList<>();

        for (EmployeeEntity temp : employeeEntityList){
            EmployeeDto dto = entityToDto(temp);
            list.add(dto);
        }

        return list; //dtolist olarak da isimlendirilebilirdi
    }





    //find
    @Override
    @GetMapping("/find/employee/{id}")
    public EmployeeDto getEmployeeById(@PathVariable(name = "id") Long id) {

        EmployeeEntity employeeEntity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id + " id değeri bulunamadı."));//id den bulamıyprsa istisna fırlatır.
        EmployeeDto employeeDto = entityToDto(employeeEntity);
        return employeeDto;
    }




    //update
    @Override
    @PutMapping("/update/employee/{id}")
    public EmployeeDto updateEmployee(@PathVariable(name = "id") Long id, @RequestBody EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id + "id bulunamadı."));

        if (employeeDto != null){
            employeeEntity.setUsername(employeeDto.getUsername());
            employeeEntity.setEmail(employeeDto.getEmail());
            employeeEntity.setPasword(employeeDto.getPasword());
            employeeEntity.setPrice(employeeDto.getPrice());
            repository.save(employeeEntity);
        }

        return employeeDto;
    }




    //delete
    @Override
    @DeleteMapping("/delete/employee/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(name = "id") Long id) {
        EmployeeEntity employeeEntity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id + " id bulunamadi."));

        //object delete
        repository.delete(employeeEntity);
        Map<String, Boolean> response = new HashMap<>();
        response.put("silindi", Boolean.TRUE);
        return response;
    }
}
