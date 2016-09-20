package auto.newsky.coding.service;


import auto.newsky.coding.po.Journal;
import auto.newsky.coding.response.Result;

import java.util.Date;

/**
 * Created by Administrator on 2016/9/16.
 */
public interface IJournal {

    Result signIn(Integer taskId);

    Result editTaskMessage(Integer taskId,Date date,String remark);
}
