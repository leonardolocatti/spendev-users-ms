package br.com.llocatti.spendev.users.services.impl;

import br.com.llocatti.spendev.users.dtos.requests.GetUserByIdRequest;
import br.com.llocatti.spendev.users.dtos.responses.GetUserByIdResponse;
import br.com.llocatti.spendev.users.entities.User;
import br.com.llocatti.spendev.users.exceptions.ObjectNotFoundException;
import br.com.llocatti.spendev.users.mocks.UsersMock;
import br.com.llocatti.spendev.users.repositories.UsersRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static br.com.llocatti.spendev.users.mocks.UsersMock.validGetUserByIdRequest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class GetUserByIdServiceImplTest {

  @InjectMocks GetUserByIdServiceImpl getUserByIdService;

  @Mock UsersRepository usersRepository;

  @Test
  @DisplayName("Should be able to get user by id")
  void shouldBeAbleToGetUserById() {
    GetUserByIdRequest getUserByIdRequest = validGetUserByIdRequest();
    User findUser = UsersMock.validUser();

    when(usersRepository.findById(getUserByIdRequest.getId())).thenReturn(Optional.of(findUser));

    GetUserByIdResponse getUserByIdResponse = getUserByIdService.execute(getUserByIdRequest);

    assertThat(getUserByIdResponse.getId()).isEqualTo(findUser.getId());
    assertThat(getUserByIdResponse.getName()).isEqualTo(findUser.getName());
    assertThat(getUserByIdResponse.getEmail()).isEqualTo(findUser.getEmail());
    assertThat(getUserByIdResponse.getRoles().iterator().next().getId())
        .isEqualTo(findUser.getRoles().iterator().next().getId());
    assertThat(getUserByIdResponse.getRoles().iterator().next().getRoleName())
        .isEqualTo(findUser.getRoles().iterator().next().getRoleName());
  }

  @Test
  @DisplayName("Should be able to throw an ObjectNotFoundException when user is not found")
  void shouldBeAbleToThrowAndObjectNotFoundExceptionWhenUserIsNotFound() {
    GetUserByIdRequest getUserByIdRequest = validGetUserByIdRequest();

    ObjectNotFoundException exceptionThrown =
        assertThrows(
            ObjectNotFoundException.class, () -> getUserByIdService.execute(getUserByIdRequest));
    assertThat(exceptionThrown.getMessage())
        .isEqualTo("Unable to locate user with id " + getUserByIdRequest.getId());
  }
}
