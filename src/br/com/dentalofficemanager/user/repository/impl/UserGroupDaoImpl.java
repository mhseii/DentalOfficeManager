package br.com.dentalofficemanager.user.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.dentalofficemanager.user.model.UserGroup;
import br.com.dentalofficemanager.user.repository.UserGroupDao;

@Repository
public class UserGroupDaoImpl implements UserGroupDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<UserGroup> findAllUserGroups() {
		return em.createQuery("select ug from UserGroup ug", UserGroup.class).getResultList();
	}

	@Override
	public UserGroup findUserGroupByGroupCode(long groupCode) {
		TypedQuery<UserGroup> query = em.createQuery("select ug from UserGroup ug where groupCode = :groupCode", UserGroup.class);
		query.setParameter("groupCode", groupCode);
		return query.getSingleResult();
	}

}
