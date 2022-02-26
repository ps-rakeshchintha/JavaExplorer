package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    List<Client> findAllByActive(Boolean active);

    Client findById(long id);

    @Query(nativeQuery = true, value = "select id, name from public.client order by id")
    List<ClientIdAndName> getIdAndName();
}
