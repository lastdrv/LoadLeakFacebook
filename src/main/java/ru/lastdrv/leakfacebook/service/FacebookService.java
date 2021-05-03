package ru.lastdrv.leakfacebook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lastdrv.leakfacebook.model.FacebookEntity;
import ru.lastdrv.leakfacebook.repository.FacebookRepo;

import java.util.List;

@Service
public class FacebookService {
    private final FacebookRepo facebookRepo;

    @Autowired
    public FacebookService(FacebookRepo facebookRepo) {
        this.facebookRepo = facebookRepo;
    }

    public List<FacebookEntity> getLimitedFacebook(int limit) {
        return facebookRepo.getFacebook(limit);
    }
}
