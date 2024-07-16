package com.github.xfalcon.vhosts;

import com.github.xfalcon.vhosts.util.DESUtils;
import com.github.xfalcon.vhosts.util.LogUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fi.iki.elonen.NanoHTTPD;


class AppConfigs implements Serializable {
    @SerializedName("body")
    public BodyDTO body;
    @SerializedName("code")
    public Integer code;
    @SerializedName("returnTime")
    public Long returnTime;
    @SerializedName("success")
    public Boolean success;

    public static class BodyDTO implements Serializable {
        @SerializedName("createTime")
        public Integer createTime;
        @SerializedName("flavor")
        public String flavor;
        @SerializedName("isAllowRun")
        public Integer isAllowRun;
        @SerializedName("isAvailable")
        public Integer isAvailable;
        @SerializedName("language")
        public String language;
        @SerializedName("notice")
        public String notice;
        @SerializedName("updateTime")
        public Integer updateTime;
        @SerializedName("disabledFuncs")
        public List<String> disabledFuncs;
        @SerializedName("disabledInfos")
        public List<String> disabledInfos;
    }
}

class ApkUpdate implements Serializable {
    @SerializedName("code")
    public Integer code;
    @SerializedName("message")
    public String message;
    @SerializedName("returnTime")
    public Long returnTime;
    @SerializedName("success")
    public Boolean success;
}

class UserGet implements Serializable {

    @SerializedName("body")
    public BodyDTO body;
    @SerializedName("code")
    public Integer code;
    @SerializedName("returnTime")
    public Long returnTime;
    @SerializedName("success")
    public Boolean success;

    public static class BodyDTO implements Serializable {
        @SerializedName("createTime")
        public Long createTime;
        @SerializedName("key")
        public String key;
        @SerializedName("loginName")
        public String loginName;
        @SerializedName("loginType")
        public String loginType;
        @SerializedName("proindate")
        public Long proindate;
        @SerializedName("regtime")
        public Long regtime;
        @SerializedName("token")
        public String token;
        @SerializedName("type")
        public Integer type;
        @SerializedName("updateTime")
        public Integer updateTime;
    }
}

class RenewalGoodsList implements Serializable {

    @SerializedName("code")
    public Integer code;
    @SerializedName("returnTime")
    public Long returnTime;
    @SerializedName("success")
    public Boolean success;
    @SerializedName("body")
    public List<BodyDTO> body;

    public static class BodyDTO implements Serializable {
        @SerializedName("createTime")
        public Integer createTime;
        @SerializedName("id")
        public String id;
        @SerializedName("isAvailable")
        public Integer isAvailable;
        @SerializedName("locale")
        public String locale;
        @SerializedName("name")
        public String name;
        @SerializedName("price")
        public Integer price;
        @SerializedName("priceUnit")
        public String priceUnit;
        @SerializedName("updateTime")
        public Integer updateTime;
        @SerializedName("value")
        public Integer value;
        @SerializedName("weight")
        public Integer weight;
        @SerializedName("description")
        public String description;
        @SerializedName("originalPrice")
        public Integer originalPrice;
        @SerializedName("recommend")
        public String recommend;
    }
}

public class HttpService extends NanoHTTPD{
    private static final String URI_getAppConfigs = "/FakeLocation/app/getAppConfigs";
    private static final String URI_checkApkUpdate = "/FakeLocation/version/checkApkUpdate";
    private static final String URI_userGet = "/FakeLocation/user/get";
    private static final String URI_getRenewalGoodsList = "/FakeLocation/goods/getRenewalGoodsList";

    public static final String DES_SECRET_KEY = "Lerist.T";
    public static final Long proindate = 1943280000000L;
    public static final Long regtime = 1577808000000L;
    public static final String loginName = "+86-11451419197";
    private final static String TRANSFORMATION = "DES/ECB/PKCS5Padding";

    public HttpService(int port){
        super(port);
    }

