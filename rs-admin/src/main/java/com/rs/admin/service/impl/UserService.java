package com.rs.admin.service.impl;

import com.rs.admin.commons.entity.User;
import com.rs.admin.persistence.dao.IUserRepository;
import com.rs.admin.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * Author: Oleh Osyka
 * Date: 5/25/2016
 * Time: 3:28 PM
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public void addAll(Collection<User> users) {
        users.forEach(this::add);
    }

    @Override
    public List<User> getAll() {
        return userRepository.getAll();
    }

    @Override
    public User get(String string) {
        return userRepository.get(string);
    }

    @Override
    public void add(User user) {
        userRepository.add(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public void update(User user) {
        userRepository.update(user);
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> getParticipantsByEmail(List<String> email) {
        return userRepository.findByEmailIn(email);
    }

    @Override
    public User getUserByEmailAndFetchProjects(String email) {
        return userRepository.findByEmailAndFetchProjectsEagerly(email);
    }
}
