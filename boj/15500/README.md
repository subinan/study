## 문제

승민이는 [기존 하노이 탑 문제](https://www.acmicpc.net/problem/11729)를 약간 변형한 이상한 하노이 탑 문제를 만들었다.

이상한 하노이 탑 문제와 기존 하노이 탑 문제와 다른 점이 2가지가 있는데 하나는 "쌓아 놓은 원판은 항상 위의 것이 아래의 것보다 작아야 한다.(중간 과정 역시 그래야함)" 라는 조건이 삭제되었다는 점이고 또 다른 하나는 첫 번째 장대에 원판들이 반경 상관없이 무작위로 배치되어 있다는 점이다.

승민이는 이 문제를 진수에게 주었고 원판을 옮긴 횟수가 12345보다 같거나 작으면 피자를 사주기로 하였다. 진수를 도와 피자를 먹게 해주자!

## 입력

첫 번째 줄에는 원판의 개수 N (1 ≤ N ≤ 123) 이 주어진다.

두 번째 줄에는 첫 번째 장대에 있는 원판들의 반경 나타내는 정수 ai (1 ≤ ai ≤ N) 들이 공백을 두고 주어진다. (제일 아래에 있는 원판의 반경부터 주어진다.)

## 출력

첫 번째 줄에 원판을 옮긴 횟수 K (0 ≤ K ≤ 12345) 를 출력한다.

다음 K 개 줄에 걸쳐 A B (1 ≤ A, B ≤ 3) 를 출력하는데 A 번째 장대 맨위에 있는 원판 하나를 B 번째 장대 맨위로 옮긴다는 뜻이다.

## 예제 입력 1

```
3
2 3 1
```

## 예제 출력 1

```
4
1 2
1 3
1 3
2 3
```

## 힌트

아래는 예제를 푸는 과정을 나타낸다.

![https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/15500/example.png](https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/15500/example.png)