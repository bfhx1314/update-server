package com.limn.update.server.common;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;


/**
 * Created by limengnan on 2017/11/3.
 */
public class BaseHttpConnection {

    public static void main(String[] args) throws IOException {
//        String latitude = "30.0312";
//        String longitude = "121.68608";
//        String limit = "24";
//        String offset = "0";
//        String shopList = BaseHttpConnection.doGetSSL("https://www.ele.me/restapi/shopping/restaurants?extras[]=activities&geohash=wtw3s78hjff&latitude=" + latitude+ "&limit=" + limit + "&longitude=" + longitude + "&offset=" + offset + "&terminal=web");
//        System.out.println(shopList);
//        JSONObject jsonObject = (JSONObject)JSONArray.fromObject(shopList).get(0);
//        EleShopBean a = (EleShopBean)JSONObject.toBean(jsonObject,EleShopBean.class);
//
//        String menu = BaseHttpConnection.doGetSSL("https://www.ele.me/restapi/shopping/v2/menu?restaurant_id=475763");
//        EleMenuBean b = (EleMenuBean) JSONObject.toBean((JSONObject)JSONArray.fromObject(menu).get(0),EleMenuBean.class);
//
//        System.out.println(menu);

    }


    private static PoolingHttpClientConnectionManager connMgr;
    private static RequestConfig requestConfig;
    private static final int MAX_TIMEOUT = 7000;

    static {
        // 设置连接池
        connMgr = new PoolingHttpClientConnectionManager();
        // 设置连接池大小
        connMgr.setMaxTotal(100);
        connMgr.setDefaultMaxPerRoute(connMgr.getMaxTotal());

        RequestConfig.Builder configBuilder = RequestConfig.custom();
        // 设置连接超时
        configBuilder.setConnectTimeout(MAX_TIMEOUT);
        // 设置读取超时
        configBuilder.setSocketTimeout(MAX_TIMEOUT);
        // 设置从连接池获取连接实例的超时
        configBuilder.setConnectionRequestTimeout(MAX_TIMEOUT);
        requestConfig = configBuilder.build();
    }

    public static String doGetSSL(String apiUrl) {
        CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(createSSLConnSocketFactory()).setConnectionManager(connMgr).setDefaultRequestConfig(requestConfig).build();
        HttpGet httpget = new HttpGet(apiUrl);
        CloseableHttpResponse response = null;
        String httpStr = null;

        try {
            httpget.setConfig(requestConfig);

            httpget.addHeader("cookie","SID=BJtpinU4w9oHWRy1y8W9gXi64aJer5rzCrQg;USERID=1294125794;_utrace=498bbfca29f26bc475d6b6e6fefbbb8f_2017-10-30; firstEnterUrlInSession=https%3A//www.ele.me/shop/81782; perf_ssid=hfsxu21x43l3pzdw4wmi2w74tvxxtpba_2017-11-08; ubt_ssid=uifjmxnuc23j45zs2hcr1vdapuvmx_2017-10-30; pageReferrInSession=https%3A//www.ele.me/place/wtw3s7d3x6w%3Flatitude%3D31.22067%26longitude%3D121.47924");
            httpget.addHeader("accept","application/json, text/plain, */*");
            httpget.addHeader("accept-encoding","gzip, deflate, br");
            httpget.addHeader("accept-language","zh-CN,zh;q=0.9,en;q=0.8");
            httpget.addHeader("referer","https://www.ele.me/shop/475763");
            httpget.addHeader("accept","application/json, text/plain, */*");
            httpget.addHeader("user-agent","Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.75 Safari/537.36");
            httpget.addHeader("x-shard","shopid=475763;loc=121.44898,31.32054");
            response = httpClient.execute(httpget);

            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                return null;
            }
            HttpEntity entity = response.getEntity();
            if (entity == null) {
                return null;
            }
            httpStr = EntityUtils.toString(entity, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return httpStr;
    }

    /**
     * 创建SSL安全连接
     *
     * @return
     */
    private static SSLConnectionSocketFactory createSSLConnSocketFactory() {
        SSLConnectionSocketFactory sslsf = null;
        try {
            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {

                public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                    return true;
                }
            }).build();
            sslsf = new SSLConnectionSocketFactory(sslContext, new X509HostnameVerifier() {

                @Override
                public boolean verify(String arg0, SSLSession arg1) {
                    return true;
                }

                @Override
                public void verify(String host, SSLSocket ssl) throws IOException {
                }

                @Override
                public void verify(String host, X509Certificate cert) throws SSLException {
                }

                @Override
                public void verify(String host, String[] cns, String[] subjectAlts) throws SSLException {
                }
            });
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
        return sslsf;
    }
}
