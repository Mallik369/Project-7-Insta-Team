package com.teamtreehouse.project.web.controller;

import com.teamtreehouse.project.model.Project;
import com.teamtreehouse.project.model.Role;
import com.teamtreehouse.project.service.ProjectService;
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
import java.util.stream.Collectors;
import javax.validation.Valid;

/**
 * Created by Mallikarjuna on 12/8/2016.
 */
@Controller
public class ProjectController {

  @Autowired
  ProjectService projectService;

  @Autowired
  RoleService roleService;

  @RequestMapping("/")
  public String listAllProjects(Model model){
    //TODO : MASK : Get all Projects
    List<Project> projectList = projectService.listAllProjects();
    model.addAttribute("projects",projectList);
    return "project/index";
  }

  //Single Project Page
  @RequestMapping("/project/{projectId}")
  public String project(@PathVariable Long projectId, Model model) {
    // TODO: MASK : Get the Project by its Id
    Project project = projectService.findProjectById(projectId);
    model.addAttribute("project",project);
    model.addAttribute("collaborators",project.getCollaborators());
    return "project/project_detail";
  }

  // Form to Create a New Project
  @RequestMapping("/newproject")
  public String formNewProject(Model model) {
    // TODO : MASK : Add Model Attributes to New Form
    if(!model.containsAttribute("project")) {
      model.addAttribute("project",new Project());
    }
    model.addAttribute("roles",roleService.listAllRoles());
    return "project/edit_project";
  }

  // Form to Edit a Project
  @RequestMapping("/project/{projectId}/edit")
  public String formEditProject(Model model) {
    // TODO : MASK : Add Model Attributes to Edit Form
    return "project/edit_project";
  }

  // Add Project
  @RequestMapping(value = "/projects", method = RequestMethod.POST)
  public String addProject(@Valid Project project , BindingResult result, RedirectAttributes redirectAttributes) {
    // TODO : MASK : Add project if it is Valid
    if(result.hasErrors()) {
      redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.project",result);
      redirectAttributes.addFlashAttribute("project",project);
      return "redirect:/newproject";
    }
    List<Role> roles = new ArrayList<>();
    roles.addAll(project.getRolesNeeded().stream().filter(role -> role.getName() != null)
          .map(role -> roleService.findByName(role.getName())).collect(Collectors.toList()));
      project.setRolesNeeded(roles);
    projectService.save(project);
    // Include Flash Message for Project Name to add Database
    redirectAttributes.addFlashAttribute("flash",new FlashMessage("Project is added Successfully",
        FlashMessage.Status.SUCCESS));
    // TODO : MASK : Return to /Project/{projectId}
    return String.format("redirect:/project/%s",project.getId());
  }

  // Update Project
  @RequestMapping(value = "/project/{projectId}",method = RequestMethod.POST)
  public String updateProject(@PathVariable Long projectId) {
    // TODO : MASK : Add Project if it is Valid

    // TODO : MASK : Return to /Project/{projectId}
    return null;
  }

  // Delete Project
  @RequestMapping(value = "project/{projectId}/delete",method = RequestMethod.POST)
  public String deleteProject() {
    // TODO : MASK : Delete Project
    // TODO : MASK : Delete Collaborators associated with Project
    // TODO : MASK : Make Sure to Unlink Roles associated with Collaborators and Project to Maintain Data Integrity

    // TODO : MASK : Return to  / - index page
    return null;
  }
}
