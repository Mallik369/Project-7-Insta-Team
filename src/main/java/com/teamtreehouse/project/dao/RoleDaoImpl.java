package com.teamtreehouse.project.dao;

import com.teamtreehouse.project.model.Role;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Mallikarjuna on 12/15/2016.
 */
@Repository
public class RoleDaoImpl implements RoleDao {
  @Autowired
  SessionFactory sessionFactory;

  @Override
  @SuppressWarnings("unchecked")
  public List<Role> listAllRoles() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<Role> roles = session.createCriteria(Role.class).list();
    session.close();
    return roles;
  }

  @Override
  public Role findRoleById(Long id) {
    return null;
  }

  @Override
  public Void Save(Role role) {
    return null;
  }

  @Override
  public Void Delete(Role role) {
    return null;
  }
}