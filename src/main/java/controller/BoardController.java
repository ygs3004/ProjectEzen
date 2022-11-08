package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = "/board")
public class BoardController {


    /** 게시판 - 목록 페이지 이동 */
    @RequestMapping(value = "/boardList")
    public String boardList(HttpServletRequest request, HttpServletResponse response) throws Exception {

        return "board/boardList";
    }

    /** 게시판 - 상세 페이지 이동 */
    @RequestMapping(value = "/boardDetail")
    public String boardDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {

        return "board/boardDetail";
    }

    /** 게시판 - 작성 페이지 이동 */
    @RequestMapping(value = "/boardWrite")
    public String boardWrite(HttpServletRequest request, HttpServletResponse response) throws Exception {

        return "board/boardWrite";
    }

     /** 게시판 - 수정 페이지 이동 */
    @RequestMapping(value = "/boardUpdate")
    public String boardUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception {

        return "board/boardUpdate";
    }

     /** 게시판 - 답글 페이지 이동 */
    @RequestMapping(value = "/boardReply")
    public String boardReply(HttpServletRequest request, HttpServletResponse response) throws Exception {

        return "board/boardReply";
    }

    /** 게시판 - 첨부파일 다운로드 */
    @RequestMapping("/fileDownload")
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