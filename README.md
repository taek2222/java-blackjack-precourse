# 블랙잭 ♠️

## 기능 구현 목록 ⚙️

- 카드 합이 21 또는 21에 가까운 사람이 승리
- 카드 합이 21이 초과된 경우 패배

### ✅ 게임 참여 인원 입력 기능
- [x] 게임 참여 안내 메시지 출력
- [x] 입력 파싱 후 플레이어 리스트 추출
- [x] `예외처리` 이름이 빈칸이거나 공백일 경우 예외가 발생한다

### ✅ 배팅 금액 입력 기능
- [x] 게임 참여 순서에 따라 배팅 금액 메시지 출력
- [x] 입력 파싱 후 플레이어 금액 저장
- [x] `예외처리` 금액이 숫자가 아닌 경우 예외가 발생한다
- [x] `예외처리` 금액이 5,000 미만인 경우 예외가 발생한다
- [x] `예외처리` 금액이 10,000,000 초과일 경우 예외가 발생한다

### ✅ 딜러와 참여 인원 카드 공개 기능
- [x] 딜러 임의의 카드 2장 임의 설정
- [x] 게임 참여 인원 카드 2장 임의 설정 
- [x] 딜러 카드는 1장만 공개
- [x] 참여 순서로 카드 2장 공개
- [x] 두 장의 카드가 블랙잭인 경우 배팅 금액에 1.5배 승리
- [x] 딜러와 플레이어 모두가 블랙잭인 경우 무승부
  - 일반 카드 숫자는 기본
  - [ ] ACE 카드는 1 또는 11 `(11로 계산했을 때, 21 초과인 경우 1로 계산)`
  - King, Queen, Jack은 각각 10

### ✅ 추가 카드 기능
- [x] 참여 순서에 따라 추가 카드 발급
- [x] 플레이어가 21이 넘지 않을 경우 추가 발급 메시지 출력
- [x] 입력 파싱 후 카드 지급 여부 확인
- [x] 지급한 경우 플레이어 카드 현황 출력
- [x] `예외처리` 추가 여부 입력이 올바르지 않은 경우 예외가 발생한다

### ✅ 딜러 추가 카드 여부 기능
- [x] 딜러의 카드가 17 미만인 경우 한 장의 카드 추가 지급
- [x] 추가 발급 후 카드가 21 초과인 경우 플레이어 모두 승리

### ✅ 최종 카드 출력 기능
- [x] 딜러 모든 카드 공개
- [x] 플레이어 모든 카드 공개
- [x] 모든 결과 합산 값 공개

### ✅ 최종 수익 출려 기능
- [x] 플레이어 카드가 21 초과인 경우 패배 판결
- [x] 딜러와 플레이어 카드 비교후 승리, 패배, 무승부 판결
- [x] 승부 판결에 따라 금액 계산
    - 승리 : 2배
    - 패배 : 모두 잃기
    - 무승부 : 무효
- [x] 플레이어 이름과 수익을 출력

### ✅ 실행 결과
```
게임에 참여할 사람의 이름을 입렵하세요.(쉼표 기준으로 분리)
pobi, jason

pobi의 배팅 금액은?
10000

jason의 배팅 금액은?
20000

딜러와 pobi, jason에게 2장을 나누었습니다.
딜러: 3다이아몬드
pobi카드: 2하트, 8스페이드
jason카드: 7클로버, K스페이드

pobi는 한 장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)
y

pobi카드: 2하트, 8스페이드, A클로버

pobi는 한 장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)
n

jason은 한 장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)
n

jason카드: 7클로버, K스페이드

딜러는 16이하라 한 장의 카드를 더 받았습니다.

딜러 카드: 3다이아몬드, 9클로버, 8다이아몬드 - 결과: 20
pobi카드: 2하트, 8스페이드, A클로버 - 결과 21
jason카드: 7클로버, K스페이드 - 결과 17

## 최종 수익
딜러: 10000
pobi: 10000
jason: -20000
```

### ✅ 프로그래밍 요구 사항
- Card, Player, Dealer 클래스를 활용해 구현한다.
- 각 클래스의 기본 생성자를 추가할 수 없다.
- 각 클래스에 필드(인스턴스 변수)를 추가할 수 없다.
- 필드(인스턴스 변수)의 접근 제어자 private을 변경할 수 없다.