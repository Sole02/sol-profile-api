package com.example.solprofileapi.dto.response;

public class MemberCreateResponseDto {

    private final Long id;
    private final String name;
    private final int age;
    private final String mbti;

    public MemberCreateResponseDto(Long id, String name, int age, String mbti) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.mbti = mbti;
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getMbti() {
        return mbti;
    }
}
