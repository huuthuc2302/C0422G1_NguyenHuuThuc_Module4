package com.codegym.repository;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface IBlogRepository extends JpaRepository<Blog, Integer> {

    @Query(value = "select * from blog where status_delete = 1", nativeQuery = true)
    Page<Blog> findAllBlog(Pageable pageable);

    @Modifying
    @Query(value = "insert into blog (name_blog, author, description, date_create, status_delete, category) values (:nameBlog, :author, :description, :dateCreate, 1, :category)", nativeQuery = true)
    void save(@Param("nameBlog") String nameBlog, @Param("author") String author, @Param("description") String description, @Param("dateCreate") String dateCreate, @Param("category") Integer category);

    @Query(value = "select * from blog where id_blog = :id", nativeQuery = true)
    Blog findByIdBlog(@Param("id") Integer id);

    @Modifying
    @Query(value = "update blog set name_blog = :name, author = :author, description = :description, date_create = :date, category = :category where id_blog = :id", nativeQuery = true)
    void update(@Param("name") String name, @Param("author") String author, @Param("description") String description, @Param("date") String date, @Param("id") Integer id, @Param("category") Integer category);

    @Modifying
    @Query(value = "update blog set status_delete = 0 where id_blog = :id", nativeQuery = true)
    void delete(@Param("id") Integer id);

    @Query(value = "select * from blog where name_blog like :name", nativeQuery = true)
    Page<Blog> findAllBlogByName(Pageable pageable, @Param("name") String name);

    @Query(value = "select * from blog where name_blog like :txt", nativeQuery = true)
    List<Blog> findByNameBlogContaining(@Param("txt") String txt);

}
