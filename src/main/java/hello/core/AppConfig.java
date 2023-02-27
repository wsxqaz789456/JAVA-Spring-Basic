package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 설정정보, 구성정보에 Configuration, 붙이지 않으면 빈은 등록되지만 싱글톤이 보장되지 않는다.
public class AppConfig {
    // 구성 영역
    // 구성 영역에서 변경.
    // 프로그램에 대한 제어 흐름에 대한 권한은 모두 AppConfig가 가지고 있다.
    @Bean//각 메서드에 Bean을 적으면 스프링 컨테이너에 등록이 됨.
    public MemberService memberService(){

        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {

        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderServiceImpl orderService(){
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
