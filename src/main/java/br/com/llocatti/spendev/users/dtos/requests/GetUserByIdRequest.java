package br.com.llocatti.spendev.users.dtos.requests;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class GetUserByIdRequest implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;
}
