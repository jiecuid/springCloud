package com.tensquare.recruit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.tensquare.recruit.pojo.Recruit;

import java.util.List;

/**
 * 招聘数据访问接口
 * @author Administrator
 *
 */
public interface RecruitDao extends JpaRepository<Recruit,String>,JpaSpecificationExecutor<Recruit>{

    /**
     * 查询最新推荐职位列表（按创建日期降序）
     * 需求分析：查询状态为 2, 并以创建日期降序排序(最新的在最上面)，查询前6条记录
     * @param state
     * @return
     */
    List<Recruit> findTop6ByStateOrderByCreatetimeDesc(String state);//where state = ? order by createtime desc

    /**
     * 查询最新职位列表
     *
     * 需求分析：查询状态不为 0, 并以创建日期降序排序，查询前12条记录
     * @param state
     * @return
     */
    List<Recruit> findTop12ByStateNotOrderByCreatetimeDesc(String state);//where state != ? order by createtime desc


}
