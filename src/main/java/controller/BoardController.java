package controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import common.ResultUtil;
import domain.board.BoardDto;
import form.BoardForm;
import service.BoardService;

@Controller
@RequestMapping(value = "/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @Resource(name = "loginUserBean")
    private User loginUserBean;

    /** 게시판 - 목록 페이지 이동 */
    @GetMapping("/boardList")
    public String boardList(HttpServletRequest request, HttpServletResponse response) throws Exception {


        return "board/boardList";
    }

    /** 게시판 - 목록 조회 */
    @PostMapping("/getBoardList")
    @ResponseBody
    public ResultUtil getBoardList(HttpServletRequest request, HttpServletResponse response, BoardForm boardForm) throws Exception {

        ResultUtil resultUtils = boardService.getBoardList(boardForm);

        return resultUtils;
    }

    /** 게시판 - 상세 페이지 이동 */
    @GetMapping("/boardDetail")
    public String boardDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {

        return "board/boardDetail";
    }

    /** 게시판 - 상세 조회 */
    @PostMapping("/getBoardDetail")
    @ResponseBody
    public BoardDto getBoardDetail(HttpServletRequest request, HttpServletResponse response, BoardForm boardForm) throws Exception {

        MDC.put("ID", String.valueOf(boardForm.getBoard_seq()));

        BoardDto boardDto = boardService.getBoardDetail(boardForm);

        MDC.remove("ID");

        return boardDto;
    }

    /** 게시판 - 작성 페이지 이동 */
    @GetMapping("/boardWrite")
    public String boardWrite(HttpServletRequest request, HttpServletResponse response) throws Exception {

        return "board/boardWrite";
    }

    /** 게시판 - 등록 */
    @PostMapping ("/insertBoard")
    @ResponseBody
    public BoardDto insertBoard(HttpServletRequest request, HttpServletResponse response, BoardForm boardForm) throws Exception {

        BoardDto boardDto = boardService.insertBoard(boardForm);

        return boardDto;
    }

    /** 게시판 - 삭제 */
    @PostMapping("/deleteBoard")
    @ResponseBody
    public BoardDto deleteBoard(HttpServletRequest request, HttpServletResponse response, BoardForm boardForm) throws Exception {

        BoardDto boardDto = boardService.deleteBoard(boardForm);

        return boardDto;
    }

    /** 게시판 - 수정 페이지 이동 */
    @GetMapping("/boardUpdate")
    public String boardUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception {

        return "board/boardUpdate";
    }

    /** 게시판 - 수정 */
    @PostMapping("/updateBoard")
    @ResponseBody
    public BoardDto updateBoard(HttpServletRequest request, HttpServletResponse response, BoardForm boardForm) throws Exception {

        BoardDto boardDto = boardService.updateBoard(boardForm);

        return boardDto;
    }

    /** 게시판 - 답글 페이지 이동 */
    @GetMapping("/boardReply")
    public String boardReply(HttpServletRequest request, HttpServletResponse response) throws Exception {

        return "board/boardReply";
    }

    /** 게시판 - 답글 등록 */
    @PostMapping("/insertBoardReply")
    @ResponseBody
    public BoardDto insertBoardReply(HttpServletRequest request, HttpServletResponse response, BoardForm boardForm) throws Exception {

        BoardDto boardDto = boardService.insertBoardReply(boardForm);

        return boardDto;
    }

    /** 게시판 - 첨부파일 다운로드 */
    @GetMapping("/fileDownload")
    public ModelAndView fileDownload(@RequestParam("fileNameKey") String fileNameKey
            ,@RequestParam("fileName") String fileName
            ,@RequestParam("filePath") String filePath) throws Exception {

        /** 첨부파일 정보 조회 */
        Map<String, Object> fileInfo = new HashMap<String, Object>();
        fileInfo.put("fileNameKey", fileNameKey);
        fileInfo.put("fileName", fileName);
        fileInfo.put("filePath", filePath);

        return new ModelAndView("fileDownloadUtil", "fileInfo", fileInfo);
    }
}