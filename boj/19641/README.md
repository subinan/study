## 문제

SQL은 릴레이션으로 나타낼 수 있는 데이터를 나타내기에는 훌륭한 표현력을 갖고 있지만, 계층적인 구조를 표현하기에는 한계가 있다. 이러한 한계를 보완하고자 나온 모델 중 하나가 중첩 집합 모델이다.

중첩 집합 모델은 구간의 포함관계를 이용해서 계층적인 구조를 나타내는 방식이며, 각각의 데이터는 서로 겹치지 않거나 한 데이터가 다른 데이터를 포함하는 관계를 가진다. 중첩 집합 모델은 트리 구조로 구성된 각 노드의 `left`, `right` 필드에 **트리의 방문 순서**로 번호를 매겨서 `left`, `right` 필드가 구간을 나타내도록 한다. 이 때, 각 노드의 `left` 필드와 `right` 필드는 `left < right`임이 보장된다.

중첩 집합 모델을 구성하는 A 노드와 B 노드가 있을 때, A.left < B.left이고 B.right < A.right이면 **A는 B를 포함한다**고 할 수 있다. A 노드가 포함하는 모든 노드들을 불러올 때는 SQL로는 **`SELECT** * **FROM** tree **WHERE** left > A.left **AND** right < A.right;` 명령을 수행하면 된다.

예를 들면, 한 회사의 조직도를 나타낸다고 가정해 보자. HI-ARC라는 회사에는 여러 개의 부서가 있으며, 각 부서는 여러 개의 팀을 가질 수 있다. 그리고 각 팀은 여러 명의 사원을 포함할 수 있다.

아래와 같이 조직이 구성되어 있다고 생각해 보자.

> 1레벨
> 
> - HI-ARC - (경영지원실, 개발부)
> 
> **2레벨**
> 
> - 경영지원실 - (사업전략팀, 법무팀)
> - 개발부 - (개발1팀, 개발2팀, 운영팀)
> 
> **3레벨**
> 
> - 사업전략팀 - 사원1, 사원2
> - 법무팀 - 사원3
> - 개발1팀 - 사원4, 사원5
> - 개발2팀 - 사원6, 사원7, 사원8
> - 운영팀 - 사원9

그렇다면, 위와 같은 조직 구성을 중첩 집합 모델로 아래와 같이 나타낼 수 있다.

|부서명/이름|left|right|level|
|:---:|:---:|:---:|:---:|
|HI-ARC|1|34|1|
|경영지원실|2|13|2|
|사업전략팀|3|8|3|
|사원1|4|5|4|
|사원2|6|7|4|
|법무팀|9|12|3|
|사원3|10|11|4|
|개발부|14|33|2|
|개발1팀|15|20|3|
|사원4|16|17|4|
|사원5|18|19|4|
|개발2팀|21|28|3|
|사원6|22|23|4|
|사원7|24|25|4|
|사원8|26|27|4|
|운영팀|29|32|3|
|사원9|30|31|4|

사이클이 없는 임의의 그래프가 주어졌을 때, 한 노드를 루트 노드로 하여 구성된 트리를 중첩 집합으로 나타냈을 때 각 노드의 `left` 필드, `right` 필드를 출력한다.

## 입력

첫 번째 줄에는 트리를 구성하는 정점의 개수 *N* (2 ≤ *N* ≤ 105)가 주어진다.

두 번째 줄부터 *N* + 1번째 줄까지는 정점에 연결된 간선에 대한 정보가 주어진다. 각 줄의 처음에는 간선이 연결될 정점의 번호 *Vi* (1 ≤ *Vi* ≤ *N*)가 주어지며, -1을 입력받기 전까지는 해당 노드에서 연결된 모든 노드에 대한 정보가 주어진다.

*N* + 2 번째 줄에는 루트 노드의 역할을 하게 될 정점의 번호 *S*가 주어진다.

이 때, 트리의 구성하는 간선은 단방향 그래프의 간선처럼 입력받지만, 양방향 그래프의 입력임이 보장된다. 2번 노드에서 3번 노드로의 간선을 입력받으면, 3번 노드에 연결된 노드의 정보를 입력받을 때는 3번 노드에서 2번 노드로의 간선이 입력으로 들어온다.

트리를 구성하는 양방향 간선의 정보를 입력받기 때문에, 간선의 개수의 총합은 **2 × (*N* - 1)** 개이며, 모든 정점들은 간선을 통해 서로 직/간접적으로 연결되있다.

## 출력

*S*번 노드가 루트 노드일 때, **번호가 가장 낮은 노드부터 오름차순으로 방문**해서 중첩 집합을 구성했을 때, 각 노드의 번호 `left` 필드와 `right` 필드를 출력한다.

총 *N*개의 줄에 걸쳐 *i*번째 줄에 *i*번 노드의 번호와 `left` / `right` 필드를 출력한다.

이 때, 출력되는 모든 `left` 필드와 `right` 필드는 **1 이상** **2 × *N* 이하**의 서로 다른 자연수이다.

## 예제 입력 1

```
3
2 1 3 -1
3 2 -1
1 2 -1
2
```

## 예제 출력 1

```
1 2 3
2 1 6
3 4 5
```