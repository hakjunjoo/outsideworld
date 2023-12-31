package com.sparta.outsideworld.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sparta.outsideworld.dto.PostRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@NoArgsConstructor
@Table(name = "posts")
public class Post extends TimeStamped{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column(length = 500)
    private String contents;

    @Column
    private String image;

    @Column(name = "like_count")
    private Long likeCount;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // post를 연관관계의 주인으로 설정. post 엔티티 제거시 연관된 comment 제거.
    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
    private List<Comment> commentList = new ArrayList<>();

    // post를 연관관계의 주인으로 설정. post 엔티티 제거시 연관된 like 제거.
    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
    private List<Like> likeList = new ArrayList<>();

    public Post(PostRequestDto postRequestDto, User user){
        this.user = user;
        this.title = postRequestDto.getTitle();
        this.contents = postRequestDto.getContents();
        this.image = postRequestDto.getImage();
    }

    public void update(PostRequestDto postRequestDto){
        this.title = postRequestDto.getTitle();
        this.contents = postRequestDto.getContents();
        this.image = postRequestDto.getImage();
    }

    public void setLikeCount(Long likeCount) {
        this.likeCount = likeCount;
    }
}
