package com.hcr.swd392g3.project.repository;

import com.hcr.swd392g3.project.entity.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TableRepository extends JpaRepository<Table, Integer> {

    Table findOneByTableID(int tableID);

    List<Table> findAll();

    // cau lẹnh SQL
//	@Query("SELECT c FROM Student c WHERE c.firstName LIKE %:firstName% OR c.lastName LIKE %:firstName%")
//	List<Table> findByFirstNameContaining(@Param("firstName") String firstName);


}
