package org.truebird.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.truebird.domain.Criteria;
import org.truebird.domain.ReplyPageDTO;
import org.truebird.domain.ReplyVO;
import org.truebird.service.ReplyService;

import java.util.List;


@RequestMapping("/replies/")
@RestController
@Log4j
@AllArgsConstructor
public class ReplyController {

    private ReplyService service;

    @PostMapping(value = "/new",
            consumes = "application/json",
            produces = {MediaType.TEXT_PLAIN_VALUE}) // 해당 메소드가 생산하는 MIME 타입 ( Content-Type )
    public ResponseEntity<String> create(@RequestBody ReplyVO vo) {

        log.info("ReplyVO: " + vo);

        int insertCount = service.register(vo);

        return insertCount == 1
                ? new ResponseEntity<>("success", HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

    }


    @GetMapping(value = "/pages/{bno}/{page}",
            produces = {
                    MediaType.APPLICATION_JSON_UTF8_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<ReplyPageDTO> getList(
            @PathVariable("page") int page,
            @PathVariable("bno") Long bno) {

        Criteria cri = new Criteria(page, 10);
        log.info("get Reply List bno: " + bno);
        log.info("cri: " + cri);

        return new ResponseEntity<>(service.getList(cri, bno), HttpStatus.OK);

    }

    @GetMapping(value = "/{rno}",
            produces = {
                    MediaType.APPLICATION_JSON_UTF8_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<ReplyVO> get(@PathVariable("rno") Long rno) {

        log.info("get: " + rno);

        return new ResponseEntity<>(service.get(rno), HttpStatus.OK);
    }

    @DeleteMapping(value = "{rno}",
            produces = {MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> remove(@PathVariable("rno") Long rno) {

        log.info("remove: " + rno);

        return service.remove(rno) == 1
                ? new ResponseEntity<>("success", HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(method = {RequestMethod.PUT, RequestMethod.PATCH},
            value = "/{rno}",
            consumes = "application/json",
            produces = {MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> modify(
            @RequestBody ReplyVO vo,
            @PathVariable("rno") Long rno) {

        vo.setRno(rno);

        log.info("rno: " + rno);

        log.info("modify: " + vo);

        return service.modify(vo) == 1
                ? new ResponseEntity<>("success", HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }


}