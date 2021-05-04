package ru.lastdrv.leakfacebook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.lastdrv.leakfacebook.model.FacebookEntity;
import ru.lastdrv.leakfacebook.repository.FacebookRepo;

@Service
public class FacebookService {
    private final FacebookRepo facebookRepo;

    @Autowired
    public FacebookService(FacebookRepo facebookRepo) {
        this.facebookRepo = facebookRepo;
    }

    @Modifying
    @Transactional
    public void saveAll(Iterable<FacebookEntity> facebookEntities) {
        facebookRepo.saveAll(facebookEntities);
    }
}
