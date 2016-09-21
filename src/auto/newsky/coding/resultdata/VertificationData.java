package auto.newsky.coding.resultdata;

/**
 * Created by Administrator on 2016/9/21.
 */
public class VertificationData {
    DataBean data;


    public VertificationData() {

    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        String phone ;

        public DataBean() {

        }

        public DataBean(String phone) {
            this.phone = phone;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
    }
}
