package br.com.dentalofficemanager.user.repository.impl;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.dentalofficemanager.user.model.Role;
import br.com.dentalofficemanager.user.repository.UserNamedQueries;
import br.com.dentalofficemanager.user.repository.RoleRepository;

@Repository
public class RoleRepositoryImpl implements RoleRepository, UserNamedQueries {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Role> findAllRoles() {
		TypedQuery<Role> query = em.createNamedQuery(NAMEDQ_ROLE_FIND_ALL, Role.class);
		return query.getResultList();
	}

	@Override
	public List<Role> findRolesByIds(Set<Long> ids) {
		TypedQuery<Role> query = em.createNamedQuery(NAMEDQ_ROLE_FIND_ALL_BY_IDS, Role.class);
		query.setParameter(PARAM_ROLE_FIND_ALL_BY_IDS, ids);
		return query.getResultList();
	}

	@Override
	public Role findRole(String role) {
		return null;
	}


}
