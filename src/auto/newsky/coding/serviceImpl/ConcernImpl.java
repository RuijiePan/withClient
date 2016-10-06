package auto.newsky.coding.serviceImpl;

import auto.newsky.coding.mapper.ConcernMapper;
import auto.newsky.coding.po.Concern;
import auto.newsky.coding.po.ConcernExample;
import auto.newsky.coding.service.IConcern;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2016/9/16.
 */
@Service
public class ConcernImpl implements IConcern {

    @Autowired
    private ConcernMapper concernMapper;


    @Override
    @Transactional(propagation= Propagation.REQUIRED)
    public boolean isConcerned(Integer myUserId, Integer concernedUserId) {
        ConcernExample concernExample = new ConcernExample();
        concernExample.or().andConFromUserIdEqualTo(myUserId).andConToUserIdEqualTo(concernedUserId).andConIsConcernEqualTo(true);
        List<Concern> concerns = concernMapper.selectByExample(concernExample);
        if (concerns!= null &&concerns.size()>0){
            return true;
        }
        return false;
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED)
    public Concern getConcerneTrue(Integer myUserId, Integer concernedUserId) {
        List<Concern> concerns = concernMapper.getConcerneTrue(myUserId,concernedUserId);
        if (concerns!= null &&concerns.size()>0){
            return concerns.get(0);
        }
        return null;
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED)
    public boolean concerneUser(Concern concern) {
        System.out.println("========================"+concern.toString());
        ConcernExample concernExample = new ConcernExample();
        concernExample.or().andConIdEqualTo(concern.getConId());
        concern.setConIsConcern(true);
        if (concernMapper.updateByExampleSelective(concern,concernExample)>0){
            return true;
        }
        return false;
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED)
    public boolean cancelConcerneUser(Concern concern) {
        ConcernExample concernExample = new ConcernExample();
        concernExample.or().andConIdEqualTo(concern.getConId());
        concern.setConIsConcern(false);
        if (concernMapper.updateByExampleSelective(concern,concernExample)>0){
            return true;
        }
        return false;
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED)
    public Concern getConcerne(Integer myUserId, Integer concernedUserId) {
        ConcernExample concernExample = new ConcernExample();
        concernExample.or().andConFromUserIdEqualTo(myUserId).andConToUserIdEqualTo(concernedUserId);
        List<Concern> concerns = concernMapper.selectByExample(concernExample);
        if (concerns!= null &&concerns.size()>0){
            return concerns.get(0);
        }
        return null;
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED)
    public boolean insertConcern(Integer myUserId, Integer concernedUserId) {
        if(concernMapper.insert(new Concern(myUserId,concernedUserId,true))>0){
            return true;
        }
        return false;
    }


}
