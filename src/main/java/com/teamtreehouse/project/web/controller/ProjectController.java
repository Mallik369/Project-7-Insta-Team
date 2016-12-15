package com.teamtreehouse.project.web.controller;

import com.teamtreehouse.project.model.Project;
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
public class ProjectController {

  @RequestMapping("/")
  public String listAllProjects(Model model){
    //TODO : MASK : Get all Projects
    List<Project> projectList = new ArrayList<>();
    model.addAttribute("projects",projectList);
    return "project/index";
  }

  //Single Project Page
  @RequestMapping("/project/{projectId}")
  public String project(@PathVariable Long projectId, Model model) {
    // TODO: MASK : Get the Project by its Id
    Project project = null;

    model.addAttribute("project",project);
    return "project/project_detail";
  }

  // Form to Create a New Project
  @RequestMapping("/newproject")
  public String formNewProject(Model model) {
    // TODO : MASK : Add Model Attributes to New Form

    return "project/edit_project";
  }

  // Form to Edit a Project
  @RequestMapping("/project/{projectId}/edit")
  public String formEditProject(Model model) {
    // TODO : MASK : Add Model Attributes to Edit Form

    return "project/edit_project";
  }

  // Add Project
  @RequestMapping(value = "/project/add", method = RequestMethod.POST)
  public String addProject() {
    // TODO : MASK : Add project if it is Valid

    // TODO : MASK : Return to /Project/{projectId}
    return null;
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
