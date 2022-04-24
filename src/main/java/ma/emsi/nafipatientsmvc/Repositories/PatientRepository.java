package ma.emsi.nafipatientsmvc.Repositories;

import ma.emsi.nafipatientsmvc.Entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository <Patient, Long> {

    //test
    public List<Patient> findPatientByMaladeIsTrue();
    public List<Patient> findPatientByMaladeIsFalse();
    public List<Patient> findPatientByScoreIsLessThan(int score);

    public Page<Patient> findPatientByNomContains(String kw, Pageable pageable);

}
