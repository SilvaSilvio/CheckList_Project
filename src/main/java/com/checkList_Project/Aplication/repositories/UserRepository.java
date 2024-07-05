package com.checkList_Project.Aplication.repositories;

import com.checkList_Project.Aplication.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//    User findByUsername(String username);

}
