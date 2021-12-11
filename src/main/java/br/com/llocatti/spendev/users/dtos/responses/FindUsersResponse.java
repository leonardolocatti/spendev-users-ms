package br.com.llocatti.spendev.users.dtos.responses;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class FindUsersResponse implements Serializable {

  private static final long serialVersionUID = 1L;

  @JsonValue private List<User> users;

  @Getter
  @Setter
  public static class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String email;

    private Set<Role> roles;
  }

  @Getter
  @Setter
  private static class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String roleName;
  }
}
