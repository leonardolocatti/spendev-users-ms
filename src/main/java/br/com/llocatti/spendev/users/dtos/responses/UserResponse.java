package br.com.llocatti.spendev.users.dtos.responses;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
public class UserResponse implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;

  private String name;

  private String email;

  private Set<Role> roles;

  @Getter
  @Setter
  public static class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String roleName;
  }
}
