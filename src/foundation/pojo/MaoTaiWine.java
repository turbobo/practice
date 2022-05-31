package foundation.pojo;

/**
 * @author: wangbo82
 * @Date: 2022年05月20日 18:11
 * 茅台酒厂家，并要实现卖白酒的接口
 */
public class MaoTaiWine implements SellWine {
    @Override
    public int sell(int amount) {
        return amount * 2000;
    }
}
