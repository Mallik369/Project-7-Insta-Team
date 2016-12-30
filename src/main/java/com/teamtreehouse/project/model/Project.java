package com.teamtreehouse.project.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * Created by Mallikarjuna on 12/8/2016.
 */
@Entity
public class Project {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String description;
  private Status status;
  @ManyToMany
  private List<Role> rolesNeeded = new ArrayList<>();
  @ManyToMany
  private List<Collaborator> collaborators = new ArrayList<>();

  public Project() {}

  public Long getId() {return id;}

  public void setId(Long id) {this.id = id;}

  public String getName() {return name;}

  public void setName(String name) {this.name = name;}

  public String getDescription() {return description;}

  public void setDescription(String description) {this.description = description;}

  public List<Role> getRolesNeeded() {return rolesNeeded;}

  public void setRolesNeeded(List<Role> rolesNeeded) {this.rolesNeeded = rolesNeeded;}

  public List<Collaborator> getCollaborators() {return collaborators;}

  public void setCollaborators(List<Collaborator> collaborators) {
    this.collaborators = collaborators;
  }

  public void setStatus(Status status) {this.status = status;}

  public Status getStatus() {return status;}

  public enum Status {
    Active, Archived, NotStarted
  }

}
