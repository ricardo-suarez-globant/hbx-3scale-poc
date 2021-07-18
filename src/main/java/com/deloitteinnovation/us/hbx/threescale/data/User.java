package com.deloitteinnovation.us.hbx.threescale.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    public enum Role {USER, ADMIN, USER_MANAGER}

    private Long id;

    private String email;

    @JsonIgnore
    @ToString.Exclude
    private String password;

    private Role role;
}