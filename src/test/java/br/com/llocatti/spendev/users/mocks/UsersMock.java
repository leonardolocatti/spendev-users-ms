package br.com.llocatti.spendev.users.mocks;

import br.com.llocatti.spendev.users.dtos.requests.FindUsersRequest;
import br.com.llocatti.spendev.users.dtos.requests.GetUserByIdRequest;
import br.com.llocatti.spendev.users.dtos.responses.FindUsersResponse;
import br.com.llocatti.spendev.users.dtos.responses.GetUserByIdResponse;
import br.com.llocatti.spendev.users.entities.Role;
import br.com.llocatti.spendev.users.entities.User;

import java.util.Collections;

public class UsersMock {

  private static final Long USER_ID = 1L;
  private static final String USER_NAME = "Jane Doe";
  private static final String USER_EMAIL = "janedoe@email.com";
  private static final String USER_PASSWORD = "password";
  private static final Long ROLE_ID = 1L;
  private static final String ROLE_NAME = "ROLE_ADMIN";

  private UsersMock() {}

  public static User validUser() {
    User user =
        new User()
            .setId(USER_ID)
            .setName(USER_NAME)
            .setEmail(USER_EMAIL)
            .setPassword(USER_PASSWORD);
    user.getRoles().add(new Role().setId(ROLE_ID).setRoleName(ROLE_NAME));

    return user;
  }

  public static GetUserByIdRequest validGetUserByIdRequest() {
    return new GetUserByIdRequest().setId(USER_ID);
  }

  public static GetUserByIdResponse validGetUserByIdResponse() {
    return new GetUserByIdResponse()
        .setId(USER_ID)
        .setName(USER_NAME)
        .setEmail(USER_EMAIL)
        .setRoles(
            Collections.singleton(
                new GetUserByIdResponse.Role().setId(ROLE_ID).setRoleName(ROLE_NAME)));
  }

  public static FindUsersRequest validFindUsersRequest() {
    return new FindUsersRequest().setEmail(USER_EMAIL);
  }

  public static FindUsersResponse validFindUsersResponse() {
    return new FindUsersResponse(
        Collections.singletonList(
            new FindUsersResponse.User()
                .setId(USER_ID)
                .setName(USER_NAME)
                .setEmail(USER_EMAIL)
                .setRoles(
                    Collections.singleton(
                        new FindUsersResponse.Role().setId(ROLE_ID).setRoleName(ROLE_NAME)))));
  }
}
