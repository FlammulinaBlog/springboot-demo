package org.spring.springboot.alibaba;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.request.TbkTpwdCreateRequest;
import com.taobao.api.response.TbkTpwdCreateResponse;
import org.junit.Test;

/**
 * @descriptions: 阿里妈妈
 * @author: HanYanBing
 * @date: 2021/1/20 18:12
 * @version: 1.0
 */
public class TaobaoClient {

    @Test
    public void init(){

        /**
         *
         * 您好，taobao.tbk.tpwd.create 目前支持的URL有以下4种（注意是https开头）：
         * "https://uland.taobao.com/"；
         * "https://s.click.taobao.com/"；
         * "https://temai.m.taobao.com/",
         * ；"https://ai.m.taobao.com/
         */

        // String url = "http://gw.api.taobao.com/router/rest" ;
        String url = "https://eco.taobao.com/router/rest" ;
        String appkey = "28243612" ;
        String secret = "c3da953e4cf632afceeeb8d298e430d5" ;
        extracted(url, appkey, secret);

    }

    private void extracted(String url, String appkey, String secret) {
        DefaultTaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
        TbkTpwdCreateRequest req = new TbkTpwdCreateRequest();
        // req.setUserId("123");
        req.setText("测试一下请看大屏幕");
        req.setUrl("https://s.click.taobao.com/");
        req.setLogo("https://s.click.taobao.com/");
        req.setExt("{}");
        TbkTpwdCreateResponse rsp = null;
        try {
            rsp = client.execute(req);
        } catch (ApiException e) {
            e.printStackTrace();
        }
        System.out.println(JSON.toJSONString(JSONObject.parseObject(rsp.getBody()), SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue));
    }



}
