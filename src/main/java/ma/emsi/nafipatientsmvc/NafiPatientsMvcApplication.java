package ma.emsi.nafipatientsmvc;

import ma.emsi.nafipatientsmvc.Entities.Patient;
import ma.emsi.nafipatientsmvc.Repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class NafiPatientsMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(NafiPatientsMvcApplication.class, args);
    }

    //@Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){

        return args -> {

           for(int i=1; i<=100; i++)
           {
               patientRepository.save(new Patient(null, "Patient"+i, new Date(),Math.random()<0.5 ? true:false,(int)(Math.random()*1000)));
           }
        };
    }

}
