package hello.servlet.domain.member;

import java.util.List;

public interface MemberRepository {

    Member save(Member member);

    Member findById(Long Id);
    List<Member> findAll();
    void clearStore();
}
