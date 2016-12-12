package com.teamtreehouse.project.web.controller;

import com.teamtreehouse.project.model.Role;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mallikarjuna on 12/8/2016.
 */
@Controller
public class RoleController {

  //Index all the List of Roles Created in Database
  @RequestMapping("/roles")
  public String listRoles(Model model) {
    // TODO : MASK : Get All Roles
    List<Role> roleList = new ArrayList<>();

    model.addAttribute("roles",roleList);
    return "role/roles";
  }

  // Add Role
  @RequestMapping(value = "/roles",method = RequestMethod.POST)
  public String addRoles() {
    // TODO: MASK : Add Roles if Valid Data is Received

    // TODO: MASK : Return Redirect /roles
    return null;
  }

  //Form to Edit Role
  @RequestMapping(value = "/roles/{roleId}/edit")
  public String editRoles(@PathVariable Long roleId , Model model){
    // TODO : MASK : Add Model Attributes Needed to Edit Form

    return "role/roles";
  }

  // Update Role
  @RequestMapping(value = "/roles/{roleId}",method = RequestMethod.POST)
  public String updateRoles (@PathVariable Long roleId) {
    // TODO: MASK : Update Roles if Valid Data is Received

    // TODO : MASK : Return Browser to /roles
    return null;
  }

  // Delete Role
  @RequestMapping(value = "roles/{roleId}/delete" , method = RequestMethod.POST)
  public String deleteRoles(@PathVariable Long roleId) {
    // TODO : MASK : Delete Role if Role is not associated with Project or Collaborators

    // TODO : MASK : Return Browser to /roles
    return null;
  }
}
