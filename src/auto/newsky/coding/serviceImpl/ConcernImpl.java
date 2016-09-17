package auto.newsky.coding.serviceImpl;

import auto.newsky.coding.mapper.ConcernMapper;
import auto.newsky.coding.po.Concern;
import auto.newsky.coding.service.IConcern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/9/16.
 */
@Service
public class ConcernImpl implements IConcern {

    @Autowired
    private ConcernMapper concernMapper;
}
