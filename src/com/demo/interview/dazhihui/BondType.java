//// ����ʹ�ù���ģʽ��ʵ������ͬ���͵�ծȯչʾ�࣬�������������Ҳ������չ
//
//// ծȯ����ö��
//public enum BondType {
//    ORDINARY,
//    CITY,
//    CONVERT,
//    DEFAULT
//}
//
//// ծȯչʾ�ӿ�
//public interface BondDisplay {
//    void displayInfo(BondCardBean bondCard);
//}
//
//// һ��ծչʾ��
//public class OrdinaryBondDisplay implements BondDisplay {
//    @Override
//    public void displayInfo(BondCardBean bondCard) {
//        // ����һ��ծ���ֶ�չʾ�߼�
//    }
//}
//
//// ��Ͷծչʾ��
//public class CityBondDisplay implements BondDisplay {
//    @Override
//    public void displayInfo(BondCardBean bondCard) {
//        // �����Ͷծ���ֶ�չʾ�߼�
//    }
//}
//
//// ��תծչʾ��
//public class ConvertBondDisplay implements BondDisplay {
//    @Override
//    public void displayInfo(BondCardBean bondCard) {
//        // �����תծ���ֶ�չʾ�߼�
//    }
//}
//
//// Ĭ��չʾ��
//public class DefaultBondDisplay implements BondDisplay {
//    @Override
//    public void displayInfo(BondCardBean bondCard) {
//        // ����Ĭ�ϵ��ֶ�չʾ�߼�
//    }
//}
//
//// ծȯչʾ����
//public class BondDisplayFactory {
//    public static BondDisplay createBondDisplay(BondType bondType) {
//        switch (bondType) {
//            case ORDINARY:
//                return new OrdinaryBondDisplay();
//            case CITY:
//                return new CityBondDisplay();
//            case CONVERT:
//                return new ConvertBondDisplay();
//            default:
//                return new DefaultBondDisplay();
//        }
//    }
//}
//
//// BondCardBean��
//public class BondCardBean {
//    private String type;
//    private List<CardField> fields;
//
//    public String getType() {
//        return type;
//    }
//
//    public void processCardData() {
//        BondType bondType = BondType.valueOf(type.toUpperCase());
//        BondDisplay bondDisplay = BondDisplayFactory.createBondDisplay(bondType);
//        bondDisplay.displayInfo(this);
//    }
//}
