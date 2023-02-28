package com.gabinet.gabinet.visit;

import com.gabinet.gabinet.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Long> {
    @Query("SELECT s FROM Visit s WHERE s.clientId = ?1")
    List<Visit> findByClientId(Long id);
}
