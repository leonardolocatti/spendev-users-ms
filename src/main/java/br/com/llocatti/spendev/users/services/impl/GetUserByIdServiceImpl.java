package br.com.llocatti.spendev.users.services.impl;

import br.com.llocatti.spendev.users.dtos.requests.GetUserByIdRequest;
import br.com.llocatti.spendev.users.dtos.responses.GetUserByIdResponse;
import br.com.llocatti.spendev.users.entities.User;
import br.com.llocatti.spendev.users.exceptions.ObjectNotFoundException;
import br.com.llocatti.spendev.users.mappers.GetUserByIdMapper;
import br.com.llocatti.spendev.users.repositories.UsersRepository;
import br.com.llocatti.spendev.users.services.GetUserByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetUserByIdServiceImpl implements GetUserByIdService {

  @Autowired private UsersRepository usersRepository;

  @Override
  public GetUserByIdResponse execute(GetUserByIdRequest getUserByIdRequest) {
    Optional<User> findUser = usersRepository.findById(getUserByIdRequest.getId());

    return findUser
        .map(GetUserByIdMapper::toResponse)
        .orElseThrow(
            () ->
                new ObjectNotFoundException(
                    "Unable to locate user with id " + getUserByIdRequest.getId()));
  }
}
