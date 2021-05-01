package ru.lastdrv.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lastdrv.model.Facebook;
import ru.lastdrv.service.FacebookService;

import java.util.List;

@Service
public class FacebookImpl implements FacebookService {
    private final FacebookRepo facebookRepo;

    @Autowired
    public FacebookImpl(FacebookRepo facebookRepo) {
        this.facebookRepo = facebookRepo;
    }

    @Override
    public List<Facebook> getTenFacebook(int limit) {
        return facebookRepo.getFacebook(limit);
    }
}
