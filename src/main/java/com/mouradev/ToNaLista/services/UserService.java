package com.mouradev.ToNaLista.services;

import org.springframework.stereotype.Service;
import com.mouradev.ToNaLista.models.User;
import com.mouradev.ToNaLista.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public List<User> findByCompanyId(Integer companyId) {
        return userRepository.findAllByCompanyId(companyId);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
