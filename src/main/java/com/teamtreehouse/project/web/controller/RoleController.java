package com.teamtreehouse.project.web.controller;

import com.teamtreehouse.project.model.Role;
import com.teamtreehouse.project.service.RoleService;
import com.teamtreehouse.project.web.FlashMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;

/**
 * Created by Mallikarjuna on 12/8/2016.
 */
@Controller
public class RoleController {

  @Autowired
  RoleService roleService;

  //Index all the List of Roles Created in Database
  @RequestMapping("/roles")
  public String listRoles(Model model) {
    // TODO : MASK : Get All Roles
    List<Role> roleList = roleService.listAllRoles();
    model.addAttribute("roles",roleList);  // List existing roles from Database
    if(!model.containsAttribute("role")) {
      model.addAttribute("role",new Role()); // Object Binding for New Role
    }
    return "role/roles";
  }

  // Add Role
  @RequestMapping(value = "/roles",method = RequestMethod.POST)
  public String addRoles(@Valid Role role, BindingResult result , RedirectAttributes redirectAttributes) {
    // TODO: MASK : Add Roles if Valid Data is Received

    if(result.hasErrors()) {

      // Include Validation Error Messages
      redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.role",result);
      // Include the Entered Data upon Receiving Invalid Role Data
      redirectAttributes.addFlashAttribute("role",role);
      // Redirect Roles Page on receiving Invalid Role Data
      return "redirect:/roles";
    }
    // Duplicate Roles are not Allowed to add to Database
    if (roleService.listAllRoles().stream().anyMatch(rolee -> rolee.getName().equals(role.getName()))) {
      FlashMessage message =
          new FlashMessage(String.format("'%s Role is available in database", role.getName()),
              FlashMessage.Status.FAILURE);
      redirectAttributes.addFlashAttribute("flash", message);
      return "redirect:/roles";
    }
    roleService.save(role);
    // Include Flash Message for Role Name to add Database
    redirectAttributes.addFlashAttribute("flash",new FlashMessage("Role is added Successfully",
        FlashMessage.Status.SUCCESS));
    // TODO: MASK : Return Redirect /roles
    return "redirect:/roles";
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
