package br.com.llocatti.spendev.users.services.impl;

import br.com.llocatti.spendev.users.dtos.requests.FindUsersRequest;
import br.com.llocatti.spendev.users.dtos.responses.FindUsersResponse;
import br.com.llocatti.spendev.users.entities.User;
import br.com.llocatti.spendev.users.mappers.FindUsersMapper;
import br.com.llocatti.spendev.users.mocks.UsersMock;
import br.com.llocatti.spendev.users.repositories.UsersRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
class FindUsersServiceImplTest {

  @InjectMocks FindUsersServiceImpl findUsersService;

  @Mock UsersRepository usersRepository;

  @Test
  @DisplayName("Should be able to find users by email")
  void shouldBeAbleToFindUsersByEmail() {
    FindUsersRequest findUsersRequest = UsersMock.validFindUsersRequest();
    Example<User> userExample = Example.of(FindUsersMapper.toModel(findUsersRequest));
    User findUser = UsersMock.validUser();

    Mockito.when(usersRepository.findAll(userExample))
        .thenReturn(Collections.singletonList(findUser));

    FindUsersResponse findUsersResponse = findUsersService.execute(findUsersRequest);

    assertThat(findUsersResponse.getUsers().get(0).getId()).isEqualTo(findUser.getId());
    assertThat(findUsersResponse.getUsers().get(0).getName()).isEqualTo(findUser.getName());
    assertThat(findUsersResponse.getUsers().get(0).getEmail()).isEqualTo(findUser.getEmail());
    assertThat(findUsersResponse.getUsers().get(0).getRoles().iterator().next().getId())
        .isEqualTo(findUser.getRoles().iterator().next().getId());
    assertThat(findUsersResponse.getUsers().get(0).getRoles().iterator().next().getRoleName())
        .isEqualTo(findUser.getRoles().iterator().next().getRoleName());
  }
}
