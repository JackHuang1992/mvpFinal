package example.hspmvp.com.mvpfinal.base;


/**
 * author: 黄士鹏
 * created on: 2017/12/8 10:25
 * description: 所有view层都必须继承这个基类
 */

public interface  IBaseView<T>{
    /**
     * @descriptoin	请求数据成功
     * @author	黄士鹏
     * @param tData 数据类型
     * @date 2017/12/811:01
     */
    void loadDataSuccess(T tData);

    /**
     * @descriptoin	请求数据错误
     * @author	黄士鹏
     * @date 2017/12/8 11:01
     */
    void loadDataError();

    /**
     * @descriptoin	其他请求数据错误
     * @author	黄士鹏
     * @date 2017/12/8 11:01
     */
    void loadOtherError();
}
