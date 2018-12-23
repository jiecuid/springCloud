package com.tensquare.qa.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.tensquare.qa.pojo.Problem;
import org.springframework.data.jpa.repository.Query;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface ProblemDao extends JpaRepository<Problem,String>,JpaSpecificationExecutor<Problem>{

     /**
      * 根据标签ID查询最新问题列表
      *
      * 需求分析：最新回复的问题显示在上方， 按回复时间降序排序
      * @param labelId
      * @param pageable
      * @return
      */
     @Query(value = "SELECT * FROM tb_problem A, tb_pl B WHERE A.id = B.problemid AND B.labelid = ? ORDER BY replytime DESC ", nativeQuery = true)
     Page<Problem> findNewListByLabel(String labelId, Pageable pageable);


     /**
      * 根据标签ID查询最热问题列表
      *
      * 需求分析：按回复数降序排序
      * @param labelId
      * @param pageable
      * @return
      */
     @Query(value = "SELECT * FROM tb_problem A, tb_pl B WHERE A.id = B.problemid AND B.labelid = ? ORDER BY reply DESC ", nativeQuery = true)
     Page<Problem> findHotListByLabel(String labelId, Pageable pageable);

     /**
      * 根据标签ID查询等待问题列表
      * @param labelId
      * @param pageable
      * @return
      */
     @Query(value = "SELECT * FROM tb_problem A, tb_pl B WHERE A.id = B.problemid AND B.labelid = ? AND A.reply = 0 ORDER BY createtime DESC ", nativeQuery = true)
     Page<Problem> findWaitListByLabelId(String labelId, Pageable pageable);
	
}
