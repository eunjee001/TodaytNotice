# 📌오늘의 공지
## 🛠️주요 기능
- ServerSocket으로 간단 Socket 서버 구현
- Socket 통신으로 client 에서 데이터 송신받기
- OkHttp를 통해 데이터 가져오기
- GSON을 통해 JSON형식 데이터 가져오기

### OKHTTP ?
효율적으로 Http 통신을 할 수 있도록 도와주는 라이브러리  
안드로이드 내부의 URL 클래스의 http 처리도 OkHttp를 이용해서 구현이 되어있음

### Socket ?
네트워크 상에서 데이터를 통신 할 수 있도록 연결 해주는 End-point  
연결 요청, 연결수락, Connection, close 상태를 거침  
실시간 데이터 통신, 양방향 데이터 통

### HTTP / HTTPS ?
Hyper Text Transfer Protocol(Secure)  

HTML 문서를 주고 받기 위한 통신규약  
단방향 통신, 클라이언트의 요청, 서버의 응답, 응답이후는 연결을 끊음
   
[요청시]  
Request Line / Header / Body의 구성을 가짐
- Request Line : 메서드 (GET / POST), 버전, URL등의 정보
- Header : 기본 구조에 정의된 대로 서버에 전달하는 정보
- Body : 요청에 들어가는 Data, 단순 데이터 요청 시에는 사용하지 않음
  
[응답시]  
Status Line / Header / Body 의 구성을 가짐
- Status Line : 상태 코드 (200 / 404), 버전 등의 정보
- Headr : 기본 구조에 정의된 대로 서버에 전달하는 정보
- Body : 실 데이터