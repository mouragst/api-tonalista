package com.mouradev.ToNaLista.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mouradev.ToNaLista.models.Location;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    
    List<Location> findAllByCategoryId(Integer categoryId);
    List<Location> findAllByCompanyId(Integer companyId);
    
}
