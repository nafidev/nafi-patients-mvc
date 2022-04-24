package ma.emsi.nafipatientsmvc.Web;


import lombok.AllArgsConstructor;
import ma.emsi.nafipatientsmvc.Entities.Patient;
import ma.emsi.nafipatientsmvc.Repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;


    @RequestMapping(path="/")
    public String showDefaultPage()
    {
        return "home";
    }

    @RequestMapping(path="/home")
    public String showHomePage()
    {
        return "home";
    }

    @GetMapping(path = "/index")
    public String Patients(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
                           @RequestParam(name = "size", defaultValue = "5") int size,
                           @RequestParam(name = "keyword", defaultValue = "") String keyword
                           )
    {
        Page<Patient> pagePatients = patientRepository.findPatientByNomContains(keyword, PageRequest.of(page, size));
        model.addAttribute("listPatients", pagePatients.getContent());
        model.addAttribute("pages", new int[pagePatients.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);
        return "patients";
    }

    @GetMapping("/delete")
    public String delete(Long id,String keyword,int page)
    {
        patientRepository.deleteById(id);
        return "redirect:/index?page="+page+"&keyword="+keyword;
    }

    @GetMapping(path = "/formPatient")
    public String formPatient(Model model){
        model.addAttribute("patient", new Patient());
        return "formPatient";
    }

    @PostMapping(path = "/save")
    public String save(Model model, @Valid Patient patient, BindingResult bindingResult){

        if (bindingResult.hasErrors())
            return "formPatient";
        patientRepository.save(patient);
        model.addAttribute("newPatient", patient);
        return "validerPatient";
    }

    @GetMapping("/patients")
    @ResponseBody
    public List<Patient> listPatients(){
        return patientRepository.findAll();
    }


    @PutMapping(path = "/editPatient")
    public String editPatient(Model model, Long id){
        Patient patient = patientRepository.findById(id).orElse(null);
        if(patient==null) throw new RuntimeException("Patient introuvable");
        model.addAttribute("patient", patient);
        return "editPatient";
    }
}
