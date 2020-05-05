package cn.chuxiao.designprinciple.lsp.example1;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.HttpClient;


public class SecurityTransporterV2 extends Transporter {

    private String appId;
    private String appToken;

    public SecurityTransporterV2(HttpClient httpClient, String appId, String appToken) {
        super(httpClient);
        this.appId = appId;
        this.appToken = appToken;
    }

    @Override
    public void sendRequest(Request request) {

        if (StringUtils.isNoneBlank(appId) || StringUtils.isNoneBlank(appToken)) {
            throw new NoAuthorizationRuntimeException("appid and apptoken not allow empty.");
        }
        request.addPayload("app-id", appId);
        request.addPayload("app-token", appToken);
        super.sendRequest(request);
    }
}
