package com.tensquare.base.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by CuiJie on 2018/12/13.
 *
 * 标签实体类,该类必须实现Serializable接口，
 * 分布式必须实现Serializable，只有加了序列化的实体才能在不同平台之间使用IO流进行传输
 */
@Entity
@Table(name = "tb_label")
public class Label implements Serializable{

    private static final long serialVersionUID = -3971839089405054409L;

    @Id
    private String id; //标签ID
    private String labelname;   //标签名称
    private String state;   //状态 0：无效  1：有效
    private Long count;     //使用数量
    private String recommend;   //是否推荐 0：不推荐 1:推荐
    private Long fans;  //粉丝数

    public Label() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabelname() {
        return labelname;
    }

    public void setLabelname(String labelname) {
        this.labelname = labelname;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    public Long getFans() {
        return fans;
    }

    public void setFans(Long fans) {
        this.fans = fans;
    }
}
