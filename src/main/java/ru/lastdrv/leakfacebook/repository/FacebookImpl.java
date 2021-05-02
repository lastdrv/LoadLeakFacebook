package ru.lastdrv.leakfacebook.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lastdrv.leakfacebook.model.FacebookEntity;
import ru.lastdrv.leakfacebook.service.FacebookService;

import java.util.List;

@Service
public class FacebookImpl implements FacebookService {
    private final FacebookRepo facebookRepo;

    @Autowired
    public FacebookImpl(FacebookRepo facebookRepo) {
        this.facebookRepo = facebookRepo;
    }

    @Override
    public List<FacebookEntity> getLimitedFacebook(int limit) {
        return facebookRepo.getFacebook(limit);
    }
}
