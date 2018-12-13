package entity;

/**
 * Created by CuiJie on 2018/12/1.
 * 返回结果实体类
 */

public class Result<T> {

    //是否成功
    private boolean flag;
    //返回码
    private Integer code;
    //返回信息
    private String message;
    //返回数据
    private Object data;

    public Result() {
    }

    //适用于增删改
    public Result(boolean flag, Integer code, String message) {
        this.flag = flag;
        this.code = code;
        this.message = message;
    }

    //适用于查询
    public Result(boolean flag, Integer code, String message, Object data) {
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
