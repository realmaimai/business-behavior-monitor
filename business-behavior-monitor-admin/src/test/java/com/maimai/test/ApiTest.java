package com.maimai.test;

import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;
import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;
import org.junit.jupiter.api.Test;

@Slf4j
public class ApiTest {
    @Test
    public void testOgnl() throws OgnlException {
        String jsonString = "{\"attributeField\":\"userId\",\"attributeName\":\"用户ID\",\"attributeValue\":\"xiaofuge\",\"clazzName\":\"cn.bugstack.domain.activity.service.partake.AbstractRaffleActivityPartake\",\"createTime\":1717952224000,\"id\":19,\"methodName\":\"createOrder\",\"monitorId\":\"129101\",\"monitorName\":\"大营销抽奖流程\",\"monitorNodeId\":\"10011\",\"systemName\":\"big-market\",\"updateTime\":1717952224000}";
        JSONObject jsonObject = JSONObject.parseObject(jsonString);

        OgnlContext ognlContext = new OgnlContext();
        ognlContext.setRoot(jsonObject);

        Object root = ognlContext.getRoot();
        log.info((String)Ognl.getValue("attributeField", ognlContext, root));
        log.info((String)Ognl.getValue("attributeName", ognlContext, root));
        System.out.println((String)Ognl.getValue("attributeName", ognlContext, root));
    }
}
