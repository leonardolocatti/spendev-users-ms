package br.com.llocatti.spendev.users.dtos.responses;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
public class GetUserByIdResponse implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;

  private String name;

  private String email;

  private Set<Role> roles;

  @Getter
  @Setter
  private static class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String roleName;
  }
}
