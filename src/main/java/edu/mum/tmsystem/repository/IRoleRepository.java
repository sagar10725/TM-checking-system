package edu.mum.tmsystem.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.tmsystem.domain.Role;
import edu.mum.tmsystem.enums.RoleType;

@Repository
public interface IRoleRepository extends CrudRepository<Role, Integer>{
	
	@Query("SELECT r FROM Role r WHERE r.roleType = :roleType")
	public Role getRoleFromRoleName(@Param("roleType") RoleType roleType);

}
