package org.sionnach.bot.service;

import org.sionnach.bot.model.ClassifiedUpdate;
import org.sionnach.bot.model.User;

import java.util.List;

public interface UserService {

    User findUserByUpdate(ClassifiedUpdate classifiedUpdate);

    User createUser(ClassifiedUpdate classifiedUpdate, List<String> params, User user);

}