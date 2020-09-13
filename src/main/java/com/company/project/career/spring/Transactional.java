package com.company.project.career.spring;

public class Transactional {

    //@Transactional一般使用在小service方法中，不需要使用trycatch异常，当发生RuntimeException 会回滚
    //TransactionAspectSupport.currentTransactionStatus().setRollbackOnly(); //手动开启事务回滚
    //https://www.ibm.com/developerworks/cn/java/j-master-spring-transactional-use/index.html
    //catch了就不生效了

    public static void main(String[] args) {

    }

}
