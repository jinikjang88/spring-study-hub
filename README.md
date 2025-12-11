# 🎓 Spring Study Hub

Spring MVC의 기초부터 실무까지 단계별로 학습하는 멀티 모듈 프로젝트

## 📋 프로젝트 개요

Spring Study Hub는 Spring Framework의 핵심 기능들을 체계적으로 학습하기 위한 교육용 프로젝트입니다.
각 모듈은 특정 주제에 집중하여 독립적으로 학습할 수 있도록 구성되어 있습니다.

### 주요 특징

- ✅ **단계별 학습 구조**: 기초부터 고급까지 순차적 학습
- ✅ **Spring Boot 4.0**: 최신 Spring Boot 기반
- ✅ **Java 21**: Virtual Threads, Record, Pattern Matching 등 최신 기능 활용
- ✅ **멀티 모듈 구조**: 각 주제별 독립 실행 가능
- ✅ **실무 중심**: 실제 프로젝트에서 사용하는 패턴 학습
- ✅ **풍부한 예제**: 이론과 실습을 함께 제공

## 🛠 기술 스택

| 카테고리 | 기술 |
|---------|------|
| **Language** | Java 21 |
| **Framework** | Spring Boot 4.0, Spring MVC |
| **Build Tool** | Gradle 8.x |
| **Template Engine** | Thymeleaf |
| **Testing** | JUnit 5, MockMvc |
| **Dev Tools** | Lombok, DevTools |

## 📚 학습 모듈

### 1단계: MVC 기초 (mvc-basic)
Spring MVC의 기본 동작 원리와 핵심 개념 학습

**학습 내용:**
- DispatcherServlet 동작 원리
- Controller와 View 처리
- Model을 통한 데이터 전달
- ViewResolver 이해
- Java 21 Record, Virtual Threads 활용

**주요 예제:**
```java
@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "Welcome!");
        return "index";
    }
}
```

**학습 포인트:**
- [x] @Controller vs @RestController
- [x] Model vs ModelAndView
- [x] @PathVariable, @RequestParam
- [x] Thymeleaf 템플릿 엔진
- [x] Java 21 Record를 활용한 도메인 설계

### 2단계: 요청 매핑 (mvc-request-mapping)
HTTP 요청을 컨트롤러 메서드에 매핑하는 다양한 방법 학습

**예정 학습 내용:**
- @RequestMapping 속성 (method, params, headers, consumes, produces)
- RESTful URL 설계
- 경로 변수와 쿼리 파라미터
- Content-Type 기반 매핑

### 3단계: 요청 데이터 처리 (mvc-request-data)
클라이언트로부터 받은 데이터를 처리하는 방법 학습

**예정 학습 내용:**
- @RequestBody로 JSON 처리
- @ModelAttribute로 폼 데이터 바인딩
- HttpEntity, RequestEntity 활용
- 파일 업로드 처리

### 4단계: 응답 처리 (mvc-response)
서버에서 클라이언트로 데이터를 응답하는 방법 학습

**예정 학습 내용:**
- ResponseEntity 활용
- HttpMessageConverter 동작 원리
- API 응답 표준화
- 파일 다운로드

### 5단계: 데이터 검증 (mvc-validation)
입력 데이터의 유효성을 검증하는 방법 학습

**예정 학습 내용:**
- Bean Validation (@Valid, @Validated)
- BindingResult 처리
- 커스텀 Validator
- 검증 그룹

### 6단계: 예외 처리 (mvc-exception)
애플리케이션 예외를 효과적으로 처리하는 방법 학습

**예정 학습 내용:**
- @ExceptionHandler
- @ControllerAdvice / @RestControllerAdvice
- 커스텀 예외 계층 설계
- API 에러 응답 표준화

### 7단계: 인터셉터와 필터 (mvc-interceptor)
요청 전후 처리를 위한 인터셉터와 필터 학습

**예정 학습 내용:**
- HandlerInterceptor 구현
- Filter vs Interceptor
- 인증/인가 처리
- 로깅, 성능 측정

### 8단계: ArgumentResolver (mvc-argument-resolver)
커스텀 파라미터 처리를 위한 ArgumentResolver 학습

**예정 학습 내용:**
- HandlerMethodArgumentResolver 구현
- 커스텀 어노테이션 활용
- 로그인 사용자 자동 주입
- 페이징 정보 처리

### 9단계: MessageConverter (mvc-message-converter)
데이터 변환을 커스터마이징하는 방법 학습

**예정 학습 내용:**
- HttpMessageConverter 구현
- 커스텀 직렬화/역직렬화
- CSV, XML 등 다양한 포맷 지원

### 10단계: 비동기 처리 (mvc-async)
비동기 요청 처리 방법 학습

