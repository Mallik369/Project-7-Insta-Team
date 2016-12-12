package com.teamtreehouse.project.web.controller;

import com.teamtreehouse.project.model.Collaborator;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mallikarjuna on 12/8/2016.
 */
public class CollaboratorController {

  // List all Collaborators
  @RequestMapping("/collaborators")
  public String listAllCollaborators(Model model) {
    // TODO : MASK :  Add Model Attributes to List Collaborators

    List<Collaborator> collaboratorList = new ArrayList<>();
    model.addAttribute("collaborators",collaboratorList);
    return "collaborator/collaborators";
  }

  // Form to Add New Collaborators
  @RequestMapping("/project/{projectId}/collaborators")
  public String FormNewCollaborator(@PathVariable Long projectId , Model model) {
    // TODO : MASK : Add Model Attributes to List Project Details,Collaborators Details

    // TODO : MASK : Return Project Collaborators Page
    return "project/project_collaborators";
  }

  // Form to Edit Collaborators
  @RequestMapping("/project/{projectId}/collaborators/{collaboratorId}")
  public String FormEditCollaborator(@PathVariable Long projectId, @PathVariable Long collaboratorId, Model model) {
    // TODO : MASK : Add Model Attributes to Edit Collaborators and Project Details

    // TODO : MASK : Return to Project Collaborators Page
    return "project/project_collaborators";
  }

  // Add Collaborators
  @RequestMapping(value ="/project/{projectId}/collaborators" ,method = RequestMethod.POST)
  public String addCollaborator(@PathVariable Long projectId) {
    // TODO : MASK : Add Collaborator if it is Valid

    // TODO : MASK : Redirect to project Collaborators : /project/{projectId}/collaborators
    return null;
  }

  // Update Collaborator
  @RequestMapping(value = "project/{projectId}/collaborators/{collaboratorId}", method = RequestMethod.POST)
  public String updateCollaborator(@PathVariable Long projectId , @PathVariable Long collaboratorId, Model model) {
    // TODO : MASK : Update Collaborator if it is Valid

    // TODO : MASK : Redirect to Project Collaborators Edit Page : /project/{projectId}/collaborators/{collaboratorId}
    return null;
  }

  // Delete Collaborator
  @RequestMapping(value = "project/{projectId}/collaborators/{collaboratorId}/delete", method = RequestMethod.POST)
  public String deleteCollaborator(@PathVariable Long projectId , @PathVariable Long collaboratorId ,Model model) {
    // TODO : MASK : UnAssign Roles Assgined to Collaborator

    // TODO : MASK : Delete Collaborator

    // TODO : MASK : Redirect to project Collaborators Page : /project/{projectId}/collaborators
    return null;
  }
}

