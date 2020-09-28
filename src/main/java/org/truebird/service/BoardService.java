package org.truebird.service;

import org.truebird.domain.BoardVO;
import org.truebird.domain.Criteria;

import java.util.List;

public interface BoardService {

    public void register(BoardVO board);

    public BoardVO get(Long bno);

    public int getTotal(Criteria cri);

    public boolean modify(BoardVO board);

    public boolean remove(Long bno);

//    public List<BoardVO> getList();

    public List<BoardVO> getList(Criteria cir);

}
