package cn.qingmg.miscellaneous.soap.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import java.net.URL;
import java.util.HashMap;

/**
 * @Description TODO
 * @Author vhs
 * @Date 2018/11/9 15:18
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class TestSoap {

    @Test
    public void test() {
        String opDetail = JSON.toJSONString(new HashMap<String, String>() {{
            put("str", "string");

//            put("param1", 1);
//            put("param2", 2);
//            put("param3", 3);
        }});
        String xmlns = "http://soap.miscellaneous.qingmg.cn";
        String url = "http://192.168.1.123:8080/webservice/demo/DemoService?wsdl";
        String method = "testStr";
        JSONObject json = new JSONObject();

        try {
            Service service = new Service();
            Call call = (Call) service.createCall();
//            call.setTimeout(3000);
            call.setOperationName(new QName(xmlns, method));
            call.setTargetEndpointAddress(String.valueOf(new URL(url)));
            call.setReturnType(XMLType.XSD_STRING);

            // 无参
//            Object object = call.invoke(new Object[]{null});

            // 有参 -- String
            call.addParameter("str", XMLType.XSD_STRING, ParameterMode.IN);
            Object object = call.invoke(new Object[]{opDetail});

            if (object != null) {
                System.out.println(object);
            }
        } catch (Exception e) {
            e.printStackTrace();
            json.put("serviceFlag", "FALSE");
        }
    }

    @Test
    public void test2() {
        try {
            JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
            org.apache.cxf.endpoint.Client client = dcf.createClient("http://192.168.1.123:8080/webservice/demo/DemoService?wsdl");
            Object[] objects = client.invoke("test");
            for (Object object : objects) {
                System.out.println(object);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
