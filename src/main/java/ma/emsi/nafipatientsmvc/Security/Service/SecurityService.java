package ma.emsi.nafipatientsmvc.Security.Service;

import ma.emsi.nafipatientsmvc.Security.Entities.AppRole;
import ma.emsi.nafipatientsmvc.Security.Entities.AppUser;


public interface SecurityService  {
    AppUser saveUser(String username, String password,String rePassword);
    AppRole saveNewRole(String roleName,String description);
    void addRoleToUser(String username , String roleName);
    void removeRoleFromUser(String username , String roleName);
    AppUser loadUserByUserName(String username);
}
