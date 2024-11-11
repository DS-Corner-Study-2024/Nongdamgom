/* 예제 1.1 일반적인 자바 코드에서의 객체 사용법 */
@RestController
public class NoDIController {

    private MyService service = new MyServiceImpl();

    @GetMapping("/no-di/hello")
    public String getHello(){
        return service.getHello();
    }
}
/* 스프링-> 제어역전(IoC)을 사용하여 객체의 생명주기 관리를 스프링 컨테이너 또는 IoC 컨테이너에 위임함(제어권이 넘어감)=> DI, AOP 가능 */