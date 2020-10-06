package org.truebird.mapper;


import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.truebird.domain.Criteria;
import org.truebird.domain.ReplyVO;

import java.util.List;
import java.util.stream.IntStream;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {org.truebird.config.RootConfig.class})
@Log4j
public class ReplyMapperTests {

    private Long[] bnoArr = { 159L, 158L, 157L, 156L, 155L };

    @Setter(onMethod_ = @Autowired)
    private ReplyMapper mapper;

    @Test
    public void testList() {

        Criteria cri = new Criteria();
        Long targetBno = bnoArr[0];
        List<ReplyVO> replies = mapper.getListWithPaging(cri,targetBno);
        replies.forEach(reply -> log.info(reply));
        
    }

    @Test
    public void testUpdate() {

        Long targetRno = 10L;

        ReplyVO reply = mapper.read(targetRno);
        reply.setReply("Update Reply ");
        int count = mapper.update(reply);
        log.info("UPDATE COUNT: " + count);

    }

    @Test
    public void testDelete() {

        Long targetRno = 5L;
        mapper.delete(targetRno);
    }

    @Test
    public void testRead() {
        Long targetRno = 5L;
        ReplyVO vo = mapper.read(targetRno);
        log.info("select : " + vo);
    }

    @Test
    public void testCreate() {

        IntStream.rangeClosed(1, 10).forEach(i -> {

            ReplyVO vo = new ReplyVO();

            vo.setBno(bnoArr[i % 5]);
            vo.setReply("댓글 테스트 " + i);
            vo.setReplyer("replyer" + i);

            mapper.insert(vo);
        });
    }

    @Test
    public void testMapper() {

        log.info(mapper);
    }
}