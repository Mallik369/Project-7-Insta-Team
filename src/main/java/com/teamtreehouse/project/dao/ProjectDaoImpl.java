package com.teamtreehouse.project.dao;

import com.teamtreehouse.project.model.Project;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Mallikarjuna on 12/23/2016.
 */
@Repository
public class ProjectDaoImpl implements ProjectDao {

  @Autowired
  SessionFactory sessionFactory;

  @Override
  @SuppressWarnings("unchecked")
  public List<Project> listAllProjects() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<Project> projectList = session.createCriteria(Project.class).list();
    session.close();
    return projectList;
  }

  @Override
  public Project findProjectById(Long id) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    Project project = session.get(Project.class,id);
    Hibernate.initialize(project.getCollaborators());
    Hibernate.initialize(project.getRolesNeeded());
    session.close();
    return project;
  }

  @Override
  public void save(Project project) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    session.saveOrUpdate(project);
    session.getTransaction().commit();
    session.close();
  }

  @Override
  public void delete(Project project) {
  }
}
