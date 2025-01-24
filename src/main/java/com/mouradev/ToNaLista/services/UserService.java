package com.mouradev.ToNaLista.services;

import org.springframework.stereotype.Service;
import com.mouradev.ToNaLista.models.User;
import com.mouradev.ToNaLista.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public List<User> findByCompanyId(Integer companyId) {
        return userRepository.findAllByCompanyId(companyId);
    }

    public User editUser(Long id, User user) {
        Optional<User> optionalOldUser = userRepository.findById(id);
    
        if (optionalOldUser.isPresent()) {
            User oldUser = optionalOldUser.get();
            oldUser.setName(user.getName());
            oldUser.setEmail(user.getEmail());
            oldUser.setPassword(user.getPassword());
            oldUser.setCompany(user.getCompany());
            oldUser.setPermission(user.getPermission());
            oldUser.setStatus(user.getStatus());
            oldUser.setCreatedAt(user.getCreatedAt());
            return userRepository.save(oldUser);
        } else {
            return null;
        }
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
