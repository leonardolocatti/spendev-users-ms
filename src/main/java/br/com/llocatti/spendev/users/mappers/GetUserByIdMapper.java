package br.com.llocatti.spendev.users.mappers;

import br.com.llocatti.spendev.users.dtos.responses.GetUserByIdResponse;
import br.com.llocatti.spendev.users.entities.User;
import org.modelmapper.ModelMapper;

public class GetUserByIdMapper {

  private static final ModelMapper MAPPER = new ModelMapper();

  private GetUserByIdMapper() {}

  public static GetUserByIdResponse toResponse(User user) {
    return MAPPER.map(user, GetUserByIdResponse.class);
  }
}
