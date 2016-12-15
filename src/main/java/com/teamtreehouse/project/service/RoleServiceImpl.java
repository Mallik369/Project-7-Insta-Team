package com.teamtreehouse.project.service;

import com.teamtreehouse.project.dao.RoleDao;
import com.teamtreehouse.project.model.Role;

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