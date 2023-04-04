package com.fundamentosplatzi.springboot.fundamentosPlatzi.repository;

import com.fundamentosplatzi.springboot.fundamentosPlatzi.dto.UserDto;
import com.fundamentosplatzi.springboot.fundamentosPlatzi.entity.User;
import org.hibernate.sql.Select;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("Select u from User WHERE u.email=?1")
    Optional<User> findMyUserByEmail(String email);
    @Query("SELECT u from User u where u.name like ?1%")
    List<User> findAndSort(String name, Sort sort);



    List<User> findByName(String name);

    List<User> findByNameLike(String Name);//Usuario a partir del Nombre
    List<User> findByNameOrEmail(String name , String email);
    @Query("SELECT new com.fundamentosplatzi.springboot.fundamentosPlatzi.dto.UserDto(u.id, u.name, u.email)"
            + "FROM User u"
            + "where u.name=:parametroName"
            + "and u.email=:parametroEmail")

    Optional<UserDto> getAllByNameAndEmail(@Param("parametroFecha") String name,
                                           @Param("parametroEmail") String email);




}
