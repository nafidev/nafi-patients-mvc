package ma.emsi.nafipatientsmvc.Repositories;

import ma.emsi.nafipatientsmvc.Entities.Rendezvous;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezvousRepository extends JpaRepository<Rendezvous, Long> {


}
