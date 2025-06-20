package com.project.demo.controller;

import com.project.demo.entity.OrdinaryUsers;
import com.project.demo.service.OrdinaryUsersService;
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
 *普通用户：(OrdinaryUsers)表控制层
 *
 */
@RestController
@RequestMapping("/ordinary_users")
public class OrdinaryUsersController extends BaseController<OrdinaryUsers,OrdinaryUsersService> {

    /**
     *普通用户对象
     */
    @Autowired
    public OrdinaryUsersController(OrdinaryUsersService service) {
        setService(service);
    }

    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        Map<String, String> mapuser_mobile_phone = new HashMap<>();
        mapuser_mobile_phone.put("user_mobile_phone",String.valueOf(paramMap.get("user_mobile_phone")));
        List listuser_mobile_phone = service.select(mapuser_mobile_phone, new HashMap<>()).getResultList();
        if (listuser_mobile_phone.size()>0){
            return error(30000, "字段用户手机内容不能重复");
        }
        Map<String, String> mapuser_mailbox = new HashMap<>();
        mapuser_mailbox.put("user_mailbox",String.valueOf(paramMap.get("user_mailbox")));
        List listuser_mailbox = service.select(mapuser_mailbox, new HashMap<>()).getResultList();
        if (listuser_mailbox.size()>0){
            return error(30000, "字段用户邮箱内容不能重复");
        }
        this.addMap(paramMap);
        return success(1);
    }

}
