package com.brkbthn.Bean;

import com.brkbthn.business.dto.EmployeeDto;
import com.brkbthn.business.service.Impl.EmployeeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@RequiredArgsConstructor
//Bu proje deployment olduğunda 5 tane veri otomatik olarak eklenir
@Configuration
public class EmployeeSpeedData {
    private final PasswordEncoderBean passwordEncoderBean;

    @Bean
    CommandLineRunner createEmployeeData(EmployeeServiceImpl service){

        return (args -> {
            for (int i = 0; i<5; i++){
                UUID uuid = UUID.randomUUID();
                EmployeeDto employeeDto = EmployeeDto.builder()
                        .email(uuid+".@gmail.com"+1)
                        .pasword(passwordEncoderBean.passwordEncoderMethod().encode("matmuh_yildiz@1911-"+i))
                        .username("brkbthn"+i)
                        .price(i)
                        .build();
                service.createEmployee(employeeDto);
            }
        });
    }
}
