package com.lushnikova.jpa.repository;

import com.lushnikova.jpa.dto.PersonDTO;
import com.lushnikova.jpa.model.entity.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Page<PersonDTO> findAllBy(Pageable pageable);

//    @Query(value = "select * from spring.public.people where first_name = :firstName",
//            nativeQuery = true)
//    List<Person> findByFirstName(@Param("firstName") String firstName);
//
//    List<Person> findByLastNameOrderByFirstNameAsc(String lastname);
//
//
//    //    @Query(value = "update spring.public.people set last_name = :newLastName where id = :id", nativeQuery = true)
//    @Modifying
//    @Query("update Person p set p.lastName = :newLastName where p.id = :id")
//    void updateLastName(@Param("id") Long id,
//                       @Param("newLastName") String newLastName);

//    Page<Person> findAllBy(Pageable pageable);
//    Page<PersonDTO4> findAllBy(Pageable pageable);

//    Slice<Person> findAllBy(Pageable pageable);
//    Slice<PersonDTO3> findAllBy(Pageable pageable);

//    @Query("select new com.lushnikova.jpa.dto.dto2.PersonDTO2(p.id, p.firstName) from Person p where p.age > 50")
//    List<PersonDTO2> findAlls();
}