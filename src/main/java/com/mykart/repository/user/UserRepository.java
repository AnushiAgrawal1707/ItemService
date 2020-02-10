package com.mykart.repository.user;

import com.mykart.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {

    public User findById(int userId);

}
