package com.teamtreehouse.project.model;

import org.hibernate.validator.constraints.NotEmpty;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Mallikarjuna on 12/8/2016.
 */
@Entity
public class Project {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @Size(min = 3 , max = 30 ,message = "{project.name.size}")
  private String name;

  @NotEmpty(message = "{project.description.notempty}")
  @Size(max = 250)
  private String description;

  private Status status;

  @NotNull(message = "{project.rolesNeeded.notnull}")
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
    Active, Archived, Pending
  }

}
