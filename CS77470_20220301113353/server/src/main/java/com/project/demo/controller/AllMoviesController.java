package com.project.demo.controller;

import com.project.demo.entity.AllMovies;
import com.project.demo.service.AllMoviesService;
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
 *所有电影：(AllMovies)表控制层
 *
 */
@RestController
@RequestMapping("/all_movies")
public class AllMoviesController extends BaseController<AllMovies,AllMoviesService> {

    /**
     *所有电影对象
     */
    @Autowired
    public AllMoviesController(AllMoviesService service) {
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
