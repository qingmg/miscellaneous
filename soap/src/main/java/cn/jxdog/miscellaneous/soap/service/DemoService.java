package cn.jxdog.miscellaneous.soap.service;

import cn.jxdog.miscellaneous.common.entity.HttpResult;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(
        targetNamespace = "http://soap.miscellaneous.jxdog.cn"
)
public interface DemoService {

    /**
     * 测试
     *
     * @return
     */
    @WebMethod()
    HttpResult test();

    /**
     * 测试参数
     *
     * @param str str
     * @return
     */
    @WebMethod
    HttpResult testStr(@WebParam(name = "str") String str);

}
