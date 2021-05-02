package ru.lastdrv.leakfacebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.lastdrv.leakfacebook.model.Facebook;

import java.util.List;

@Repository
public interface FacebookRepo extends JpaRepository<Facebook, Integer> {

    @Query(value = "select * from Facebook limit :limit", nativeQuery = true)
    List<Facebook> getFacebook(@Param("limit") int limit);
}
