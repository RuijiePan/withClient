package auto.newsky.coding.serviceImpl;

import auto.newsky.coding.mapper.JournalMapper;
import auto.newsky.coding.po.Journal;
import auto.newsky.coding.po.JournalExample;
import auto.newsky.coding.response.Result;
import auto.newsky.coding.service.IJournal;
import auto.newsky.coding.util.DateUtil;
import auto.newsky.coding.util.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/9/16.
 */
@Service("journalService")
public class JournalImpl implements IJournal{

    @Autowired
    private JournalMapper journalMapper;

    @Override
    public Result signIn(Integer taskId) {

        Result result = new Result();
        Date date = DateUtil.getCurrentDate();
        System.out.print(DateUtil.getCurrentDate().toString());

        JournalExample journalExample = new JournalExample();
        journalExample.createCriteria().andJourDateEqualTo(date)
                .andTaskIdEqualTo(taskId)
                .andJourIsDeleteEqualTo(false);

        if (journalMapper.selectByExample(journalExample).size()==0) {
            Journal journal = new Journal(taskId, date, "", true, false);
            if (journalMapper.insert(journal) == 0) {
                result.setCode(416);
                result.setMsg("签到失败");
            }
        }else {
            result.setCode(417);
            result.setMsg("今天已签到");
        }
        return result;
    }

    @Override
    public Result editTaskMessage(Integer taskId, Date date, String remark) {

        Result result = new Result();

        JournalExample journalExample = new JournalExample();
        journalExample.createCriteria().andTaskIdEqualTo(taskId)
                .andJourDateEqualTo(date)
                .andJourIsDeleteEqualTo(false);

        //Journal journal = journalMapper.selectByExample(journalExample).get(0);
        if (journalMapper.selectByExample(journalExample).size()==0){
            Journal newJournal = new Journal(taskId, date,remark, false, false);
            if (journalMapper.insert(newJournal)==0){
                result.setCode(418);
                result.setMsg("打卡编辑失败");
            }
        }else {
            Journal journal = journalMapper.selectByExample(journalExample).get(0);
            journal.setJourSummary(remark);
            if (journalMapper.updateByPrimaryKey(journal)==0){
                result.setCode(418);
                result.setMsg("打卡编辑失败");
            }
        }
        return result;
    }
}
