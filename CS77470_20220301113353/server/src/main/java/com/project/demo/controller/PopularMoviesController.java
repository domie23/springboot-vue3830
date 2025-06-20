package com.project.demo.controller;

import com.project.demo.entity.PopularMovies;
import com.project.demo.service.PopularMoviesService;
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
 *热门电影：(PopularMovies)表控制层
 *
 */
@RestController
@RequestMapping("/popular_movies")
public class PopularMoviesController extends BaseController<PopularMovies,PopularMoviesService> {

    /**
     *热门电影对象
     */
    @Autowired
    public PopularMoviesController(PopularMoviesService service) {
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
