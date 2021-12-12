package br.com.llocatti.spendev.users.services;

import br.com.llocatti.spendev.users.dtos.requests.FindUsersRequest;
import br.com.llocatti.spendev.users.dtos.responses.FindUsersResponse;

public interface FindUsersService {

  FindUsersResponse execute(FindUsersRequest findUsersRequest);
}
