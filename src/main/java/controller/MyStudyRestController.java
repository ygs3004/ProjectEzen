package controller;

import domain.HomeWork;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import service.MyStudyService;

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

}
