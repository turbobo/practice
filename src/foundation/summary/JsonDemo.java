//package foundation.summary;
//
///**
// * @author: wangbo82
// * @Date: 2021��08��17�� 16:55
// */
//public class JsonDemo {
//    public static void main(String[] args) {
////        JSON.p
//        JSONObject resultJson = new JSONObject(); //JSONObject�Ƕ�����ʽ
//        resultJson.put("opter", "����ҫ");
//        resultJson.put("optins", "�Ӱ��б�����ҽ�Ʊ��Ͼ�");
//        resultJson.put("title", "2021���Ӱ���");
//        resultJson.put("ym", "202108");
//        resultJson.put("optTime", "2021-08-17");
//
//        JSONArray jsonArray = new JSONArray();    //JSONArray��������ʽ
//        JSONObject scoreObject2 = new JSONObject();
//        scoreObject2.put("xh", 1);
//        scoreObject2.put("certno", "61060219881205182X");
//        scoreObject2.put("psnCertType", "�������֤�����ڲ���");
//        scoreObject2.put("acctRetnAmt", 500);
//        scoreObject2.put("psnName", "���");
//        scoreObject2.put("empName", "��������������ίԱ��칫��");
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
