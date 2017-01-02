package com.teamtreehouse.project.service;

import com.teamtreehouse.project.model.Role;

import java.util.List;

/**
 * Created by Mallikarjuna on 12/15/2016.
 */
public interface RoleService {
  List<Role> listAllRoles();   // To provide all Roles to Controller
  Role findRoleById(Long id);  // To provide a single Role to Controller based on its id
  void save(Role role);        // To Save a Role provided by Controller
  void delete(Role role);      // To Delete a Role provided by Controller
  Role findByName(String name);
}
