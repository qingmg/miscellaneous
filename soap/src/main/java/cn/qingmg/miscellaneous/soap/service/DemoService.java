package cn.qingmg.miscellaneous.soap.service;

import cn.qingmg.miscellaneous.common.entity.HttpResult;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(
        targetNamespace = "http://soap.miscellaneous.qingmg.cn"
)
public interface DemoService {

    /**
     * 测试
     *
     * @return
     */
    @WebMethod
    String test();

    /**
     * 测试参数
     *
     * @param str str
     * @return
     */
    @WebMethod
    String testStr(@WebParam(name = "str") String str);

}
