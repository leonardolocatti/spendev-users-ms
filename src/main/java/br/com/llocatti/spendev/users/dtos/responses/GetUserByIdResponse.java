package br.com.llocatti.spendev.users.dtos.responses;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class GetUserByIdResponse implements Serializable {

  @Serial private static final long serialVersionUID = 1L;

  @JsonUnwrapped private UserResponse user;
}
