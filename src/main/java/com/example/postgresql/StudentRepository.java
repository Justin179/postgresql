package com.example.postgresql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true) // just read
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT s FROM Student s WHERE s.email = ?1") // ref to @Entity(name = "Student")
    Optional<Student> findStudentByEmail(String email);

    /*
        JPQL is not db specific, but native sql is
        所以能用JPQL就盡量用JPQL
     */

    // JPQL: @Query的優先順位較高 - 可以override掉方法名稱 - always use @Query
    @Query("SELECT s FROM Student s WHERE s.firstName = ?1 AND s.age >= ?2")
    List<Student> findStudentByFirstNameEqualsAndAgeIsGreaterThanEqual(String firstName, Integer age);

    @Query(value = "SELECT * FROM student WHERE first_name = :firstName AND age >= :age", nativeQuery = true)
    List<Student> selectStudentWhereFirstNameAndAgeGreaterOrEqualNative(
            @Param("firstName") String firstName,
            @Param("age") Integer age);

//    @Query("SELECT s FROM Student s WHERE s.firstName = ?1 AND s.age >= ?2")
//    List<Student> selectStudentWhereFirstNameAndAgeGreaterOrEqual(
//            String firstName, Integer age);


    @Transactional //  TransactionRequiredException: Executing an update/delete query
    @Modifying // no mapping to obj needed
    @Query("DELETE FROM Student u WHERE u.id = ?1")
    int deleteStudentById(Long id);
}