package com.teamtreehouse.project.dao;

import com.teamtreehouse.project.model.Project;

import java.util.List;

/**
 * Created by Mallikarjuna on 12/23/2016.
 */
public interface ProjectDao {
  List<Project> listAllProjects();
  Project findProjectById(Long id);
  void save(Project project);
  void delete(Project project);
}
