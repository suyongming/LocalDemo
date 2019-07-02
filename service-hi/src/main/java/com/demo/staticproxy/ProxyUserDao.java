package com.demo.staticproxy;

public class ProxyUserDao implements IUserDao{
    //接收保存目标对象
    private IUserDao target = new UserDao();
//    public ProxyUserDao(IUserDao target){
//        this.target=target;
//    }

    @Override
    public void save() {
        System.out.println("巴扎黑");
        target.save();
    }
}
