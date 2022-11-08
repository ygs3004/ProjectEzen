package mapper;

import domain.board.BoardDto;
import domain.board.BoardFileDto;
import form.BoardFileForm;
import form.BoardForm;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface BoardMapper {

    /** 게시판 - 목록 수 */
    public int getBoardCnt(BoardForm boardForm);

    /** 게시판 - 목록 조회 */
    public List<BoardDto> getBoardList(BoardForm boardForm);

    /** 게시판 - 조회 수 수정 */
    public int updateBoardHits(BoardForm boardForm);

    /** 게시판 - 상세 조회 */
    public BoardDto getBoardDetail(BoardForm boardForm);

    /** 게시판 - 첨부파일 조회 */
    public List<BoardFileDto> getBoardFileList(BoardFileForm boardFileForm);

    /** 게시판 - 그룹 번호 조회 */
    public int getBoardReRef(BoardForm boardForm);

    /** 게시판 - 등록 */
    public int insertBoard(BoardForm boardForm);

    /** 게시판 - 첨부파일 등록 */
    public int insertBoardFile(BoardFileForm boardFileForm);

    /** 게시판 - 등록 실패(트랜잭션 테스트) */
    public int insertBoardFail(BoardForm boardForm);

    /** 게시판 - 삭제 */
    public int deleteBoard(BoardForm boardForm);

    /** 게시판 - 수정 */
    public int updateBoard(BoardForm boardForm);

    /** 게시판 - 답글 정보  조회 */
    public BoardDto getBoardReplyInfo(BoardForm boardForm);

    /** 게시판 - 답글의 순서 수정 */
    public int updateBoardReSeq(BoardForm boardForm);

    /** 게시판 - 답글 등록 */
    public int insertBoardReply(BoardForm boardForm);

    /** 게시판 - 첨부파일 삭제 */
    public int deleteBoardFile(BoardFileForm boardFileForm);
}
