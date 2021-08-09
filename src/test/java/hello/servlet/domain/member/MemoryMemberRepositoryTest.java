package hello.servlet.domain.member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemberRepository memoryMemberRepository = MemoryMemberRepository.getInstance();

    @AfterEach//@Test가 끝날때마다 memberRepository를 초기화
    void afterEach(){
        memoryMemberRepository.clearStore();
    }

    @Test
    void save(){
        //given
        Member member = new Member("hello", 20);

       //when
        Member savedMember = memoryMemberRepository.save(member);

        //then
        Member findMember = memoryMemberRepository.findById(savedMember.getId());
        assertThat(findMember).isEqualTo(savedMember);
    }

    @Test
    void findAll(){
        //given
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 30);

        memoryMemberRepository.save(member1);
        memoryMemberRepository.save(member2);

        //when
        List<Member> result = memoryMemberRepository.findAll();

        //then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(member1, member2);

    }
}