**예정 학습 내용:**
- Callable, DeferredResult
- @Async와 CompletableFuture
- Server-Sent Events (SSE)
- Virtual Threads 활용

## 🚀 시작하기

### 필수 요구사항

- **JDK 21** 이상
- **Gradle 8.x** 이상
- **IDE**: IntelliJ IDEA, Eclipse, VS Code 등

### 설치 및 실행

#### 1. 저장소 클론
```bash
git clone https://github.com/your-username/spring-study-hub.git
cd spring-study-hub
```

#### 2. 프로젝트 빌드
```bash
# 전체 프로젝트 빌드
./gradlew build

# 특정 모듈만 빌드
./gradlew :01-mvc-basic:build
```

#### 3. 애플리케이션 실행
```bash
# 1단계 모듈 실행
./gradlew :01-mvc-basic:bootRun

# 또는 IDE에서 MvcBasicApplication.java 실행
```

#### 4. 브라우저 접속
```
http://localhost:8081
```

각 모듈은 포트 충돌을 피하기 위해 다른 포트를 사용합니다:
- mvc-basic: 8081
- mvc-request-mapping: 8082
- mvc-request-data: 8083
- ...

## 📖 학습 가이드

### 권장 학습 순서
```
1. mvc-basic (필수)
   ↓
2. mvc-request-mapping
   ↓
3. mvc-request-data
   ↓
4. mvc-response
   ↓
5. mvc-validation
   ↓
6. mvc-exception
   ↓
7. mvc-interceptor
   ↓
8. mvc-argument-resolver
   ↓
9. mvc-message-converter
   ↓
10. mvc-async
```

### 각 모듈 학습 방법

1. **README 읽기**: 각 모듈의 README.md에서 학습 목표 확인
2. **코드 실행**: 애플리케이션을 실행하고 브라우저에서 테스트
3. **코드 분석**: Controller → Service → Repository 순서로 코드 읽기
4. **테스트 코드 실행**: 테스트를 통해 동작 확인
5. **실습 과제**: 각 모듈의 실습 과제 수행
6. **다음 단계**: 학습이 완료되면 다음 모듈로 진행

## 🔍 주요 예제

### 1. 기본 Controller (mvc-basic)
```java
@Controller
@RequestMapping("/members")
public class MemberViewController {
    
    @GetMapping
    public String list(Model model) {
        List<Member> members = memberRepository.findAll();
        model.addAttribute("members", members);
        return "members/list";
    }
    
    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Member member = memberRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("회원을 찾을 수 없습니다"));
        model.addAttribute("member", member);
        return "members/detail";
    }
}
```

### 2. REST API Controller (mvc-basic)
```java
@RestController
@RequestMapping("/api/members")
public class MemberApiController {
    
    @GetMapping
    public ResponseEntity<List<MemberDto.Response>> list() {
        List<MemberDto.Response> members = memberRepository.findAll()
            .stream()
            .map(MemberDto.Response::from)
            .toList();
        return ResponseEntity.ok(members);
    }
    
    @PostMapping
    public ResponseEntity<MemberDto.Response> create(
            @RequestBody MemberDto.CreateRequest request) {
        Member member = memberRepository.save(request.toEntity());
        return ResponseEntity.ok(MemberDto.Response.from(member));
    }
}
```

### 3. Java 21 Record 활용 (mvc-basic)
```java
// 불변 도메인 객체
public record Member(
    Long id,
    String name,
    String email,
    int age
) {
    // Compact Constructor (유효성 검증)
    public Member {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름은 필수입니다");
        }
    }
    
    // 정적 팩토리 메서드
    public static Member create(String name, String email, int age) {
        return new Member(null, name, email, age);
    }
    
    // 수정용 메서드 (새 인스턴스 반환)
    public Member withId(Long id) {
        return new Member(id, this.name, this.email, this.age);
    }
}
```

### 4. Virtual Threads 설정 (mvc-basic)
```java
@Configuration
public class VirtualThreadConfig {
    
    @Bean
    public TomcatProtocolHandlerCustomizer<?> protocolHandlerVirtualThreadExecutorCustomizer() {
        return protocolHandler -> {
            protocolHandler.setExecutor(Executors.newVirtualThreadPerTaskExecutor());
        };
    }
    
    @Bean(TaskExecutionAutoConfiguration.APPLICATION_TASK_EXECUTOR_BEAN_NAME)
    public AsyncTaskExecutor asyncTaskExecutor() {
        return new TaskExecutorAdapter(Executors.newVirtualThreadPerTaskExecutor());
    }
}
```

<!--

## 🧪 테스트

### 전체 테스트 실행
```bash
./gradlew test
```

