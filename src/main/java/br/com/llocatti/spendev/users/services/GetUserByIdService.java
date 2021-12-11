package br.com.llocatti.spendev.users.services;

import br.com.llocatti.spendev.users.dtos.requests.GetUserByIdRequest;
import br.com.llocatti.spendev.users.dtos.responses.GetUserByIdResponse;

public interface GetUserByIdService {

  GetUserByIdResponse execute(GetUserByIdRequest getUserByIdRequest);
}
