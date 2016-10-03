package auto.newsky.coding.service;

import auto.newsky.coding.po.Message;
import auto.newsky.coding.response.Result;

import java.util.List;

/**
 * Created by Administrator on 2016/9/16.
 */
public interface IMessage {

    Result deleteMessage(Integer myUserId,Integer messageId);

    Result getMessages(Integer userId,Integer lastMessageId,Integer limit);

    List<Message> getUserMessage(Integer userId);


    int getUnreadNumber(Integer myUserId);

    Result readMessage(Integer myUserId, Integer messageId);
}
