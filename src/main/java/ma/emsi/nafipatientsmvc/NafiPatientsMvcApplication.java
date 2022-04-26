package ma.emsi.nafipatientsmvc;

import ma.emsi.nafipatientsmvc.Entities.Patient;
import ma.emsi.nafipatientsmvc.Entities.Rendezvous;
import ma.emsi.nafipatientsmvc.Repositories.PatientRepository;
import ma.emsi.nafipatientsmvc.Repositories.RendezvousRepository;
import ma.emsi.nafipatientsmvc.Security.Service.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class NafiPatientsMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(NafiPatientsMvcApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository, RendezvousRepository rendezvousRepository){

        return args -> {

           for(int i=1; i<=100; i++)
           {
               patientRepository.save(new Patient(null, "Patient"+i, new Date(),Math.random()<0.5 ? true:false,(int)(Math.random()*1000)));
           }
        };
    }

    //@Bean
    CommandLineRunner saveUsers(SecurityService securityService){
        return args -> {
            securityService.saveUser("Yassine","1234","1234");
            securityService.saveUser("mouad","1234","1234");
            securityService.saveUser("hamza","1234","1234");

            securityService.saveNewRole("USER","");
            securityService.saveNewRole("ADMIN","");

            securityService.addRoleToUser("Yassine","ADMIN");
            securityService.addRoleToUser("mouad","Admin");
            securityService.addRoleToUser("hamza","USER");





        };
    }


}
