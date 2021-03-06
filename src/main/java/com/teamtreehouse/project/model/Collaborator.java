package com.teamtreehouse.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by Mallikarjuna on 12/8/2016.
 */
@Entity
public class Collaborator {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  @ManyToOne
  private Role role;

  public Collaborator() {}

  public Collaborator(String name) {
    this.name = name;
  }

  public Long getId() {return id;}

  public void setId(Long id) {this.id = id;}

  public String getName() {return name;}

  public void setName(String name) {this.name = name;}

  public Role getRole() {return role;}

  public void setRole(Role role) {this.role = role;}
}
