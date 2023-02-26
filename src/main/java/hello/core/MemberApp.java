package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        //AppConfig에 있는 환경설정 정보를 가지고 스프링이 스프링 컨테이너에 있는 객체를 관리함.
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        //메서드 이름을 전달하고 타입을 지정하면 꺼낼 수 있음.
        //스프링 컨테이너를 통해서 필요한 스프링 빈(객체)을 찾아야함.
        //getBean 메소드를 통해서 찾을 수 있다.


        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
