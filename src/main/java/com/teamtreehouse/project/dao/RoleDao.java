package com.teamtreehouse.project.dao;

import com.teamtreehouse.project.model.Role;

import java.util.List;

/**
 * Created by Mallikarjuna on 12/15/2016.
 */
public interface RoleDao {
  List<Role> listAllRoles();   // To Read All the Roles Added to Database
  Role findRoleById(Long id);  // To Read Single Role by its Id in Database
  void save(Role role);        // To Add a Single Role to Database
  void delete(Role role);      // To Delete Single Role from Database
  Role findByName(String name);
}
