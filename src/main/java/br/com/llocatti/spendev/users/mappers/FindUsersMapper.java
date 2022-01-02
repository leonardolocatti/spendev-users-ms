package br.com.llocatti.spendev.users.mappers;

import br.com.llocatti.spendev.users.dtos.requests.FindUsersRequest;
import br.com.llocatti.spendev.users.dtos.responses.FindUsersResponse;
import br.com.llocatti.spendev.users.dtos.responses.UserResponse;
import br.com.llocatti.spendev.users.entities.User;
import org.modelmapper.ModelMapper;

import java.util.List;

public class FindUsersMapper {

  private static final ModelMapper MAPPER = new ModelMapper();

  private FindUsersMapper() {}

  public static User toModel(FindUsersRequest findUsersRequest) {
    return MAPPER.map(findUsersRequest, User.class);
  }

  public static FindUsersResponse toResponse(List<User> findUsers) {
    return new FindUsersResponse(
        findUsers.stream().map(findUser -> MAPPER.map(findUser, UserResponse.class)).toList());
  }
}
