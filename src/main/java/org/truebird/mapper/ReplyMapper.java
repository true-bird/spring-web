package org.truebird.mapper;

import org.apache.ibatis.annotations.Param;
import org.truebird.domain.Criteria;
import org.truebird.domain.ReplyVO;

import java.util.List;

public interface ReplyMapper {

    public int insert(ReplyVO vo);

    public ReplyVO read(Long rno);

    public int delete(Long rno);

    public int update(ReplyVO reply);

    public List<ReplyVO> getListWithPaging(
            @Param("cri") Criteria cri,
            @Param("bno") Long bno);
}
