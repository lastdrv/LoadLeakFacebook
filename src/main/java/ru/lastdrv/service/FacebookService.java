package ru.lastdrv.service;

import ru.lastdrv.model.Facebook;

import java.util.List;

public interface FacebookService {
    List<Facebook> getTenFacebook(int limit);
}
