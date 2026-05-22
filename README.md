# Sol Profile API

## LV 0 - AWS Budget 설정
<img width="1575" height="851" alt="AWS Budget Setting" src="https://github.com/user-attachments/assets/b13dfa04-dcb5-4ddf-afd9-2efc8a329c8b" />

## LV 1 - 네트워크 구축 및 배포
- EC2 퍼블릭 IP: 3.36.106.165
- Actuator 헬스체크: http://3.36.106.165:8080/actuator/health
<img width="1575" height="854" alt="health-check png" src="https://github.com/user-attachments/assets/01892cb5-4fb5-44dc-a9ea-43a8697b9a79" />

## LV 2 - DB 분리 및 보안 연결

### Actuator Info 엔드포인트 URL
http://3.36.106.165:8080/actuator/info
<img width="1575" height="851" alt="Actuator Info 엔드포인트" src="https://github.com/user-attachments/assets/93384dc3-acd2-44b4-b90c-c1dc797f8de9" />


### RDS 보안 그룹 인바운드 규칙
<img width="1312" height="381" alt="RDS 보안 그룹" src="https://github.com/user-attachments/assets/3afe8bc8-01ee-4122-9235-9a06ea1524e7" />

## LV 3 - 프로필 사진 기능

### Presigned URL
<img width="1575" height="851" alt="image" src="https://github.com/user-attachments/assets/f7d9e572-7357-4fd4-a535-7acb23d1f83e" />

[Presigned URL 링크](https://sol-my-profile.s3.ap-northeast-2.amazonaws.com/1_Faker_4.jpg?X-Amz-Security-Token=IQoJb3JpZ2luX2VjEE4aDmFwLW5vcnRoZWFzdC0yIkgwRgIhAM3mf%2FhhgI1CyKSI9%2FHGgk3VJtqo%2BBfy69vILR0d5rowAiEAuL%2FzOPnc2PFRr2L1Bl%2FHTrsniqZvc4VWdNYKm5qXMlgqyQUIFxAAGgwwNzEyMzE5MjAzNzAiDN8DkGMNGHTy3TLmDyqmBYsZ8Wa4L9AFFsqNnO2qKO9E5I5pmTLTyujzuzDQie9dGFRlXCpplfGFPnFOfwoTjUHGdhA5fR3KrIxfIUTzDKhWInU60Ae%2FNAnCDACiLBodFu1j%2FIta%2F6RoMi7BVoaqZac20mzw%2BbwOaG8oZiqAlngIy%2BVFADlP1ioTms7rE032oa%2BqwPr%2BYhHSgoIr88LUHntKxCmzFev7DEoVHLsB7meGZrnKzvoYGElE4NovTogBKyAeetG90sPNmuXcRQdktCG9kvqdCJWhtdWbXSI5F5uFjC5JzK3XsXM5gJndfXGGloa2eAd9xXf6IO11K6TQVdnlEZff3JLsDrub3wfnhWZCY%2B72wkhLy4hNHEdQQoNOj5lAjcNH9aGnj%2BbKkMFFtVs2Zv3KeHCoyFwKCG7KjNEZTYyBjg7Y%2Bty9Omes8tSKK2%2B75x1blWKys9mAjI3GIVJLurnX9yv%2FfiRNpj2B8SrOY%2FRu7Rfw8V9kd4XBg1jn5LV97ua4YvkCUpph8J%2FYYyQ%2B7OE0at343XpiJ1TsNnSFJiCgKep3uD%2F1rcSiRwQa3j11GUQN4VWEDfTDliJajuKuPDmG%2F6XClgCIAhAYE542PvOa650dl72JI3ZrqbVVzHfm1yOfRtw71YDe9hM3xp7nLi35puynK%2BNlcCr%2FIEnlHKfMtxqH4L0ZzTLOSWFKU0WW5kzaFOXJ3PMCQs%2FLTpdLWiBLPigvN27lPFsp130wFaiECB9wCvtL9TkqkEpGdwJTrLUMX2cIMvvv%2F0kXYnTkOsC9%2BwtqOc4Sa7YRPdLl%2BwidBFxPbxQr%2FZCe0l4JeCy7Ov5i0i9%2FTvUPFC47QMDW4tSofQR1KcYktQY3%2B5N3Ub%2F4ep8168u6KwRTHGhaE4RAl9L88ScekLkLrbi399Kj2j1YrTDq1b%2FQBjqwAY69I4%2BDbtjQ5iz8sy%2BRUWqlt5TnDUCHQl6eQlWCEb2310wtpL53SvTanD0Z9QfG76%2BO%2Fz1dTr%2Bv9OGY9CvKQB9Cbv2265XyRz7R%2BhYC2m4HTWq4Nzpkltj9HpjnsWJtdivHiCsfAJK%2FLrDx0So9J5QwjlwMI0mcDXJrXaVfgwODMv1I6GBVbZsRWqFYPhmwEWt%2FrDusYVfYLBa0uL8mnPqgQWamCFQlp%2FjS%2FQclkjJQ&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20260522T054513Z&X-Amz-SignedHeaders=host&X-Amz-Credential=ASIARBFOA3DZNIJE7LIO%2F20260522%2Fap-northeast-2%2Fs3%2Faws4_request&X-Amz-Expires=604800&X-Amz-Signature=289b24371db917890bf74b2b14d2ab3e6f416f6fcfe928c0c6507d07c708428c)

### 만료 시간
2026-05-29 (7일 후)
