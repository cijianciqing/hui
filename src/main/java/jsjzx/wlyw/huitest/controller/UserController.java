package jsjzx.wlyw.huitest.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import jsjzx.wlyw.huitest.beans.Msg;
import jsjzx.wlyw.huitest.beans.SearchInfo;
import jsjzx.wlyw.huitest.beans.User;
import jsjzx.wlyw.huitest.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.jws.soap.SOAPBinding;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author CiJian
 * @since 2018-08-28
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    /*
    * 显示所有的用户信息
    * 暂时未用
    * */
    @ResponseBody
    @GetMapping(value = "getAllUsers")
    public List<User> getAllUsers() {
        List<User> users = userService.selectList(null);
        return users;
    }

    /*
    * 根据前端要求进行分页查询
    * */
    @ResponseBody
    @GetMapping(value = "/getUsers")
    public Map<String, Object> getUsers(SearchInfo searchInfo) {
        //输出当前的查询信息
        System.out.println("当前的查询信息： " + searchInfo);
        //获取前台传递的参数
        Integer pageSize = searchInfo.getPageSize();
        Integer pageNumber = searchInfo.getPageNumber();
        String searchText = searchInfo.getSearchText();
        String sortName = searchInfo.getSortName();
        String sortOrder = searchInfo.getSortOrder();
        String nickNameSearch = searchInfo.getNickNameSearch();
        String userNameSearch = searchInfo.getUserNameSearch();
        //排序使用的列
        List<String> orderColumn = new ArrayList<>();
        orderColumn.add(sortName);
        //后台分页查询
        Page<User> page = new Page<>(pageNumber, pageSize);
        EntityWrapper<User> wrapper = new EntityWrapper<>();
        wrapper.like("name", nickNameSearch);
        wrapper.like("username", userNameSearch);
        //设置排序
        if (sortOrder.equalsIgnoreCase("asc")) {
            wrapper.orderAsc(orderColumn);
        }else if(sortOrder.equalsIgnoreCase("desc")){
            wrapper.orderDesc(orderColumn);
        }
        //获取要查询的数据
        Page<User> page1 = userService.selectPage(page, wrapper);
        //获取查询结果的总量
        int totalUser = userService.selectCount(wrapper);
        //传递到前端的参数
        Map<String, Object> map = new HashMap<>();
        map.put("total", totalUser);
        map.put("rows", page1.getRecords());
        return map;
    }

    @ResponseBody
    @PostMapping(value = "/add")
    public Msg addUser(@Valid User user, BindingResult result) {
        //将提交的参数转换为Asset
        //保存到数据库
        if (result.hasErrors()) {
            Map<String, Object> map = new HashMap<>();
            List<FieldError> errors = result.getFieldErrors();
            for (FieldError fieldError : errors) {
                System.out.println("错误的字段名：" + fieldError.getField());
                System.out.println("错误信息：" + fieldError.getDefaultMessage());
                map.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return Msg.fail().add("errorFields", map);
        } else {
            userService.insert(user);
            return Msg.success();
        }
    }

    //更新用户信息之前，查询用户信息
    @ResponseBody
    @GetMapping(value = "/edit/{id}")
    public Msg getOne(@PathVariable("id") Integer id){
        User user = userService.selectById(id);
        return Msg.success().add("user",user);
    }

    //更新用户
    @ResponseBody
    @PutMapping(value = "/edit")
    public Msg updateUser(@Valid User user, BindingResult result) {
        //将提交的参数转换为Asset
        //保存到数据库
        if (result.hasErrors()) {
            Map<String, Object> map = new HashMap<>();
            List<FieldError> errors = result.getFieldErrors();
            for (FieldError fieldError : errors) {
                System.out.println("错误的字段名：" + fieldError.getField());
                System.out.println("错误信息：" + fieldError.getDefaultMessage());
                map.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return Msg.fail().add("errorFields", map);
        } else {
            userService.updateById(user);
            return Msg.success();
        }
    }

    //删除用户
    @ResponseBody
    @RequestMapping(value="/delete/{ids}",method=RequestMethod.DELETE)
    public Msg delUser(@PathVariable("ids")String ids){
        //批量删除
        if(ids.contains("-")){
            List<Integer> del_ids = new ArrayList<>();
            String[] str_ids = ids.split("-");
            //组装id的集合
            for (String string : str_ids) {
                del_ids.add(Integer.parseInt(string));
            }
            userService.deleteBatchIds(del_ids);
        }else{
            Integer id = Integer.parseInt(ids);
            userService.deleteById(id);
        }
        return Msg.success();
    }
}

