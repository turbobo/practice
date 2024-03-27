//// 考虑使用工厂模式来实例化不同类型的债券展示类，代码更加清晰，也易于扩展
//
//// 债券类型枚举
//public enum BondType {
//    ORDINARY,
//    CITY,
//    CONVERT,
//    DEFAULT
//}
//
//// 债券展示接口
//public interface BondDisplay {
//    void displayInfo(BondCardBean bondCard);
//}
//
//// 一般债展示类
//public class OrdinaryBondDisplay implements BondDisplay {
//    @Override
//    public void displayInfo(BondCardBean bondCard) {
//        // 处理一般债的字段展示逻辑
//    }
//}
//
//// 城投债展示类
//public class CityBondDisplay implements BondDisplay {
//    @Override
//    public void displayInfo(BondCardBean bondCard) {
//        // 处理城投债的字段展示逻辑
//    }
//}
//
//// 可转债展示类
//public class ConvertBondDisplay implements BondDisplay {
//    @Override
//    public void displayInfo(BondCardBean bondCard) {
//        // 处理可转债的字段展示逻辑
//    }
//}
//
//// 默认展示类
//public class DefaultBondDisplay implements BondDisplay {
//    @Override
//    public void displayInfo(BondCardBean bondCard) {
//        // 处理默认的字段展示逻辑
//    }
//}
//
//// 债券展示工厂
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
//// BondCardBean类
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