### 특정 모듈 테스트
```bash
./gradlew :01-mvc-basic:test
```

### 테스트 예제
```java
@WebMvcTest(HomeController.class)
class HomeControllerTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @Test
    @DisplayName("홈 페이지 요청 테스트")
    void homeTest() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(model().attributeExists("message"));
    }
}
```


## 📂 프로젝트 구조
```
spring-study-hub/
├── 01-mvc-basic/                    # 1단계: MVC 기초
│   ├── src/main/java/
│   │   └── com/study/mvc/basic/
│   │       ├── controller/
│   │       ├── domain/
│   │       ├── repository/
│   │       └── config/
│   ├── src/main/resources/
│   │   ├── templates/
│   │   ├── static/
│   │   └── application.yml
│   └── build.gradle
│
├── 02-mvc-request-mapping/          # 2단계: 요청 매핑
├── 03-mvc-request-data/             # 3단계: 요청 데이터 처리
├── 04-mvc-response/                 # 4단계: 응답 처리
├── 05-mvc-validation/               # 5단계: 데이터 검증
├── 06-mvc-exception/                # 6단계: 예외 처리
├── 07-mvc-interceptor/              # 7단계: 인터셉터와 필터
├── 08-mvc-argument-resolver/        # 8단계: ArgumentResolver
├── 09-mvc-message-converter/        # 9단계: MessageConverter
├── 10-mvc-async/                    # 10단계: 비동기 처리
│
├── settings.gradle                  # 멀티 모듈 설정
├── build.gradle                     # 루트 빌드 설정
└── README.md                        # 프로젝트 설명서
```
-->
## 🎯 학습 목표 체크리스트

### mvc-basic 모듈

- [ ] Spring MVC의 전체 요청 흐름을 설명할 수 있다
- [ ] DispatcherServlet의 역할을 이해한다
- [ ] @Controller와 @RestController의 차이를 안다
- [ ] Model을 통해 View에 데이터를 전달할 수 있다
- [ ] ViewResolver의 동작 원리를 이해한다
- [ ] @PathVariable과 @RequestParam을 사용할 수 있다
- [ ] Thymeleaf 기본 문법을 사용할 수 있다
- [ ] Java 21 Record를 활용할 수 있다
- [ ] Virtual Threads의 개념과 장점을 이해한다
- [ ] MockMvc로 Controller 테스트를 작성할 수 있다

## 🌟 Java 21 주요 기능

### 1. Record Classes
```java
public record Member(Long id, String name, String email) {
    // 불변 객체, 자동으로 getter, equals, hashCode, toString 생성
}
```

### 2. Pattern Matching for switch
```java
String message = switch (result) {
    case String s -> "문자열: " + s;
    case Integer i -> "숫자: " + i;
    case null -> "null 값";
    default -> "기타";
};
```

### 3. Virtual Threads
```java
// 경량 스레드로 높은 동시성 처리
Thread.ofVirtual().start(() -> {
    System.out.println("Virtual Thread");
});
```

### 4. Sequenced Collections
```java
var list = new ArrayList<String>();
String first = list.getFirst();  // 새로운 메서드
String last = list.getLast();    // 새로운 메서드
```

## 📝 참고 자료

### 공식 문서
- [Spring Framework Documentation](https://docs.spring.io/spring-framework/reference/)
- [Spring Boot Documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/)
- [Java 21 Documentation](https://docs.oracle.com/en/java/javase/21/)

### 추천 학습 자료
- [Spring MVC Tutorial](https://spring.io/guides/gs/serving-web-content/)
- [Thymeleaf Documentation](https://www.thymeleaf.org/documentation.html)
- [Baeldung Spring Tutorials](https://www.baeldung.com/spring-tutorial)

### 책
- "스프링 부트 3 백엔드 개발자 되기" - 신선영
- "토비의 스프링 3.1" - 이일민
- "스프링 인 액션" - 크레이그 월즈

## 🤝 기여하기

이 프로젝트는 학습 목적으로 만들어졌습니다. 개선사항이나 오류를 발견하시면 이슈를 등록해주세요.

### 기여 방법

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📧 문의

- 프로젝트 이슈: [GitHub Issues](https://github.com/jinikjang88/spring-study-hub/issues)
- 이메일: jinik.jang.1988@gmail.com

## 📄 라이센스

이 프로젝트는 학습 목적으로 자유롭게 사용 가능합니다.

## 🙏 감사의 말

- Spring Framework 팀에게 감사드립니다
- 모든 오픈소스 기여자분들께 감사드립니다
- 이 프로젝트로 학습하는 모든 분들을 응원합니다

---

⭐ 이 프로젝트가 도움이 되었다면 Star를 눌러주세요!

**Happy Coding! 🚀**