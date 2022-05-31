package foundation.pojo;

/**
 * @author: wangbo82
 * @Date: 2022年05月20日 18:26
 * 五粮液厂家
 */
public class WuLiangYe implements SellWine {
    @Override
    public int sell(int amount) {
        return amount * 1500;
    }
}
