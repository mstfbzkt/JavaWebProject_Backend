package com.brkbthn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//Auiditor
@EnableJpaAuditing(auditorAwareRef = "auditorAwareMethod")

@SpringBootApplication(exclude = {
        SecurityAutoConfiguration.class,
}
)
public class JavaFullStackApplication {


    public static void main(String[] args) {
        //devtool active inactive
        System.setProperty("spring.devtools.restart.enabled","true");

        //Disables headless JOptionPane
        System.setProperty("java.awt.headless", "false"); //Disables headless

        SpringApplication.run(JavaFullStackApplication.class, args);

    }




}
