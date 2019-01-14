package cn.qingmg.miscellaneous.soap.service.impl;

import cn.qingmg.miscellaneous.common.entity.HttpResult;
import cn.qingmg.miscellaneous.soap.service.DemoService;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

/**
 * @Description TODO
 * @Author vhs
 * @Date 2018/11/9 9:19
 * @Version 1.0
 */
@WebService(
        serviceName = "DemoService",
        targetNamespace = "http://soap.miscellaneous.qingmg.cn",
        endpointInterface = "cn.qingmg.miscellaneous.soap.service.DemoService")
@Service("demoService")
public class DemoServiceImpl implements DemoService {

    @Override
    public String test() {
        return JSON.toJSONString(HttpResult.success("调用成功, Str = " + ""));
    }

    @Override
    public String testStr(String str) {
        return JSON.toJSONString(HttpResult.error(400, (Object) str, "调用失败"));
    }

}
