package br.com.llocatti.spendev.users.repositories;

import br.com.llocatti.spendev.users.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Long> {}
