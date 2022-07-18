package techcourse.project.pair.member.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import techcourse.project.pair.member.entity.Member;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;


    @Test
    @Transactional
    @Rollback
    public void testMember() {

        //인스턴스화
        Member member = new Member(null, "aaa", "0000", "김에이", "에이", "aaa@aaa.com");

        //값 저장
        memberRepository.save(member);


        //
        Member findMember = memberRepository.findByUsername((member.getUsername()));

        assertEquals(findMember.getId(), member.getId());
        assertEquals(findMember.getNickname(), member.getUsername());
        assertEquals(findMember, member);

    }
}