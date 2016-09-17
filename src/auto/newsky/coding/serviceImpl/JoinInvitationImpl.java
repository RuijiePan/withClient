package auto.newsky.coding.serviceImpl;

import auto.newsky.coding.mapper.UserJoinInvitationMapper;
import auto.newsky.coding.service.IJoinInvitation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/9/16.
 */
@Service
public class JoinInvitationImpl implements IJoinInvitation{
    @Autowired
    private UserJoinInvitationMapper userJoinInvatationMapper;
}
