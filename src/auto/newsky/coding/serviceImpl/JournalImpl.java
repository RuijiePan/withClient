package auto.newsky.coding.serviceImpl;

import auto.newsky.coding.mapper.JournalMapper;
import auto.newsky.coding.po.Journal;
import auto.newsky.coding.response.Result;
import auto.newsky.coding.service.IJournal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/9/16.
 */
@Service
public class JournalImpl implements IJournal{

    @Autowired
    private JournalMapper journalMapper;

    @Override
    public Result signIn(Integer userId, Integer taskId) {

        return null;
    }

    @Override
    public Result editTaskMessage(Integer userId, Integer taskId, String date, String remark) {
        return null;
    }
}
