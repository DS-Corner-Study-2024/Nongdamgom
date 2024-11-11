/* 의존성주입(DI): 제어 역전 방법 중 1, 사용할 객체 직접 생성x, 외부 컨테이너가 생성한 객체를 주입받아 사용(생성자, 필드 객체 선언, setter 메서드)
@Autowired 어노테이션을 통해 의존성 주입(생략 가능) */

/* 예제 1.2 생성자를 통한 의존성 주입 */
@RestController
public class DIController {

    MyService myService;

    @Autowired
    public DIController(MyService myService) {
        this.myService = myService;
    }

    @GetMapping("/di/hello")
    public String getHello() {
        return myService.getHello();
    }
}

/* 스프링 공식 문서에서 권장-> 생성자를 통해 의존성 주입 (다른 방식과는 다르게 레퍼런스 객체 없이는 객체를 초기화할 수 없게 설계할 수 있음)*/