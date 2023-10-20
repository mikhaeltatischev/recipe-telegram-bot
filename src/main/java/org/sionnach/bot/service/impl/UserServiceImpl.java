package org.sionnach.bot.service.impl;

import lombok.RequiredArgsConstructor;
import org.sionnach.bot.model.ClassifiedUpdate;
import org.sionnach.bot.model.State;
import org.sionnach.bot.model.User;
import org.sionnach.bot.repository.StateRepository;
import org.sionnach.bot.repository.UserRepository;
import org.sionnach.bot.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final StateRepository stateRepository;
    private final UserRepository userRepository;

    @Override
    public User findUserByUpdate(ClassifiedUpdate classifiedUpdate) {

        if (userRepository.findByChatId(classifiedUpdate.getUserId()) != null) {
            User user = userRepository.findByChatId(classifiedUpdate.getUserId());

            if (user.getName() == null && classifiedUpdate.getUserName() != null)
                user.setName(classifiedUpdate.getUserName());

            if (user.getName() != null)
                if (!user.getName().equals(classifiedUpdate.getUserName()))
                    user.setName(classifiedUpdate.getUserName());

            if (!user.getName().equals(classifiedUpdate.getName()))
                user.setName(classifiedUpdate.getName());

            return user;
        }

        try {
            User user = new User();
            user.setName(classifiedUpdate.getName());
            user.setPermissions(0L);
            user.setChatId(classifiedUpdate.getUserId());

            State state = new State();
            state.setStateValue(null);
            state.setUser(user);

            stateRepository.save(state);

            user.setState(state);
            userRepository.save(user);

            return user;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public User createUser(ClassifiedUpdate classifiedUpdate, List<String> params, User user) {
        user.setFirstName(params.get(0));
        user.setLastName(params.get(1));
        user.setPhone(params.get(2));

        userRepository.save(user);

        return user;
    }

}