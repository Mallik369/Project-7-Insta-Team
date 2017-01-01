package com.teamtreehouse.project.service;

import com.teamtreehouse.project.dao.ProjectDao;
import com.teamtreehouse.project.model.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Mallikarjuna on 12/23/2016.
 */
@Service
public class ProjectServiceImpl implements ProjectService {

  @Autowired
  ProjectDao projectDao;

  @Override
  public List<Project> listAllProjects() {
    return projectDao.listAllProjects();
  }

  @Override
  public Project findProjectById(Long id) {
    return projectDao.findProjectById(id);
  }

  @Override
  public void save(Project project) {
    projectDao.save(project);
  }

  @Override
  public void delete(Project project) {
  }
}
