# spring_root
spirng study history

#### 1.2
###### 리팩토링 _refactoring_
```
기존의 코드를 외부의 동작방식에는 변화 없이 내부 구조를 변경해서 재구성하는 작업 또는 기술
예를 들어, mysql에서 postgre로 변경하였을 때 driver변경 작업을 하려면
소스 1줄을 바꿀 수도 있고 2,000줄을 바꿀 수도 있다.
유지보수 용이하게 작업하기 위한 작업

리팩토링에 관해 책 추천 『리팩토링』(마틴 파울러, 켄트 벡 공저)
```

###### 템플릿 메소드 패턴 _template method pattern_
```
슈퍼클래스에 기본적인 로직의 흐름(connection 가져오기, SQL 생성, 실행, close)을 만들고, 그 기능의 일부를 추상 메소드나 오버라이딩이 가능한 protected 메소드 등으로 만든 뒤 서브클래스에서 이런 메소드를 필요에 맞게 구현해서 사용하도록 하는 방법
```

###### 팩토리 메소드 패턴 _factory method pattern_
```
서브클래스에서 구체적인 오브젝트 생성 방법을 결정하게 하는 것
```
```java
public abstract class factoryDAO {
    public abstract Connection getConnection() throws ClassNotFoundException, SQLException;
}
.
.
.
public class AFactoryDAO extends factoryDAO {
    public Connection getConnection() throws ClassNotFoundException, SQLException {
      // sql 연결 코드
    }
}
```

**java는 클래스의 다중상속을 허용하지 않는다**

test

