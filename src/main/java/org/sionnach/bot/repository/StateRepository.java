package org.sionnach.bot.repository;

import org.sionnach.bot.model.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {

}