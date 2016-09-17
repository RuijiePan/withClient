package auto.newsky.coding.serviceImpl;

import auto.newsky.coding.mapper.InvatationMapper;
import auto.newsky.coding.service.IInvitation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/9/16.
 */
@Service
public class InvitationImpl implements IInvitation{
    @Autowired
    private InvatationMapper invatationMapper;
}
