package com.example.demologaop.designpattern.chain_of_responsibility.example.middleware;

/**
 * Base middleware class. 基础验证接口
 */
public abstract class Middleware {
    private Middleware next;


    public Middleware getNext() {
        return this.next;
    }
    
    /**
     * Builds chains of middleware objects
     * 构建对象链（责任链模式核心逻辑）
     * @param first 责任链的起始节点
     * @param chain 后续连接的对象数组
     * @return 返回完整连接后的责任链头节点
     *
     * @implSpec 该方法通过遍历chain参数中的中间件，依次建立链式关系。
     *    最终形成的责任链顺序为：first -> chain[0] -> chain[1] -> ... -> chain[n]
     */
    public static Middleware link(Middleware first, Middleware... chain) {
        // 当前链表头指针
        Middleware head = first;
        for (Middleware middleware : chain) {
            // 建立当前节点与下个节点的链接
            head.next = middleware;
            // 移动头指针到最新节点
            head = middleware;
        }
        // 始终返回初始头节点以支持链式调用
        return first;
    }

    /**
     * 责任链校验核心方法（子类将会实现这个方法）
     *
     * @param email  待验证的用户邮箱
     * @param password 待验证的用户密码
     * @return boolean 校验结果：true-通过验证，false-验证失败
     */
    public abstract boolean check(String email, String password);

    /**
     * Runs check on the next object in chain
     * or ends traversing if we're in
     * last object in chain.
     *  执行链式校验流程
     *  - 存在后续节点：触发下一个中间件的check方法
     *  - 当前已是末节点：终止校验并返回通过(true)
     * @param email 用户邮箱
     * @param password 用户密码
     * @return 校验结果：true-链尾自动通过/false-后续节点校验失败
     */
    protected boolean checkNext(String email, String password) {
        if (this.next == null) {
            return true;
        }
        return this.next.check(email, password);
    }
}
