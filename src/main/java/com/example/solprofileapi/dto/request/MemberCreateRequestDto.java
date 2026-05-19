package com.example.solprofileapi.dto.request;

public class MemberCreateRequestDto {

    private String name;
    private int age;
    private String mbti;

    public MemberCreateRequestDto(String name, int age, String mbti) {
        this.name = name;
        this.age = age;
        this.mbti = mbti;
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
