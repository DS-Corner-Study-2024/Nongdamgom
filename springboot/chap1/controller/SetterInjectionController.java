/* 예제 1.4 setter 메서드를 통한 의존성 주입 */
@RestController
public class SetterInjectionController {

    MyService myService;

    @Autowired
    public void setMyService(MyService myService) {
        this.myService = myService;
    }
}