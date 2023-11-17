package com.chanhan.restApi;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/boards")
public class BoardController {
    static Logger logger = LoggerFactory.getLogger(BoardController.class);

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<ArticleVO>> listArticle(){
        List<ArticleVO> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ArticleVO vo = new ArticleVO();
            vo.setArticleNO(i);
            vo.setWriter("홍길동");
            vo.setTitle("제목");
            vo.setContent("내용");
            list.add(vo);
        }
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/{articleNo}", method = RequestMethod.GET)
    public ResponseEntity<ArticleVO> findaritcle(@RequestParam("articleNO") Integer articleNO){
        ArticleVO vo = new ArticleVO();
        vo.setArticleNO(articleNO);
        vo.setWriter("홍박사");
        vo.setTitle("제목2");
        vo.setContent("내용2");
        return new ResponseEntity<>(vo, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<String> addArticle (@RequestBody ArticleVO articleVO){
        ResponseEntity<String> resEntity = null;
        try {
            resEntity = new ResponseEntity<>("ADD_SUCCEEDED", HttpStatus.OK);
        } catch (Exception e) {
            resEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);        }
        return resEntity;
    }

    @RequestMapping(value = "/{articleNO}", method = RequestMethod.PUT)
    public ResponseEntity<String> modArticle(@PathVariable("articleNO") Integer articleNO,
                                             @RequestBody ArticleVO articleVO){
        ResponseEntity<String> resEntity = null;
        try {
            resEntity = new ResponseEntity<>("MOD_SUCCEEDED", HttpStatus.OK);
        } catch (Exception e) {
            resEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);        }
        return resEntity;
    }

    @RequestMapping(value = "/{articleNO}", method = RequestMethod.DELETE)
    public ResponseEntity<String> removeArticle(@PathVariable("articleNO") Integer articleNO){
        ResponseEntity<String> resEntity = null;
        try {
            resEntity = new ResponseEntity<>("REMOVE_SUCCEEDED", HttpStatus.OK);
        } catch (Exception e) {
            resEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return resEntity;
    }

}
