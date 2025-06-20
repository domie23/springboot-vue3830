package com.project.demo.controller;

import com.project.demo.entity.HighScoreFilm;
import com.project.demo.service.HighScoreFilmService;
import com.project.demo.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *高分电影：(HighScoreFilm)表控制层
 *
 */
@RestController
@RequestMapping("/high_score_film")
public class HighScoreFilmController extends BaseController<HighScoreFilm,HighScoreFilmService> {

    /**
     *高分电影对象
     */
    @Autowired
    public HighScoreFilmController(HighScoreFilmService service) {
        setService(service);
    }

    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        this.addMap(paramMap);
        return success(1);
    }

}
