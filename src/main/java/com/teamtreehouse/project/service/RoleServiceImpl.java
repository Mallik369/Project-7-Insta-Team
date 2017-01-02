package com.teamtreehouse.project.service;

import com.teamtreehouse.project.dao.RoleDao;
import com.teamtreehouse.project.model.Role;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Mallikarjuna on 12/15/2016.
 */
@Service
public class RoleServiceImpl implements RoleService {

  @Autowired
  RoleDao roleDao;

  @Override
  public List<Role> listAllRoles() {
    return roleDao.listAllRoles();
  }

  @Override
  public Role findRoleById(Long id) {
    return roleDao.findRoleById(id);
  }

  @Override
  public void save(Role role) {
    roleDao.save(role);
  }

  @Override
  public void delete(Role role) {}

  @Override
  public Role findByName(String name) {
    return roleDao.findByName(name);
  }
}
