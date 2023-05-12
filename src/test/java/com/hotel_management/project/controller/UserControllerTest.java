package com.hotel_management.project.controller;

import com.hotel_management.project.dto.user.UserDTO;
import com.hotel_management.project.dto.user.UserUpdateDTO;
import com.hotel_management.project.entity.user.User;
import com.hotel_management.project.service.BaseTest;
import com.hotel_management.project.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest extends BaseTest {
    @MockBean
    private UserService userService;

    @Test
    public void test_registerUser() throws Exception{
        SecurityContextHolder.getContext().setAuthentication(getAuthentication("ROLE_ADMIN"));
        doReturn(new UserDTO()).when(userService).registerUser(any(),any());
        mvc.perform(MockMvcRequestBuilders.post("/users/admin/ADMIN")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(new UserDTO())))
                .andExpect(status().isOk());
    }

    @Test
    public void test_registerUser_ko() throws Exception{
        SecurityContextHolder.getContext().setAuthentication(getAuthentication("ROLE_CUSTOMER"));
        doReturn(new UserDTO()).when(userService).registerUser(any(),any());
        mvc.perform(MockMvcRequestBuilders.post("/users/admin/ADMIN")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(new UserDTO())))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void test_updateUser_ok() throws Exception{
        SecurityContextHolder.getContext().setAuthentication(getAuthentication("ROLE_ADMIN"));
        doReturn(new UserUpdateDTO()).when(userService).updateUser(any(),any());
        mvc.perform(MockMvcRequestBuilders.put("/users/admin/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(new UserUpdateDTO())))
                .andExpect(status().isOk());
    }

    @Test
    public void test_findUser_ok() throws Exception{
        SecurityContextHolder.getContext().setAuthentication(getAuthentication("ROLE_ADMIN"));
        doReturn(new User()).when(userService).findById(any());
        mvc.perform(MockMvcRequestBuilders.get("/users/admin/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
