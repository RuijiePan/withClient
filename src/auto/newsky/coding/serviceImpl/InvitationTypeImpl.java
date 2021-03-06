package auto.newsky.coding.serviceImpl;

import auto.newsky.coding.mapper.ConcernMapper;
import auto.newsky.coding.mapper.InvitationTypeMapper;
import auto.newsky.coding.po.InvitationType;
import auto.newsky.coding.service.IConcern;
import auto.newsky.coding.service.IInvitationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/9/16.
 */
@Service
public class InvitationTypeImpl implements IInvitationType {
    @Autowired
    private InvitationTypeMapper invitationTypeMapper;

    public int getParentType(int typeId){
        InvitationType invitationType = invitationTypeMapper.selectByPrimaryKey(typeId);
        return invitationType.getTypeParent();
    }

    public boolean isParentType(int typeId){
        InvitationType invitationType = invitationTypeMapper.selectByPrimaryKey(typeId);
        return invitationType.getTypeParent()==-1?true:false;//是-1.说明没有上级，就是父
    }
}
