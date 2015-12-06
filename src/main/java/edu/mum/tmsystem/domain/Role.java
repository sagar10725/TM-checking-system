package edu.mum.tmsystem.domain;

import edu.mum.tmsystem.enums.RoleType;

public class Role {
	private Integer id;
	private RoleType roleType;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public RoleType getRoleType() {
		return roleType;
	}

	public void setRoleType(RoleType roleType) {
		this.roleType = roleType;
	}

}
