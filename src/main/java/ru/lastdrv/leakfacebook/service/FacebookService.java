package ru.lastdrv.leakfacebook.service;

import ru.lastdrv.leakfacebook.model.Facebook;

import java.util.List;

public interface FacebookService {
    List<Facebook> getTenFacebook(int limit);
}
