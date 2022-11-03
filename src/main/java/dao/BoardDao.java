package dao;
 
import java.util.List;

import javax.annotation.Resource;

import mapper.BoardMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import domain.board.BoardDto;
import domain.board.BoardFileDto;
import form.BoardFileForm;
import form.BoardForm;
 
@Repository
public class BoardDao {

    @Autowired
    BoardMapper mapper;

    public int getBoardCnt(BoardForm boardForm) throws Exception {
        return mapper.getBoardCnt(boardForm);
    }

    public List<BoardDto> getBoardList(BoardForm boardForm){
        return mapper.getBoardList(boardForm);
    }
 

    public int updateBoardHits(BoardForm boardForm) throws Exception {

        return mapper.updateBoardHits(boardForm);
    }


    public BoardDto getBoardDetail(BoardForm boardForm) throws Exception {

        return mapper.getBoardDetail(boardForm);
    }
    

    public List<BoardFileDto> getBoardFileList(BoardFileForm boardFileForm) throws Exception {

        return mapper.getBoardFileList(boardFileForm);
    }
 

    public int getBoardReRef(BoardForm boardForm) throws Exception {
        return mapper.getBoardReRef(boardForm);
    }
    

    public int insertBoard(BoardForm boardForm) throws Exception {
        return mapper.insertBoard(boardForm);
    }
    

    public int insertBoardFile(BoardFileForm boardFileForm) throws Exception {
        return mapper.insertBoardFile(boardFileForm);
    }
 

    public int insertBoardFail(BoardForm boardForm) throws Exception {
        return mapper.insertBoardFail(boardForm);
    }
 

    public int deleteBoard(BoardForm boardForm) throws Exception {

        return mapper.deleteBoard(boardForm);
    }
 

    public int updateBoard(BoardForm boardForm) throws Exception {

        return mapper.updateBoard(boardForm);
    }
    

    public BoardDto getBoardReplyInfo(BoardForm boardForm) throws Exception {

        return mapper.getBoardReplyInfo(boardForm);
    }
    

    public int updateBoardReSeq(BoardForm boardForm) throws Exception {
        return mapper.updateBoardReSeq(boardForm);
    }
    

    public int insertBoardReply(BoardForm boardForm) throws Exception {

        return mapper.insertBoardReply(boardForm);
    }
    

    public int deleteBoardFile(BoardFileForm boardFileForm) throws Exception {

        return mapper.deleteBoardFile(boardFileForm);
    }
}


