package com.rs.admin.service.impl;

import com.google.common.collect.Lists;
import com.rs.admin.commons.entity.Issue;
import com.rs.admin.commons.entity.Project;
import com.rs.admin.persistence.dao.IProjectRepository;
import com.rs.admin.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.Collections.singletonList;

/**
 * Author: Oleh Osyka
 * Date: 5/23/2016
 * Time: 3:30 PM
 */
@Service
public class ProjectService implements IProjectService {

    @Autowired
    private IProjectRepository projectRepository;

    @Override
    public List<Project> getAll() {
        return projectRepository.getAll();
    }

    @Override
    public Project get(Long aLong) {
        return projectRepository.get(aLong);
    }

    @Override
    public void add(Project project) {
        projectRepository.add(project);
    }

    @Override
    public void delete(Project project) {
        projectRepository.delete(project);
    }

    @Override
    public void update(Project project) {
        projectRepository.update(project);
    }

}
