package br.com.llocatti.spendev.users.controllers;

import br.com.llocatti.spendev.users.dtos.requests.FindUsersRequest;
import br.com.llocatti.spendev.users.dtos.requests.GetUserByIdRequest;
import br.com.llocatti.spendev.users.dtos.responses.FindUsersResponse;
import br.com.llocatti.spendev.users.dtos.responses.GetUserByIdResponse;
import br.com.llocatti.spendev.users.services.FindUsersService;
import br.com.llocatti.spendev.users.services.GetUserByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersController {

  @Autowired private GetUserByIdService getUserByIdService;

  @Autowired private FindUsersService findUsersService;

  @GetMapping("/{id}")
  public ResponseEntity<GetUserByIdResponse> getUserById(GetUserByIdRequest getUserByIdRequest) {
    return ResponseEntity.ok(getUserByIdService.execute(getUserByIdRequest));
  }

  @GetMapping
  public ResponseEntity<FindUsersResponse> findUsers(FindUsersRequest findUsersRequest) {
    return ResponseEntity.ok(findUsersService.execute(findUsersRequest));
  }
}
