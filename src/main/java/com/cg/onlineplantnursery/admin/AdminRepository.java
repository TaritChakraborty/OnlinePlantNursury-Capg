package com.cg.onlineplantnursery.admin;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{
	Admin findByAdminUsername(String adminUsername);	
	Optional<Admin> findByAdminUsernameAndAdminpassword(String adminUsername, String adminpassword);	

}
