package cn.kimming.bookadmin;

import cn.kimming.bookadmin.util.Result;
import com.alibaba.fastjson.JSONObject;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * @Author: 刘铭轩KimmingLau
 * @Date: 2020-11-29 18:42
 */

public class HttpTest {
    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://localhost:8080/book/list")
                .build();

        Response response = client.newCall(request).execute();
        String resp = response.body().string();
        Result result = JSONObject.parseObject(resp, Result.class);
        String message = result.getMessage();
        System.out.println(message);
    }
}
