package com.moviemang.datastore.domain.maria;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @SequenceGenerator(name = "user_id_seq",sequenceName="user_id_seq", allocationSize=1)
    private Long id;
    private String email;
    private String userName;
    private String password;
}
