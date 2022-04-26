package ma.emsi.nafipatientsmvc.Security.Repositories;

import ma.emsi.nafipatientsmvc.Security.Entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser,String>{
    AppUser findByUsername(String username);
}
