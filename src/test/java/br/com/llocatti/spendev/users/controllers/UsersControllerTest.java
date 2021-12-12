package br.com.llocatti.spendev.users.controllers;

import br.com.llocatti.spendev.users.dtos.requests.FindUsersRequest;
import br.com.llocatti.spendev.users.dtos.requests.GetUserByIdRequest;
import br.com.llocatti.spendev.users.dtos.responses.FindUsersResponse;
import br.com.llocatti.spendev.users.dtos.responses.GetUserByIdResponse;
import br.com.llocatti.spendev.users.services.FindUsersService;
import br.com.llocatti.spendev.users.services.GetUserByIdService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static br.com.llocatti.spendev.users.mocks.UsersMock.validFindUsersResponse;
import static br.com.llocatti.spendev.users.mocks.UsersMock.validGetUserByIdResponse;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UsersController.class)
class UsersControllerTest {

  static final String USERS_PATH = "/users";

  @Autowired MockMvc mockMvc;

  @MockBean GetUserByIdService getUserByIdService;

  @MockBean FindUsersService findUsersService;

  @Test
  @DisplayName("Should be able to get user by id")
  void shouldBeAbleToGetUserById() throws Exception {
    GetUserByIdResponse getUserByIdResponse = validGetUserByIdResponse();

    when(getUserByIdService.execute(any(GetUserByIdRequest.class))).thenReturn(getUserByIdResponse);

    mockMvc
        .perform(get(USERS_PATH.concat("/1")).accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id", equalTo(getUserByIdResponse.getId().intValue())))
        .andExpect(jsonPath("$.name", equalTo(getUserByIdResponse.getName())))
        .andExpect(jsonPath("$.email", equalTo(getUserByIdResponse.getEmail())))
        .andExpect(
            jsonPath(
                "$.roles[0].id",
                equalTo(getUserByIdResponse.getRoles().iterator().next().getId().intValue())))
        .andExpect(
            jsonPath(
                "$.roles[0].roleName",
                equalTo(getUserByIdResponse.getRoles().iterator().next().getRoleName())));
  }

  @Test
  @DisplayName("Should be able to find users")
  void shouldBeAbleToFindUsers() throws Exception {
    FindUsersResponse findUsersResponse = validFindUsersResponse();

    when(findUsersService.execute(any(FindUsersRequest.class))).thenReturn(findUsersResponse);

    mockMvc
        .perform(get(USERS_PATH).queryParam("email", "email").accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(
            jsonPath("$[0].id", equalTo(findUsersResponse.getUsers().get(0).getId().intValue())))
        .andExpect(jsonPath("$[0].name", equalTo(findUsersResponse.getUsers().get(0).getName())))
        .andExpect(jsonPath("$[0].email", equalTo(findUsersResponse.getUsers().get(0).getEmail())))
        .andExpect(
            jsonPath(
                "$[0].roles[0].id",
                equalTo(
                    findUsersResponse
                        .getUsers()
                        .get(0)
                        .getRoles()
                        .iterator()
                        .next()
                        .getId()
                        .intValue())))
        .andExpect(
            jsonPath(
                "$[0].roles[0].roleName",
                equalTo(
                    findUsersResponse
                        .getUsers()
                        .get(0)
                        .getRoles()
                        .iterator()
                        .next()
                        .getRoleName())));
  }
}
