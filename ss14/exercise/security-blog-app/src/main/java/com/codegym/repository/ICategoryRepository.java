package com.codegym.repository;

import com.codegym.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ICategoryRepository extends JpaRepository<Category, Integer> {

    @Query(value = "select * from category where status_delete = 1", nativeQuery = true)
    List<Category> findAllCategory();

    @Modifying
    @Query(value = "insert into category (name_category, status_delete) values (:name, 1)", nativeQuery = true)
    void save(@Param("name") String name);

    @Query(value = "select * from category where id_category = :id", nativeQuery = true)
    Category findByIdCategory(@Param("id") Integer id);

    @Modifying
    @Query(value = "update category set name_category = :name where id_category = :id", nativeQuery = true)
    void update(@Param("name") String name, @Param("id") Integer id);

    @Modifying
    @Query(value = "update category set status_delete = 0 where id_category = :id", nativeQuery = true)
    void delete(@Param("id") Integer id);

}
