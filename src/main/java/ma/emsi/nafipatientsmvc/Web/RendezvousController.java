package ma.emsi.nafipatientsmvc.Web;


import lombok.AllArgsConstructor;
import ma.emsi.nafipatientsmvc.Entities.Rendezvous;
import ma.emsi.nafipatientsmvc.Repositories.RendezvousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class RendezvousController {

    @Autowired
    RendezvousRepository rendezvousRepository;

    @GetMapping(path = "/rendezvous")
    public String rendezvous(Model model, int page, int size)
    {
        Page<Rendezvous> pageRendezvous = rendezvousRepository.findAll(PageRequest.of(page, size));
        model.addAttribute("pagerdv", pageRendezvous);
        return "rendezvous";
    }
}
