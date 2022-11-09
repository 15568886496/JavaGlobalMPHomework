package com.example.kevin.sbhw.dao;
 
import com.example.kevin.sbhw.entity.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
 
import java.io.Serializable;
import org.springframework.data.jpa.repository.Query;

public interface UserDao extends JpaRepository<User,Integer>, Serializable {

  @Query(value = "select * from t_user where user_name = ?1", nativeQuery = true)
  User getUserInfoByName(String name);

}