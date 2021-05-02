package ru.lastdrv.leakfacebook.service;

import ru.lastdrv.leakfacebook.model.FacebookEntity;

import java.util.List;

public interface FacebookService {
    List<FacebookEntity> getLimitedFacebook(int limit);
}
