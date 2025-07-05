![image](https://github.com/user-attachments/assets/f75ff0a6-7fcc-4b97-9043-3c77df98aefb)

문제 출처: https://www.acmicpc.net/problem/1260

---

### Hint

1. 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고
```cpp
for(int i=1; i<=n; i++) {
    sort(adj[i].begin(), adj[i].end());
}
```
간선이 1-3, 1-2로 이뤄져있을때, 1-2, 1-3으로 정렬해야 작은 순으로 탐색을 시작한다.

&nbsp;

2. 입력으로 주어지는 간선은 양방향
   
```cpp
for(int i=0; i<m; i++) {
    cin >> a >> b;
    
    adj[a].push_back(b);
    adj[b].push_back(a);
}
```

---

### 전체 코드

```cpp
#include <bits/stdc++.h>
using namespace std;

int n, m, s, a, b;

vector<int> adj[1001]; // 인접 리스트 (정점 번호: 1 ~ 1000)
bool visited[1001]; // 방문 여부

void dfs(int s) {
    visited[s] = true;
    cout << s << ' ';
    for(int v : adj[s]) {
        if(!visited[v]) dfs(v);
    }
}

void bfs(int s) {
    queue<int> q;
    q.push(s);
    visited[s] = true;
    
    while(!q.empty()) {
        int cur = q.front(); q.pop();
        
        cout << cur << ' ';
        
        for(int v : adj[cur]) {
            if(!visited[v]) {
                q.push(v);
                visited[v] = true;
            }    
        }
        
    }
}

int main() {
    
    cin >> n >> m >> s;
    
    for(int i=0; i<m; i++) {
        cin >> a >> b;
        
        // 양방향
        adj[a].push_back(b);
        adj[b].push_back(a);
    }
    
    for(int i=1; i<=n; i++) {
        sort(adj[i].begin(), adj[i].end()); // 정점 번호가 작은것부터 방문하기 위한 정렬
    }
        
    dfs(s);
    
    fill(visited, visited + 1001, false); // visisted 초기화
    cout << '\n';
    
    bfs(s);
    
}
```

---

### DFS 스택 풀이 

```cpp
void dfs(int v)
{
    stack<int> s;
    s.push(v); // 시작 정점의 번호를 넣는다.
    
    while(!s.empty()) { // 스택이 모두 비워지면 종료
        int cur = s.top(); s.pop();
        
        if(!visited[cur]) { // 현재 정점을 방문하지 않았다면
            visited[cur] = true; // 방문 체크
            cout << cur << ' ';
            
            for(int i=adj[cur].size() - 1; i >= 0; i--) { // 번호가 작은 정점이 먼저 나오게 하기 위해 역순 삽입
                int u = adj[cur][i]; // cur에 인접한 정점 u
                
                if(!visited[u]) s.push(u); // 한 번도 탐색하지 않았다면 스택에 넣어 다음 방문 유도
            }
        }
        
    }
}
```


