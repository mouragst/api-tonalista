package com.mouradev.ToNaLista.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mouradev.ToNaLista.models.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    List<User> findAllByCompanyId(Integer companyId);
    
}
