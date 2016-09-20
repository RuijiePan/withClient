package auto.newsky.coding.serviceImpl;

import auto.newsky.coding.mapper.InvitationMapper;
import auto.newsky.coding.mapper.MessageMapper;
import auto.newsky.coding.mapper.UserMapper;
import auto.newsky.coding.po.*;
import auto.newsky.coding.response.Result;
import auto.newsky.coding.resultdata.MessageListData;
import auto.newsky.coding.service.IMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    @Autowired
    private InvitationMapper invitationMapper;

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
        List<Message> list = messageMapper.selectByIdAndLimit(userId,lastMessageId,limit);

        List<MessageListData.DataBean> datalist = new ArrayList<MessageListData.DataBean>();

        for (int i = 0; i < list.size() ; i++) {

            Message message = list.get(i);
            User applyUser = userMapper.selectByPrimaryKey(message.getFromUserId());
            Invitation invitation = invitationMapper.selectByPrimaryKey(message.getInvitId());

            MessageListData.DataBean dataBean = new MessageListData.DataBean(
                    message.getMsgIsRead(),message.getInvitId(),invitation.getInvitNumberMax(),
                    invitation.getInvitActivityTime().toString(),invitation.getInvitPublicationTime().toString(),
                    invitation.getInvitNumberCurr(),message.getMsgType(),message.getMsgContent(),
                    message.getFromUserId(),invitation.getInvitTitle(),applyUser.getUserRealname(),
                    applyUser.getUserHeadurl(),message.getMsgId(),invitation.getInvitPlace());

            datalist.add(dataBean);
        }
        result.setData(datalist);
        return result;

        /*boolean readed, int invationId, int invitationTotalNumber,
        String invitationTime, String sendTime, int invitationCurrNumber,
        int messageType, String content, int applyUserId,
        String invitationTitle, String name, String headUrl,
        int messageId, String invitationPlace*/
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
