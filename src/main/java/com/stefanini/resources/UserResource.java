package com.stefanini.resources;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import com.stefanini.dto.UserDTO;
import com.stefanini.service.UserService;

@Path("/user")
public class UserResource {
  @Inject
  UserService userService;

  @POST
  public Response createUser(UserDTO user) {
    return Response.status(Response.Status.CREATED).entity(userService.createUser(user)).build();
  }

  @PUT
  public Response editUser(UserDTO user) {
    return Response.status(Response.Status.OK).entity(userService.editUser(user)).build();
  }

  @DELETE
  @Path("/{id}")
  public Response removeUser(@PathParam("id") Long id) {
    userService.removeUser(id);
    return Response.status(Response.Status.ACCEPTED).build();
  }

  @GET
  public Response getAllUsers() {
    return Response.status(Response.Status.OK).entity(userService.listAllUsers()).build();
  }

  @GET
  @Path("/aniversariantes")
  public Response getBirthdayMonthUsers() {
    return Response.status(Response.Status.OK).entity(userService.listMonthBirthday()).build();
  }

  @GET
  @Path("/email/{email}")
  public Response getProvedorEmail(@PathParam("email") String email) {
    return Response.status(Response.Status.OK).entity(userService.listProvedorEmail(email)).build();
  }
}
