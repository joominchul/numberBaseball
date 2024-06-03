# 앱 설명
- 숫자 야구.
- 1~9까지의 3자리 숫자를 입력해 3자리 중복되지 않은 랜덤 숫자를 맞추는 게임.
- 랜덤 숫자와 같은 자리를 맞추면 스트라이크, 다른 자리에 숫자가 있다면 볼, 입력한 3자리 숫자들이 랜덤 숫자들과 완전히 다르면 아웃.
- 최대 시도 횟수는 9번. 9번을 초과하면 게임 종료.

# 기능 요구사항
- 1~9까지의 중복되지 않는 3자리 숫자를 입력후 확인 버튼을 누르면 미리 만들어진 랜덤 숫자와 비교.
  - 숫자를 입력하지 않거나, 3자리 숫자가 아닌 경우 토스트 메시지를 출력하고 실제 비교하지 않음.
- 비교 후 그 결과 값을 보여줌.
- 결과 값 기록들을 보여줌.
- 랜덤 숫자를 맞추면 게임 종료 토스트 메시지를 출력하고 값 기록들을 삭제, 최소 시도 횟수 갱신.
- 최대 시도 횟수를 초과하면 초과 토스트 메시지를 출력하고, 결과 값으로 초과를 출력. 값 기록들 삭제.

# 화면 설명
## 초기 화면
<img src="https://github.com/joominchul/numberBaseball/blob/master/%EC%8B%A4%ED%96%89%20%ED%99%94%EB%A9%B4/%EC%B5%9C%EC%B4%88%20%ED%99%94%EB%A9%B4.png?raw=true"/>
숫자 입력칸과 확인 버튼, 입력한 숫자에 대한 결과 값을 보여주는 칸, 랜덤 숫자를 맞춘 최소 시도 횟수를 보여주는 칸, 예측 기록들을 보여주는 칸으로 구성.

## 아무것도 입력하지 않고 확인 버튼 클릭 시
<img src="https://github.com/joominchul/numberBaseball/blob/master/%EC%8B%A4%ED%96%89%20%ED%99%94%EB%A9%B4/%EC%9E%85%EB%A0%A5%20%EC%98%A4%EB%A5%98.png?raw=true"/>

## 3자리 숫자를 입력하지 않고 확인 버튼 클릭 시
<img src="https://github.com/joominchul/numberBaseball/blob/master/%EC%8B%A4%ED%96%89%20%ED%99%94%EB%A9%B4/3%EC%9E%90%EB%A6%AC%20%EC%88%AB%EC%9E%90%20%EC%9E%85%EB%A0%A5%20%EC%98%A4%EB%A5%98.png?raw=true"/>

## 숫자 입력 후 확인 버튼 클릭 시
<img src="https://github.com/joominchul/numberBaseball/blob/master/%EC%8B%A4%ED%96%89%20%ED%99%94%EB%A9%B4/%EC%88%AB%EC%9E%90%20%ED%99%95%EC%9D%B8%20%ED%81%B4%EB%A6%AD%20%EC%8B%9C.png?raw=true"/>
결과 값 기록 창은 스크롤뷰로 설정

## 최대 횟수 초과 시
<img src="https://github.com/joominchul/numberBaseball/blob/master/%EC%8B%A4%ED%96%89%20%ED%99%94%EB%A9%B4/%EC%B5%9C%EB%8C%80%20%ED%9A%9F%EC%88%98%20%EC%B4%88%EA%B3%BC%EC%8B%9C.png?raw=true"/>

## 게임 성공 시
<img src="https://github.com/joominchul/numberBaseball/blob/master/%EC%8B%A4%ED%96%89%20%ED%99%94%EB%A9%B4/%EA%B2%8C%EC%9E%84%20%EC%84%B1%EA%B3%B5%EC%8B%9C.png?raw=true"/>
