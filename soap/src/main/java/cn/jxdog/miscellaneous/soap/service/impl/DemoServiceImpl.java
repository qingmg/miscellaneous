package cn.jxdog.miscellaneous.soap.service.impl;

import cn.jxdog.miscellaneous.common.entity.HttpResult;
import cn.jxdog.miscellaneous.soap.service.DemoService;
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
        targetNamespace = "http://soap.miscellaneous.jxdog.cn",
        endpointInterface = "cn.jxdog.miscellaneous.soap.service.DemoService")
@Service("demoService")
public class DemoServiceImpl implements DemoService {

    @Override
    public HttpResult test() {
        return HttpResult.success("调用成功, Str = " + "");
    }

    @Override
    public HttpResult testStr(String str) {
        return HttpResult.error(400, str, "调用失败");
    }

}
