package ru.lastdrv.leakfacebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lastdrv.leakfacebook.model.FacebookEntity;

@Repository
public interface FacebookRepo extends JpaRepository<FacebookEntity, Integer> {
}
