package spbpu.auction.model;

import lombok.Data;

@Data
public class User {

    private int id;

    private String email;

    private String password;

    private Role role;

    private String firstName;

    private String secondName;

    private int rating = 0;
}
