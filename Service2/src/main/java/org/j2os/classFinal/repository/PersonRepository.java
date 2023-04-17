package org.j2os.classFinal.repository;

import org.j2os.classFinal.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findByName(String name);

//    List<Person> findById(Long id);

    List<Person> findByNameOrIdOrderByName(String name,Long id);
    List<Person> findByIdAndNameOrderById(Long id,String name);
    void deleteByName(String name);

    @Query("select o from person o where o.id=:id")
    List<Person> execute(@Param("id") Long id);
}
