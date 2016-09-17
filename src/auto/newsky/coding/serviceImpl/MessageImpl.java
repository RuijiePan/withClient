package auto.newsky.coding.serviceImpl;

import auto.newsky.coding.mapper.MessageMapper;
import auto.newsky.coding.service.IMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/9/16.
 */
@Service
public class MessageImpl  implements IMessage{
    @Autowired
    private MessageMapper messageMapper;
}
