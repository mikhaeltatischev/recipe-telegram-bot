package org.sionnach.bot.repository;

import org.sionnach.bot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByChatId(Long chatId);
}