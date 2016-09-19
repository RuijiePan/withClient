package auto.newsky.coding.serviceImpl;

import auto.newsky.coding.mapper.MessageMapper;
import auto.newsky.coding.mapper.UserMapper;
import auto.newsky.coding.po.Message;
import auto.newsky.coding.po.MessageExample;
import auto.newsky.coding.po.User;
import auto.newsky.coding.po.UserExample;
import auto.newsky.coding.response.Result;
import auto.newsky.coding.service.IMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/9/16.
 */
@Service("messageService")
public class MessageImpl  implements IMessage{

    @Autowired
    private MessageMapper messageMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public Result deleteMessage(Integer messageId) {

        Result result = new Result();
        result.setData(null);

        Message message = messageMapper.selectByPrimaryKey(messageId);
        if (message!=null) {
            message.setMsgIsDelete(true);
            if (messageMapper.updateByPrimaryKey(message)==0){
                result.setCode(411);
                result.setMsg("删除信息失败");
            }
        }else {
            result.setCode(412);
            result.setMsg("该信息不存在");
        }
        return result;
    }

    @Override
    public Result getMessages(Integer userId,Integer lastMessageId, Integer limit) {

        Result result = new Result();
        List<Message> list = this.getUserMessage(userId);
        return null;
    }

    @Override
    public List<Message> getUserMessage(Integer userId) {

        MessageExample messageExample = new MessageExample();
        messageExample.createCriteria().andToUserIdEqualTo(userId)
                .andMsgIsDeleteEqualTo(false);
                //.andMsgIsReadEqualTo(false);

        List<Message> list = messageMapper.selectByExample(messageExample);

        return list;
    }
}
