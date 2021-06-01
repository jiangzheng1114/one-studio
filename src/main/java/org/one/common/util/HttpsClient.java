package org.one.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import com.alibaba.fastjson.JSONObject;

/**
 * 请求微信平台及响应的客户端类
 *
 * <p>
 * 每一次请求即对应一个<tt>HttpsClient</tt>，
 * 每次登陆产生一个<tt>OAuth</tt>用户连接,使用<tt>OAuthToken</tt>
 * 可以不用重复向微信平台发送登陆请求，在没有过期时间内，可继续请求。</p>
 *
 * @author 杨启盛<qsyang@ansitech.com>
 * @since 0.0.1
 */
public class HttpsClient implements java.io.Serializable {

	private static final long serialVersionUID = -8940760791043998030L;
	
	private static final int OK = 200;  // OK: Success!
    private static final int ConnectionTimeout = 20000;
    private static final int ReadTimeout = 120000;
    private static final String DEFAULT_CHARSET = "UTF-8";
    private static final String _GET = "GET";
    private static final String _POST = "POST";
    
    public HttpsClient() {
    }

    /**
     * Post JSON数据
     *
     * 默认https方式
     *
     * @param url 提交地址
     * @param json JSON数据
     * @return 输出流对象
     * @throws Exception
     */
    public Response post(String url, JSONObject json) throws Exception {
        //将JSON数据转换为String字符串
        String jsonString = json == null ? null : json.toString();
        //提交数据
        return httpsRequest(url, _POST, jsonString, false, null, null, null);
    }

    /**
     * Get 请求
     *
     * 默认https方式
     *
     * @param url 请求地址
     * @return 输出流对象
     * @throws Exception
     */
    public Response get(String url) throws Exception {
        return httpsRequest(url, _GET, null, false, null, null, null);
    }

    /**
     * Post XML格式数据
     *
     * @param url 提交地址
     * @param xml XML数据
     * @return 输出流对象
     * @throws Exception
     */
    public Response postXml(String url, String xml) throws Exception {
        return httpsRequest(url, _POST, xml, false, null, null, null);
    }


    /**
     * Post XML格式数据
     *
     * @param url 提交地址
     * @param xml XML数据
     * @param partnerId 商户ID
     * @param certPath 证书地址
     * @param certSecret 证书密钥
     * @return 输出流对象
     * @throws Exception
     */
    public Response postXml(String url, String xml, String partnerId, String certPath, String certSecret) throws Exception {
        return httpsRequest(url, _POST, xml, true, partnerId, certPath, certSecret);
    }

    /**
     * 通过https协议请求url
     *
     * @param url 提交地址
     * @param method 提交方式
     * @param postData 提交数据
     * @return 响应流
     * @throws Exception
     */
    private Response httpsRequest(String url, String method, String postData, boolean needCert, String partnerId, String certPath, String certSecret) throws Exception
            {
        Response res = null;
        OutputStream output;
        HttpsURLConnection https;
        try {
            //创建https请求连接
            https = getHttpsURLConnection(url);
            //判断https是否为空，如果为空返回null响应
            if (https != null) {
                //设置Header信息，包括https证书
                setHttpsHeader(https, method, needCert, partnerId, certPath, certSecret);
                //判断是否需要提交数据
                if (method.equals(_POST) && null != postData) {
                    //讲参数转换为字节提交
                    byte[] bytes = postData.getBytes(DEFAULT_CHARSET);
                    //设置头信息
                    https.setRequestProperty("Content-Length", Integer.toString(bytes.length));
                    //开始连接
                    https.connect();
                    //获取返回信息
                    output = https.getOutputStream();
                    output.write(bytes);
                    output.flush();
                    output.close();
                } else {
                    //开始连接
                    https.connect();
                }
                //创建输出对象
                res = new Response(https);
                //获取响应代码
                if (res.getStatus() == OK) {
                    return res;
                }
            }
        } catch (NoSuchAlgorithmException ex) {
            throw new Exception(ex);
        } catch (KeyManagementException ex) {
            throw new Exception(ex);
        } catch (NoSuchProviderException ex) {
            throw new Exception(ex);
        } catch (IOException ex) {
            throw new Exception(ex);
        } catch (KeyStoreException ex) {
            throw new Exception(ex);
        } catch (CertificateException ex) {
            throw new Exception(ex);
        } catch (UnrecoverableKeyException ex) {
            throw new Exception(ex);
        }
        return res;
    }

    /**
     * 获取https请求连接
     *
     * @param url 连接地址
     * @return https连接对象
     * @throws IOException
     */
    private HttpsURLConnection getHttpsURLConnection(String url) throws IOException {
        URL urlGet = new URL(url);
        //创建https请求
        HttpsURLConnection httpsUrlConnection = (HttpsURLConnection) urlGet.openConnection();
        return httpsUrlConnection;
    }

    private void setHttpsHeader(HttpsURLConnection httpsUrlConnection, String method, boolean needCert, String partnerId, String certPath, String certSecret)
            throws NoSuchAlgorithmException, KeyManagementException, NoSuchProviderException,
            IOException, KeyStoreException, CertificateException, UnrecoverableKeyException {
        //不需要维修证书，则使用默认证书
        if (!needCert) {
            //创建https请求证书
            TrustManager[] tm = {new MyX509TrustManager()};
            //创建证书上下文对象
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            //初始化证书信息
            sslContext.init(null, tm, new java.security.SecureRandom());
            // 从上述SSLContext对象中得到SSLSocketFactory对象  
            SSLSocketFactory ssf = sslContext.getSocketFactory();
            //设置ssl证书
            httpsUrlConnection.setSSLSocketFactory(ssf);
        } else {
            //指定读取证书格式为PKCS12
            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            //读取本机存放的PKCS12证书文件
            FileInputStream instream = new FileInputStream(new File(certPath));
            try {
                //指定PKCS12的密码
                keyStore.load(instream, partnerId.toCharArray());
            } finally {
                instream.close();
            }
            KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
            kmf.init(keyStore, certSecret.toCharArray());
            //创建管理jks密钥库的x509密钥管理器，用来管理密钥，需要key的密码  
            SSLContext sslContext = SSLContext.getInstance("TLSv1");
            // 构造SSL环境，指定SSL版本为3.0，也可以使用TLSv1，但是SSLv3更加常用。  
            sslContext.init(kmf.getKeyManagers(), null, null);
            // 从上述SSLContext对象中得到SSLSocketFactory对象  
            SSLSocketFactory ssf = sslContext.getSocketFactory();
            //设置ssl证书
            httpsUrlConnection.setSSLSocketFactory(ssf);
        }
        //设置header信息
        httpsUrlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        //设置User-Agent信息
        httpsUrlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.146 Safari/537.36");
        //设置可接受信息
        httpsUrlConnection.setDoOutput(true);
        //设置可输入信息
        httpsUrlConnection.setDoInput(true);
        //设置请求方式
        httpsUrlConnection.setRequestMethod(method);
        //设置连接超时时间
        if (ConnectionTimeout > 0) {
            httpsUrlConnection.setConnectTimeout(ConnectionTimeout);
        } else {
            //默认10秒超时
            httpsUrlConnection.setConnectTimeout(10000);
        }
        //设置请求超时
        if (ReadTimeout > 0) {
            httpsUrlConnection.setReadTimeout(ReadTimeout);
        } else {
            //默认10秒超时
            httpsUrlConnection.setReadTimeout(10000);
        }
        //设置编码
        httpsUrlConnection.setRequestProperty("Charsert", "UTF-8");
    }

}
