package foundation.pojo;

/**
 * @author: wangbo82
 * @Date: 2022��05��20�� 18:26
 * ����Һ����
 */
public class WuLiangYe implements SellWine {
    @Override
    public int sell(int amount) {
        return amount * 1500;
    }
}
