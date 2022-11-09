package com.example.kevin.sbhw.dao;

import com.example.kevin.sbhw.entity.Menu;

import com.example.kevin.sbhw.entity.User;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @Author 三更  B站： https://space.bilibili.com/663528522
 */
public interface MenuDao  extends JpaRepository<Menu,Integer>, Serializable {
    @Query(value = "SELECT \n"
        + "\tDISTINCT r.`name`\n"
        + "FROM\n"
        + "\tsys_user_role ur\n"
        + "\tLEFT JOIN `sys_role` r ON ur.`role_id` = r.`id`\n"
        + "WHERE\n"
        + "\tuser_id = ?1\n"
        + "\tAND r.`status` = 0\n"
        + "\n", nativeQuery = true)
    List<String> selectPermsByUserId(Long id);

    @Query(value = "SELECT \n"
        + "\tDISTINCT r.`name`\n"
        + "FROM\n"
        + "\t`sys_role` r\n",
        nativeQuery = true)
    List<String> selectAdminRole();
}
