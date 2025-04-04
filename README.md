1.1 일정 API

![image](https://github.com/user-attachments/assets/44435798-f9e7-49f5-a866-a05756291917)

1.2 유저 API

![image](https://github.com/user-attachments/assets/61d33536-6e6b-4dc4-8a4d-ca440ac3bfcf)



2. ERD

![Blank diagram (3)](https://github.com/user-attachments/assets/dc6518c2-441e-4ece-a2bf-3cc93aad9e8e)



4. 기능 설명
  3.1 일정 생성: User 클래스와 연결하여 Request 받은 유저의 아이디를 확인하여 존재하는 ID일 때 일정 생성 가능
  3.2 회원가입: Email에 unique = true를 사용하여 이메일 확인 후 회원가입 가능
  3.3 유저 수정: 유저명을 변경할 수 있도록 비밀번호가 일치하면 새로운 유저명으로 변경
  3.4 유저 삭제: 타인의 정보를 삭제할 수 없도록 비밀번호 확인, 일치하면 해당 유저가 등록한 일정, 유저를 일괄 삭제
