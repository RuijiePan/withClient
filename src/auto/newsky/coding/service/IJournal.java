package auto.newsky.coding.service;


import auto.newsky.coding.po.Journal;
import auto.newsky.coding.response.Result;

/**
 * Created by Administrator on 2016/9/16.
 */
public interface IJournal {

    Result signIn(Integer userId,Integer taskId);

    Result editTaskMessage(Integer userId,Integer taskId,String date,String remark);
}
