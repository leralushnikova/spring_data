package com.lushnikova.jpa.repository;

import com.lushnikova.jpa.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query(value = "select * from spring.public.people where first_name = :firstName",
            nativeQuery = true)
    List<Person> findByFirstName(@Param("firstName") String firstName);

    List<Person> findByLastNameOrderByFirstNameAsc(String lastname);

    @Modifying
    @Query("update Person p set p.lastName = :newLastName where p.id = :id")
//    @Query(value = "update spring.public.people set last_name = :newLastName where id = :id", nativeQuery = true)
    void updateLastName(@Param("id") Long id,
                       @Param("newLastName") String newLastName);

    Page<Person> findAllBy(Pageable pageable);
}