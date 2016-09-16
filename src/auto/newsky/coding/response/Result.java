package auto.newsky.coding.response;

/**
 * Created by prj on 2016/9/16.
 */

import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
public class Result {

    private int code;
    private String msg;
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Result(Object data) {
        this.data = data;
        this.msg = "";
        this.code = 200;
    }
    public Result() {
        this.msg = "";
        this.code = 200;
    }
}
