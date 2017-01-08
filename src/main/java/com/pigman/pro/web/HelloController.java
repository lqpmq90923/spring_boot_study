package com.pigman.pro.web;

import com.pigman.pro.domain.PnType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class description
 * 17/01/08
 * @version   1.0
 * @author    pig man
 */
@Controller
@RequestMapping("/thymeleaf")
public class HelloController {

    static Map<Long, PnType> pnTypeMap = new HashMap<Long, PnType>();

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "world") String name,
                           Model model) {
        model.addAttribute("xname", name);
        return "index";
    }

    @RequestMapping(value="/", method= RequestMethod.GET)
    public List<PnType> getUserList() {
        // 处理"/users/"的GET请求，用来获取用户列表
        // 还可以通过@RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递
        List<PnType> r = new ArrayList<PnType>(pnTypeMap.values());
        return r;
    }

    @RequestMapping(value="/", method=RequestMethod.POST)
    public String postUser(@ModelAttribute PnType pntype) {
        // 处理"/users/"的POST请求，用来创建User
        // 除了@ModelAttribute绑定参数之外，还可以通过@RequestParam从页面中传递参数
        pnTypeMap.put(pntype.getId(), pntype);
        return "success";
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public PnType getUser(@PathVariable Long id) {
        // 处理"/users/{id}"的GET请求，用来获取url中id值的User信息
        // url中的id可通过@PathVariable绑定到函数的参数中
        return pnTypeMap.get(id);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public String putType(@PathVariable Long id, @ModelAttribute PnType pnType) {
        // 处理"/users/{id}"的PUT请求，用来更新User信息
        System.out.println(pnType);
        PnType u = pnTypeMap.get(id);
        u.setComments(pnType.getComments());
        pnTypeMap.put(id, u);
        return "success";
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        // 处理"/users/{id}"的DELETE请求，用来删除User
        pnTypeMap.remove(id);
        return "success";
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
