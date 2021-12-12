package br.com.llocatti.spendev.users.dtos.responses;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class FindUsersResponse implements Serializable {

  private static final long serialVersionUID = 1L;

  @JsonValue private List<UserResponse> users;
}
