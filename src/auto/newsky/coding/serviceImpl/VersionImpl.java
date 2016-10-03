package auto.newsky.coding.serviceImpl;

import auto.newsky.coding.mapper.VersionMapper;
import auto.newsky.coding.po.Version;
import auto.newsky.coding.po.VersionExample;
import auto.newsky.coding.response.Result;
import auto.newsky.coding.service.IVersion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/10/3.
 */
@Service("versionService")
public class VersionImpl implements IVersion {

    @Autowired
    private VersionMapper versionMapper;

    @Override
    public Result getUpdateInfo() {
        VersionExample example = new VersionExample();
        example.createCriteria().andVersionIdGreaterThanOrEqualTo(1);
        List<Version> list = versionMapper.selectByExample(example);

        Result result = new Result();
        if (list==null||list.size()<=0){
            result.setCode(459);
            result.setMsg("版本信息未找到");
            return result;
        }

        result.setData(list.get(list.size()-1));
        return result;
    }
}
