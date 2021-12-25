package br.com.llocatti.spendev.users.controllers;

import br.com.llocatti.spendev.users.dtos.requests.FindUsersRequest;
import br.com.llocatti.spendev.users.dtos.requests.GetUserByIdRequest;
import br.com.llocatti.spendev.users.dtos.responses.FindUsersResponse;
import br.com.llocatti.spendev.users.dtos.responses.GetUserByIdResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Users API", description = "Users operations")
public interface UsersController {

  @Operation(
      description = "Get an user by id",
      parameters = {
        @Parameter(
            description = "User ID",
            in = ParameterIn.PATH,
            name = "id",
            schema = @Schema(implementation = Long.class))
      },
      responses = {
        @ApiResponse(
            description = "User",
            responseCode = "200",
            content =
                @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = GetUserByIdResponse.class))),
        @ApiResponse(
            description = "User not found",
            responseCode = "404",
            content = @Content(mediaType = "application/json"))
      })
  ResponseEntity<GetUserByIdResponse> getUserById(
      @Parameter(hidden = true) GetUserByIdRequest getUserByIdRequest);

  @Operation(
      description = "Find users",
      parameters = {
        @Parameter(
            description = "User email",
            in = ParameterIn.QUERY,
            name = "email",
            schema = @Schema(implementation = Long.class))
      },
      responses = {
        @ApiResponse(
            description = "User",
            responseCode = "200",
            content =
                @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = FindUsersResponse.class))),
        @ApiResponse(
            description = "User not found",
            responseCode = "404",
            content = @Content(mediaType = "application/json"))
      })
  ResponseEntity<FindUsersResponse> findUsers(
      @Parameter(hidden = true) FindUsersRequest findUsersRequest);
}
