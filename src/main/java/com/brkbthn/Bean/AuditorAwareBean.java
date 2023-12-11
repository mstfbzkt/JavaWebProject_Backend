package com.brkbthn.Bean;

import com.brkbthn.audit.AuditorAwareImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

@Configuration
public class AuditorAwareBean {
    //Sisstem üzerinde yapılan işlerle alakalı bilgiler verir
    // Dikkat, @SpringBootApplicationda AuditorAwareBean class ismi verilmelidir, @EnableJpaAuditing(auditorAwareRef = "auiditorAwareBean")

    @Bean
    public AuditorAware auditorAwareMethod(){

        return new AuditorAwareImpl() ;
    }
}
