/* 예제 1.3 필드 객체 선언을 통한 의존성 주입 */
@RestController
public class FieldInjectionController {

    @Autowired
    private MyService myService;
}