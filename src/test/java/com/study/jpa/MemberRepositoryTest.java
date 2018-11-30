package com.study.jpa;

import com.study.jpa.domain.Member;
import com.study.jpa.domain.Posts;
import com.study.jpa.domain.Team;
import com.study.jpa.repository.MemberRepository;
import com.study.jpa.repository.PostsRepository;
import com.study.jpa.repository.TeamRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    TeamRepository teamRepository;

    @After
    public void cleanup() {
        /**
         이후 테스트 코드에 영향을 끼치지 않기 위해
         테스트 메소드가 끝날때 마다 respository 전체 비우는 코드
         **/
        memberRepository.deleteAll();
    }

    @Test
    public void 멤버이름_불러오기() {
        //given
        Team testTeam = new Team("한화");
        teamRepository.save(testTeam);

        memberRepository.save(Member.builder()
                .userName("tsoh")
                .team(testTeam)
                .build());

        //when
        List<Member> memberList = memberRepository.findAll();

        //then
        Member member = memberList.get(0);

        assertThat(member.getUserName(), is("tsoh"));
        assertThat(member.getTeam().getName(), is("한화"));

    }
}