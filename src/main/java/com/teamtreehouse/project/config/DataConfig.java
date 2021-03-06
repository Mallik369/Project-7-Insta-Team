package com.teamtreehouse.project.config;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;

@Configuration
@PropertySource("app.properties")
public class DataConfig {

  @Autowired
  private Environment env;

  @Bean
  public LocalSessionFactoryBean sessionFactoryBean() {
    Resource config = new ClassPathResource("hibernate.cfg.xml");
    LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
    sessionFactory.setConfigLocation(config);
    sessionFactory.setPackagesToScan(env.getProperty("promanager.entity.package"));
    sessionFactory.setDataSource(dataSource());
    return sessionFactory;
  }

  private DataSource dataSource() {
    BasicDataSource ds = new BasicDataSource();
    ds.setDriverClassName(env.getProperty("promanager.db.driver"));
    ds.setUrl(env.getProperty("promanager.db.url"));
    ds.setUsername(env.getProperty("promanager.db.username"));
    ds.setPassword(env.getProperty(env.getProperty("promanager.db.password")));
    return ds;
  }
}
