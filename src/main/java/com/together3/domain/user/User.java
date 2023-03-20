package com.together3.domain.user;

import java.time.LocalDateTime;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.together3.domain.image.Image;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// JPA - Java Persistence API (자바로 데이터를 영구적으로 저장(DB)할 수 있는 API를 제공)

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// JPA - Java Persistence API (자바로 데이터를 영구적으로 저장(DB)할 수 있는 API를 제공)

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data // Getter, Setter
@Entity // DB에 테이블을 생성
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // id는 테이블에 데이터가 들어올 때마다 1,2,3,4 늘어난다. 사용자가 많으면 int로 커버가 안된다(Long을 써야함). 우리는 서비스하는게 아니므로 int로 만든다.

    @Column(length = 20,unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String name;
    private String website; // 웹사이트
    private String bio; // 자기소개
    @Column(nullable = false)
    private String email;
    private String phone;
    private String gender;

    private String profileImageUrl; // 사진
    private String role; // 권한

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("user")
    private List<Image> images;

    private LocalDateTime createDate;

    @PrePersist // DB에 insert 되기 직전에 실행, 나중에 DB에 값을 넣을 때 위에 값만 넣어주면 createDate는 자동으로 들어감.
    public void createDate() {
        this.createDate = LocalDateTime.now();
    }
}