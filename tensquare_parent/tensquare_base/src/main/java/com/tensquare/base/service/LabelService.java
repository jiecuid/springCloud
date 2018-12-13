package com.tensquare.base.service;

import com.tensquare.base.dao.LabelDao;
import com.tensquare.base.pojo.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by CuiJie on 2018/12/13.
 * <p>
 * 标签业务逻辑类：实现基本的CRUD功能
 */
@Service
@Transactional
public class LabelService {

    @Autowired
    private LabelDao labelDao;
    @Autowired
    private IdWorker idWorker;

    /**
     * 查询标签列表
     *
     * @return
     */
    public List<Label> findAll() {
        return labelDao.findAll();
    }

    /**
     * 根据id查询标签
     *
     * @param id
     * @return Label
     */
    public Label findById(String id) {

        return labelDao.findById(id).get();
    }

    /**
     * 增加标签
     *
     * @param label
     */
    public void add(Label label) {
        label.setId(idWorker.nextId() + "");//设置id
        labelDao.save(label);
    }

    /**
     * 根据id删除标签
     *
     * @param id
     */
    public void deleteById(String id) {
        labelDao.deleteById(id);
    }

    /**
     * 修改标签
     *
     * @param label
     */
    public void update(Label label) {
        labelDao.save(label);
    }


    public List<Label> findBySearch(Label label) {
        return labelDao.findAll(new Specification<Label>() {
            /**
             * @param root            根对象，也就是要把条件封装到那个对象中。比如当前是把查询条件封装到 Label对象中 ，where 类名 = label.getId
             * @param query           封装的都是查询关键字，比如 group by ,order by 等
             * @param criteriaBuilder 用来封装条件对象的，如果直接返回null表示不需要任何条件
             * @return
             */
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                //Searchlist用来存放所有的查询条件
                List<Predicate> searchList = new ArrayList<>();
                //根据labelName模糊查询
                if (null != label.getLabelname() && !"".equals(label.getLabelname())) {
                    Predicate predicate = criteriaBuilder.like(root.get("labelname").as(String.class), "%" + label.getLabelname() + "%");//where labelName like %label.getLabelname()%
                    searchList.add(predicate);
                }
                //根据state查询标签
                if (null != label.getState() && !"".equals(label.getState())) {
                    Predicate predicate = criteriaBuilder.equal(root.get("state").as(String.class), label.getState());//state = ?
                    searchList.add(predicate);
                }

                //new一个数组作为最终的返回条件
                Predicate[] parr = new Predicate[searchList.size()];
                //把searchList转成数组
                searchList.toArray(parr);
                return criteriaBuilder.and(parr); // where labelName like %label.getLabelname()% and state = ?
            }
        });

    }

    public Page<Label> pageQuery(Label label, int page, int size) {
        Pageable pageable = PageRequest.of(page-1, size);
        return labelDao.findAll(new Specification<Label>() {
            /**
             * @param root            根对象，也就是要把条件封装到那个对象中。比如当前是把查询条件封装到 Label对象中 ，where 类名 = label.getId
             * @param query           封装的都是查询关键字，比如 group by ,order by 等
             * @param criteriaBuilder 用来封装条件对象的，如果直接返回null表示不需要任何条件
             * @return
             */
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                //Searchlist用来存放所有的查询条件
                List<Predicate> searchList = new ArrayList<>();
                //根据labelName模糊查询
                if (null != label.getLabelname() && !"".equals(label.getLabelname())) {
                    Predicate predicate = criteriaBuilder.like(root.get("labelname").as(String.class), "%" + label.getLabelname() + "%");//where labelName like %label.getLabelname()%
                    searchList.add(predicate);
                }
                //根据state查询标签
                if (null != label.getState() && !"".equals(label.getState())) {
                    Predicate predicate = criteriaBuilder.equal(root.get("state").as(String.class), label.getState());//state = ?
                    searchList.add(predicate);
                }

                //new一个数组作为最终的返回条件
                Predicate[] parr = new Predicate[searchList.size()];
                //把searchList转成数组
                searchList.toArray(parr);
                return criteriaBuilder.and(parr); // where labelName like %label.getLabelname()% and state = ?
            }
        },pageable);

    }
}
