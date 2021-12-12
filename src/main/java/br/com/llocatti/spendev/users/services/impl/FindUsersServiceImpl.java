package br.com.llocatti.spendev.users.services.impl;

import br.com.llocatti.spendev.users.dtos.requests.FindUsersRequest;
import br.com.llocatti.spendev.users.dtos.responses.FindUsersResponse;
import br.com.llocatti.spendev.users.entities.User;
import br.com.llocatti.spendev.users.mappers.FindUsersMapper;
import br.com.llocatti.spendev.users.repositories.UsersRepository;
import br.com.llocatti.spendev.users.services.FindUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindUsersServiceImpl implements FindUsersService {

  @Autowired private UsersRepository usersRepository;

  @Override
  public FindUsersResponse execute(FindUsersRequest findUsersRequest) {
    Example<User> userExample = Example.of(FindUsersMapper.toModel(findUsersRequest));

    List<User> findUsers = usersRepository.findAll(userExample);

    return FindUsersMapper.toResponse(findUsers);
  }
}
