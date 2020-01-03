//package com.luziye.bootluanch;
//
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//public class JsonUtils {
//    public static void lowerJsonString(Object object) {
//        if (object instanceof JSONObject) {
//            JSONObject jsonObject = (JSONObject) object;
//            JSONObject tempJson = new JSONObject();
//            List<String> notLowerKey = new ArrayList<>();
//            for (Map.Entry<String, Object> entry : jsonObject.entrySet()) {
//                String key = entry.getKey();
//                Object value = entry.getValue();
//                if (!isLower(key)) {
//                    tempJson.put(key.toLowerCase(), value);
//                    lowerJsonString(value);
//                    notLowerKey.add(key);
//                }
//            }
//            for (Map.Entry<String, Object> entry : tempJson.entrySet()) {
//                jsonObject.put(entry.getKey(),entry.getValue());
//            }
//            for (int i=0;i<notLowerKey.size();i++){
//                jsonObject.remove(notLowerKey.get(i));
//            }
//        }
//        if (object instanceof JSONArray){
//            JSONArray jsonArray = (JSONArray) object;
//            for (Object o:jsonArray){
//                lowerJsonString(o);
//            }
//        }
//    }
//
//    public static boolean isLower(String str) {
//        for (int i = 0; i < str.length(); i++) {
//            char c = str.charAt(i);
//            if (Character.isLowerCase(c)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public static void main(String[] args) {
//        String aa="{\n" +
//                "    \"ABC\":\"Abdsada\",\n" +
//                "    \"DEF\":[\"AA\",\"BB\",\"CC\"],\n" +
//                "    \"GHI\":{\n" +
//                "        \"KK\":[\n" +
//                "            {\n" +
//                "                \"MM\":\"12313\",\n" +
//                "                \"AA\":\"xxq\",\n" +
//                "                \"NN\":null\n" +
//                "            }\n" +
//                "        ],\n" +
//                "        \"SS\":\"MM\",\n" +
//                "        \"VV\":true\n" +
//                "    },\n" +
//                "    \"WW\":[\n" +
//                "        {\n" +
//                "            \"AA\":123,\n" +
//                "            \"BB\":456\n" +
//                "        }\n" +
//                "\n" +
//                "    ]\n" +
//                "}";
//        JSONObject abc=JSONObject.parseObject(aa);
//        lowerJsonString(abc);
//        System.out.println(abc.toJSONString());
//    }
//}
