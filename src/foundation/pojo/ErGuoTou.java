package foundation.pojo;

/**
 * @author: wangbo82
 * @Date: 2022��05��20�� 18:25
 * ����ͷ����
 */
public class ErGuoTou implements SellWine {
    @Override
    public int sell(int amount) {
        return amount * 100;
    }
}
