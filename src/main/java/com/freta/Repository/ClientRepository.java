package com.freta.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freta.Entity.ClientEntity;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long>{
}
