//package foundation.summary;
//
///**
// * @author: wangbo82
// * @Date: 2021年08月17日 16:55
// */
//public class JsonDemo {
//    public static void main(String[] args) {
////        JSON.p
//        JSONObject resultJson = new JSONObject(); //JSONObject是对象形式
//        resultJson.put("opter", "李世耀");
//        resultJson.put("optins", "延安市宝塔区医疗保障局");
//        resultJson.put("title", "2021年延安市");
//        resultJson.put("ym", "202108");
//        resultJson.put("optTime", "2021-08-17");
//
//        JSONArray jsonArray = new JSONArray();    //JSONArray是数组形式
//        JSONObject scoreObject2 = new JSONObject();
//        scoreObject2.put("xh", 1);
//        scoreObject2.put("certno", "61060219881205182X");
//        scoreObject2.put("psnCertType", "居民身份证（户口簿）");
//        scoreObject2.put("acctRetnAmt", 500);
//        scoreObject2.put("psnName", "刘楠");
//        scoreObject2.put("empName", "宝塔区社区建设委员会办公室");
//        jsonArray.add(scoreObject2);
//        resultJson.put("clrProcList", jsonArray);
//
//        JSONArray clrProcList = (JSONArray) resultJson.get("clrProcList");
//        JSONObject jsonO = (JSONObject) clrProcList.get(0);
//        String certno = (String) jsonO.get("certno");
//        System.out.println("certno.length() = " + certno.length());
//        System.out.println();
//    }
//}
