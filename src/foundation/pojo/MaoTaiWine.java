package foundation.pojo;

/**
 * @author: wangbo82
 * @Date: 2022��05��20�� 18:11
 * ę́�Ƴ��ң���Ҫʵ�����׾ƵĽӿ�
 */
public class MaoTaiWine implements SellWine {
    @Override
    public int sell(int amount) {
        return amount * 2000;
    }
}
