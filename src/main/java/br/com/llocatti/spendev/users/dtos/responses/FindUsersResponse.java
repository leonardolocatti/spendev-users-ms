package br.com.llocatti.spendev.users.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class FindUsersResponse implements Serializable {

  @Serial private static final long serialVersionUID = 1L;

  private List<UserResponse> users;
}
