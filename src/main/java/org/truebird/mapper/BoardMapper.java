package org.truebird.mapper;

import org.apache.ibatis.annotations.Select;
import org.truebird.domain.BoardVO;

import java.util.List;

public interface BoardMapper {

    // @Select("select * from tbl_board where bno > 0")
    public List<BoardVO> getList();
}
