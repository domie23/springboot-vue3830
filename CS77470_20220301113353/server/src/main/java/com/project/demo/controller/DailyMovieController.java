package com.project.demo.controller;

import com.project.demo.entity.DailyMovie;
import com.project.demo.service.DailyMovieService;
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
 *每日电影：(DailyMovie)表控制层
 *
 */
@RestController
@RequestMapping("/daily_movie")
public class DailyMovieController extends BaseController<DailyMovie,DailyMovieService> {

    /**
     *每日电影对象
     */
    @Autowired
    public DailyMovieController(DailyMovieService service) {
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