    public Response on_getAppConfigs(){
        //初始化gson
        GsonBuilder builder = new GsonBuilder();
        builder.serializeNulls();
        Gson gson = builder.create();
        //获取时间戳
        Long timestamp = System.currentTimeMillis();
        //设置返回值
        AppConfigs appconfigs = new AppConfigs();
        appconfigs.code = 200;
        appconfigs.returnTime = timestamp;
        appconfigs.success = true;
        appconfigs.body = new AppConfigs.BodyDTO();
        appconfigs.body.createTime = 0;
        appconfigs.body.disabledFuncs = new ArrayList<>();
        appconfigs.body.disabledInfos = new ArrayList<>();
        appconfigs.body.disabledInfos.add("bootads");
        appconfigs.body.disabledInfos.add("donate");
        appconfigs.body.flavor = "CN";
        appconfigs.body.isAllowRun = 1;
        appconfigs.body.isAvailable = 1;
        appconfigs.body.language = "*;";
        appconfigs.body.notice = "";
        appconfigs.body.updateTime = 0;
        String jsonString = gson.toJson(appconfigs);
        return NanoHTTPD.newFixedLengthResponse(Response.Status.OK, "application/json", jsonString);
    }
    public Response on_checkApkUpdate(){
        //初始化gson
        GsonBuilder builder = new GsonBuilder();
        builder.serializeNulls();
        Gson gson = builder.create();
        //获取时间戳
        Long timestamp = System.currentTimeMillis();
        //设置返回值
        ApkUpdate apkupdate = new ApkUpdate();
        apkupdate.code = 2002;
        apkupdate.message = "??????";
        apkupdate.returnTime = timestamp;
        apkupdate.success = false;
        String jsonString = gson.toJson(apkupdate);
        return NanoHTTPD.newFixedLengthResponse(Response.Status.OK, "application/json", jsonString);
    }
    public Response on_userGet(JSONObject body) throws JSONException {
        //初始化gson
        GsonBuilder builder = new GsonBuilder();
        builder.serializeNulls();
        Gson gson = builder.create();
        //获取时间戳
        Long timestamp = System.currentTimeMillis();
        //设置返回值
        String token = body.getString("token");
        UserGet userget = new UserGet();
        userget.code = 200;
        userget.returnTime = timestamp;
        userget.success = true;
        userget.body = new UserGet.BodyDTO();
        userget.body.createTime = regtime;
        userget.body.loginName = loginName;
        userget.body.loginType = "phone";
        userget.body.proindate = proindate;
        userget.body.regtime = regtime;
        userget.body.updateTime = 0;
        userget.body.type = 1;
        StringBuilder s = new StringBuilder();
        s.append("1#").append(proindate).append("#").append(timestamp+400000000).append("#").append(token);
        try {
            DESUtils desutils = new DESUtils();
            userget.body.key = desutils.getDES(s.toString());
            LogUtils.e("des", desutils.getDES(s.toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        userget.body.token = token;
        String jsonString = gson.toJson(userget);
        return NanoHTTPD.newFixedLengthResponse(Response.Status.OK, "application/json", jsonString);
    }
    public Response on_getRenewalGoodsList(){
        //初始化gson
        GsonBuilder builder = new GsonBuilder();
        builder.serializeNulls();
        Gson gson = builder.create();
        //获取时间戳
        Long timestamp = System.currentTimeMillis();
        //设置返回值
        RenewalGoodsList renewalgoodslist = new RenewalGoodsList();
        renewalgoodslist.code = 200;
        renewalgoodslist.returnTime = timestamp;
        renewalgoodslist.success = true;
        renewalgoodslist.body = new ArrayList<RenewalGoodsList.BodyDTO>();
        RenewalGoodsList.BodyDTO good = new RenewalGoodsList.BodyDTO();
        good.createTime = 0;
        good.id = "0011";
        good.isAvailable = 1;
        good.locale = "CN";
        good.name = "never wanna let you go";
        good.price = 0;
        good.priceUnit = "¥";
        good.updateTime = 0;
        good.value = 30;
        good.weight = 4;
        renewalgoodslist.body.add(good);
        String jsonString = gson.toJson(renewalgoodslist);
        return NanoHTTPD.newFixedLengthResponse(Response.Status.OK, "application/json", jsonString);
    }
    @Override
    public Response serve(IHTTPSession session) {
        String uri = session.getUri();
        if(uri.equals(URI_getAppConfigs)){
            return on_getAppConfigs();
        }
        else if(uri.equals(URI_checkApkUpdate)){
            return on_checkApkUpdate();
        }
        else if(uri.equals(URI_userGet)){
            Map<String, String> data = new HashMap<String, String>();
            try {
                session.parseBody(data);
            } catch (Exception e) {
                e.printStackTrace();
            }
            String body=data.get("postData");
            LogUtils.d("body", body);
            try {
                JSONObject json = new JSONObject(body);
                return on_userGet(json);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        else if(uri.equals(URI_getRenewalGoodsList)){
            return on_getRenewalGoodsList();
        }
        return NanoHTTPD.newFixedLengthResponse(uri);
    }
}
