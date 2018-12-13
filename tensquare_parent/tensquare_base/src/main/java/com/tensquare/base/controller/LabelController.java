package com.tensquare.base.controller;

import com.tensquare.base.pojo.Label;
import com.tensquare.base.service.LabelService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import util.IdWorker;

import java.util.List;

/**
 * Created by CuiJie on 2018/12/13.
 * 标签控制器类
 * <p>
 * 跨域是什么？浏览器从一个域名的网页去请求另一个域名的资源时，域名、端口、 协议任一不同，都是跨域 。
 * 我们是采用前后端分离开发的，也是前后端分离部署的，必 然会存在跨域问题。
 * 怎么解决跨域？很简单，只需要在controller类上添加注解 @CrossOrigin 即可！这个注解其实是CORS的实现。
 * CORS(Cross-Origin Resource Sharing, 跨源资源共享)是W3C出的一个标准，
 * 其思想是使用自定义的HTTP头部让浏览器与服务器进行沟通，从而决定请求或响应是应该成 功，还是应该失败。
 * 因此，要想实现CORS进行跨域，需要服务器进行一些设置，同时前端也需要做一些配置和分析
 */
@RestController
@RequestMapping("/label")
@CrossOrigin    //跨域，支持微服务之间跨平台访问
public class LabelController {

    @Autowired
    private LabelService labelService;
    @Autowired
    private IdWorker idWorker;

    /**
     * 查询全部列表
     *
     * @return Result<List>
     */
    @RequestMapping(method = RequestMethod.GET)
    public Result<List> findAllLabels() {
        List<Label> labels = labelService.findAll();
        return new Result<>(true, StatusCode.OK, "查询成功", labels);
    }

    /**
     * 根据ID查询标签
     *
     * @param id
     * @return Result<Label>
     */
    @GetMapping(value = "/{labelId}")
    public Result<Label> findLabelById(@PathVariable("labelId") String id) {
        int i = 1/0;
        Label label = labelService.findById(id);
        return new Result<>(true, StatusCode.OK, "查询成功", label);
    }

    /**
     * 添加标签
     * @param label
     * @return Result
     */
    @PostMapping()
    public Result addLabel(@RequestBody Label label) {
        labelService.add(label);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    /**
     * 修改标签
     * @param id
     * @param label
     * @return Result
     */
    @PutMapping(value = "/{id}")
    public Result updateLabel(@PathVariable String id,@RequestBody Label label){
        label.setId(id);
        labelService.update(label);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    /**
     * 删除标签
     * @param id
     * @return Result
     */
    @DeleteMapping(value = "/{id}")
    public Result deleteLabelById(@PathVariable String id){
        labelService.deleteById(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    /**
     * 多条件查询，根据条件查询标签
     * @param label
     * @return
     */
    @PostMapping(value = "/search")
    public Result findBySearch(@RequestBody Label label){
        List<Label> labelList = labelService.findBySearch(label);
        return new Result(true, StatusCode.OK, "查询成功",labelList);
    }

    /**
     *  分页条件查询
     * @param label
     * @param page 页码
     * @param size 页大小
     * @return Result
     */
    @PostMapping(value = "/search/{page}/{size}")
    public Result pageQuery(@RequestBody Label label, @PathVariable int page, @PathVariable int size){
        Page<Label> pageData = labelService.pageQuery(label, page, size);
        return new Result(true, StatusCode.OK, "查询成功", new PageResult<Label>(pageData.getTotalElements(), pageData.getContent()));
    }
}
