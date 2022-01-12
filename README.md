# 기능 구현 목록

- ### user 입력 폼

>- **사용자에게 이름 입력 받기** 👌
>
> >PostMapping을 통해 저장 
>
>- **성별 selection으로 변경 **👌
>
>  > - Enum 으로 성별(Sex) 추가
>

>- **입력받은 정보로 Player 객체 생성 **👌
>
>  > - 생성하기 위해 객체에 인스턴스 변수 (userName, userSex) 추가
>
>- **Repository에 저장** 👌

- ### 게임 실행

  >- 초기 세팅 ✅
  >
  > >카드 더미 생성 및 섞기 ✅
  > >
  > >>프로그램 생성시 카드 덱을 추가하고 섞는 과정이 이루어 지도록 함
  > >>
  > >>List에서 매번 다른 카드를 가져오기 위해 cursor를 추가하여 `drawCard()` 구현
  > >
  > >딜러 생성 ✅
  > >
  > >> `GameReposiotry`에 `Dealer`를 추가
  > >
  > >카드 분배 (딜러 1장, 유저 2장) ✅
  >
  >- 뷰로 진행상황 보여주기
  >
  > > 딜러 카드 1장, 유저 카드 2장 ✅
  > >
  > > 사용자 정보 화면(이름, 성별에 따른 이모지) ✅
  > >
  > > Hit, Stand 버튼 ✅ 👌
  > >
  > > - Hit -> 유저 카드 1장 추가. 
  > >
  > >   Bust 판단 
  > >
  > > - Stand -> 딜러턴 
  >
  >- 딜러 턴
  >
  > >1초마다 게임 진행 및 갱신
  > >
  > >특정 조건에 종료 (3초)

- ### 게임 결과

  >- 승패 여부 판단
  >- 재시작, 초기화면 버튼



- ### 진행중 기획 변경으로 인한 리펙토링

  - 한 플레이어가 여러 게임을 진행하기 위해서는 객체 분리가 필요했고(`BlackJackGame` 추가), 

    이를 Controller에서 관리하기 위해 List가 아닌 Map으로 고유 Id를 부여하여 게임을 관리하도록 바꿈 ✅ 👌

  - 각 Game별 View 페이지를 추가하여 id에 따라 다른 게임이 진행되도록 구현함  ✅ 👌

  - 게임 진행 (Hit, Stand)에 따른 게임의 상태를 저장하기 위한 로직 구현  ✅

  - View에서 조건에 따른 세부사항 (buttun 활성화 여부) 구현  👌









## 비상비상 초비상 (by TaeyoungNoah)

결과화면에서 객체를 전달해서 hit을 해야하는데 그 객체를 어떻게 전달해야할지 감이 안옴

아는 모든걸 다 활용해봤는데 내가 모르는건지 불가능한건지 모르겠음

- 내가 생각했을 때 해결방안
  - 플레이어가 여러명인 상황을 포기
  
  - 플레이어를 Map으로 id 생성해서 저장해야함 그래서 id로 조회하고 진행해야함 (이게 맞는듯) **해결 완료!**
  
    > 여러 플레이어를 다루기 위해 Map으로 게임을 저장하여 해결 완료




## git bracnh 수정