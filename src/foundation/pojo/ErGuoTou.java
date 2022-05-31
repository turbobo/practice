package foundation.pojo;

/**
 * @author: wangbo82
 * @Date: 2022年05月20日 18:25
 * 二锅头厂家
 */
public class ErGuoTou implements SellWine {
    @Override
    public int sell(int amount) {
        return amount * 100;
    }
}
