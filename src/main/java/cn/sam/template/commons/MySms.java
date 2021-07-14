package cn.sam.template.commons;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

public class MySms {

    private final String accessKey;
    private final String accessSecret;
    private final String signName;
    private final String domain;

    public MySms(String accessKey, String accessSecret, String signName, String domain) {
        this.accessKey = accessKey;
        this.accessSecret = accessSecret;
        this.signName = signName;
        this.domain = domain;
    }

    public void send(String phone, String template, JSONObject params) throws ClientException {
        this.buildClient().getCommonResponse(this.buildRequest(phone, template, params));
    }

    private CommonRequest buildRequest(String phone, String template, JSONObject params) {
        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain(this.domain);
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        // todo change your region
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName", this.signName);
        request.putQueryParameter("TemplateCode", template);
        if (params != null) {
            request.putQueryParameter("TemplateParam", params.toJSONString());
        }
        return request;
    }

    private IAcsClient buildClient() {
        // todo change your region
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKey, accessSecret);
        return new DefaultAcsClient(profile);
    }

}
