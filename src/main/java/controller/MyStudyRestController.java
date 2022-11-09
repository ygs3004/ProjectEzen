package controller;

import domain.HomeWork;
import domain.HomeWorkInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.MyStudyService;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

@Log4j
@RestController
@RequestMapping("/MyStudy")
@RequiredArgsConstructor
public class MyStudyRestController {

    final MyStudyService myStudyService;

    @GetMapping("/homeWorkList")
    @ResponseBody
    public ResponseEntity<List<HomeWork>> getHomeWorkList(String writer){
        List<HomeWork> hwList = myStudyService.getHomeWorkList(writer);
        log.info(writer + "의 과제리스트 전달"+hwList.get(0));

        return new ResponseEntity<>(hwList, HttpStatus.OK);
    }

    @PatchMapping("/{writer}")
    @ResponseBody
    public ResponseEntity<String> modifyHwInfo(
            @RequestBody HomeWorkInfo hwInfo,
            @PathVariable String writer
            ){

        hwInfo.setWriter(writer);
        int updateCount = myStudyService.modifyHwInfo(hwInfo);

        return updateCount == 1
                ? new ResponseEntity<>("success", HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/{writer}")
    @ResponseBody
    public ResponseEntity<String> modifyHwInfo(@PathVariable String writer){

        int deleteCount = myStudyService.deleteHwInfo(writer);

        return deleteCount == 1
                ? new ResponseEntity<>("success", HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping( value = "/downloadHw", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @ResponseBody
    public ResponseEntity<Resource> downloadFile(@RequestHeader("User-Agent")String userAgent, String filename){
        log.info("다운로드 첨부파일 : " + filename);

        Resource resource = new FileSystemResource("c:\\upload\\temp\\"+filename);

        if(!resource.exists()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        log.info("resource : "+resource);
        String resourceName = resource.getFilename();

        //다운로드 받은 사람의 파일이름 uuid 제거
        String resourceOriginalName = resourceName.substring(resourceName.indexOf("_")+1);

        HttpHeaders headers = new HttpHeaders();
        try{
            String downloadName = null;

            if(userAgent.contains("Trident")){
                log.info("IE browser 에서의 다운로드");
                downloadName = URLEncoder.encode(resourceOriginalName, "UTF-8").replaceAll("\\+", "");
            }else if(userAgent.contains("Edge")){
                log.info("Edge browser 에서의 다운로드");
                downloadName = URLEncoder.encode(resourceOriginalName, "UTF-8");
            }else{
                log.info("Chrome browser에서의 다운로드");
                downloadName = new String(resourceOriginalName.getBytes("UTF-8"), "ISO-8859-1");
            }

            headers.add("Content-Disposition", "attachment; filename=" + downloadName);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(resource, headers, HttpStatus.OK);
    }
//
//    @RequestMapping(method = {RequestMethod.PUT, RequestMethod.PATCH},
//            value = /

}
