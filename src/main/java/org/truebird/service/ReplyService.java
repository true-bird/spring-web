package org.truebird.service;

import org.truebird.domain.Criteria;
import org.truebird.domain.ReplyVO;

import java.util.List;

public interface ReplyService {

    public int register(ReplyVO vo);

    public ReplyVO get(Long rno);

    public int modify(ReplyVO vo);

    public int remove(Long rno);

    public List<ReplyVO> getList(Criteria cri, Long bno);

}